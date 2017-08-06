package marwor.ninja_book.Return;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

import marwor.ninja_book.Borrow.BorrowActivity;
import marwor.ninja_book.Camera.CameraActivity;
import marwor.ninja_book.MainActivity;
import marwor.ninja_book.R;

import static java.lang.Thread.sleep;

public class ReturnActivity extends AppCompatActivity {
    int response;
    private ProgressDialog progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return_book);
        String bookId=getIntent().getStringExtra("qrResult");
        progressBar = new ProgressDialog(this);
        progressBar.setCancelable(true);
        progressBar.setMessage(getString(R.string.progress_bar_message));
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.show();
        ReturnTask returnTask=new ReturnTask();
        returnTask.execute(bookId);
        returnTask.onPostExecute(response);

    }
    private class ReturnTask extends AsyncTask<String,Void,Integer>{
        URL urlToReturn;
        ReturnHttpRequest returnRequest=new ReturnHttpRequest();
        Integer response=0;
        @Override
        protected Integer doInBackground(String...params) {
            try{
                urlToReturn = new URL(getString(R.string.url_to_return));
            }catch(MalformedURLException e){
                Log.d("Nnjabook","urlconnection");
            }
            response=returnRequest.ReturnPostRequest(urlToReturn,params[0]);




            return response;
        }
        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            if(integer==200){
                ReturnPositiveDialog positiveDialog= new ReturnPositiveDialog();
                positiveDialog.show(getFragmentManager(),"123");
            }if(integer==400){
                ReturnNegativeDialog negativeDialog= new ReturnNegativeDialog();
                negativeDialog.show(getFragmentManager(),"123");
            }

        }
    }
    private class ReturnPositiveDialog extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            AlertDialog.Builder borrowPositiveDialog = new AlertDialog.Builder(getActivity());
            borrowPositiveDialog.setMessage(getString(R.string.return_positive_dialog))
                    .setPositiveButton("OK", new DialogInterface.OnClickListener(){


                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(ReturnActivity.this, MainActivity.class);
                                    startActivity(intent);
                                }

                            }
                    );
            return borrowPositiveDialog.create();
        }}
    public class ReturnNegativeDialog extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            AlertDialog.Builder borrowNegativeDialog = new AlertDialog.Builder(getActivity());
            borrowNegativeDialog.setMessage(getString(R.string.return_negative_dialog))
                    .setPositiveButton(getString(R.string.return_try_again), new DialogInterface.OnClickListener(){


                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(ReturnActivity.this, CameraActivity.class);
                                    startActivity(intent);
                                }

                            }
                    );
            return borrowNegativeDialog.create();

        }

    }
}
