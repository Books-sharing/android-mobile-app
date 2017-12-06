package marwor.ninja_book.Borrow;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;


import marwor.ninja_book.Camera.CameraActivity;
import marwor.ninja_book.MainActivity;
import marwor.ninja_book.R;
import marwor.ninja_book.UserData;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import static java.lang.Thread.sleep;


public class BorrowActivity extends AppCompatActivity {
    BorrowTask borrowPutTask;
    int response;
    private ProgressDialog progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrow);
        String bookId=getIntent().getStringExtra("qrResult");
        progressBar = new ProgressDialog(this);
        progressBar.setCancelable(true);
        progressBar.setMessage(getString(R.string.progress_bar_message));
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.show();
        borrowPutTask=new BorrowTask();
        borrowPutTask.execute(bookId);
        borrowPutTask.onPostExecute(response);


    }
    public class BorrowTask extends AsyncTask<String, Void, Integer>{
        BorrowHttpRequest borrowRequest=new BorrowHttpRequest();
        UserData userData=new UserData(getApplicationContext());


        @Override
        protected Integer doInBackground(String ...params) {

            UrlToBorrow urlToBorrow=new UrlToBorrow(getApplicationContext(),params[0]);
            int response=borrowRequest.BorrowPutRequest(urlToBorrow.getUrl(),userData.getToken());


            return response;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);

            if(integer==200){
                BorrowPositiveDialog positiveDialog= new BorrowPositiveDialog();
                positiveDialog.show(getFragmentManager(),"123");
            }if(integer==400){
              BorrowNegativeDialog negativeDialog= new BorrowNegativeDialog();
                negativeDialog.show(getFragmentManager(),"123");
            }

        }
    }
    private class BorrowPositiveDialog extends DialogFragment {
        @Override
                public Dialog onCreateDialog(Bundle savedInstanceState) {

            AlertDialog.Builder borrowPositiveDialog = new AlertDialog.Builder(getActivity());
            borrowPositiveDialog.setMessage(getString(R.string.borrow_positive_dialog))
            .setPositiveButton("OK", new DialogInterface.OnClickListener(){


                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(BorrowActivity.this, MainActivity.class);
                    startActivity(intent);
                }

                }
            );
        return borrowPositiveDialog.create();
        }}
    private class BorrowNegativeDialog extends DialogFragment {
                @Override
                public Dialog onCreateDialog(Bundle savedInstanceState) {

                    AlertDialog.Builder borrowNegativeDialog = new AlertDialog.Builder(getActivity());
                    borrowNegativeDialog.setMessage(getString(R.string.borrow_negative_dialog))
                            .setPositiveButton(getString(R.string.borrow_try_again), new DialogInterface.OnClickListener(){


                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Intent intent = new Intent(BorrowActivity.this, CameraActivity.class);
                                            startActivity(intent);
                                        }

                                     }
                                    );
                    return borrowNegativeDialog.create();

        }

    }

}

