package marwor.ninja_book.Borrow;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;


import marwor.ninja_book.Camera.CameraActivity;
import marwor.ninja_book.MainActivity;
import marwor.ninja_book.R;



public class BorrowActivity extends AppCompatActivity {
    BorrowTask borrowPutTask;
    int response;
    Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrow);
        String bookId=getIntent().getStringExtra("qrResult");
        borrowPutTask=new BorrowTask();
        borrowPutTask.execute(bookId);
        borrowPutTask.onPostExecute(response);


    }
    public class BorrowTask extends AsyncTask<String, Void, Integer>{
        BorrowHttpRequest borrowRequest=new BorrowHttpRequest();
        URL urlToBorrow=null;



        @Override
        protected Integer doInBackground(String ...params) {
            SharedPreferences sharedPref = getSharedPreferences("UserData", Activity.MODE_PRIVATE);

            try{
                urlToBorrow = new URL(getString(R.string.url_to_borrow) + sharedPref.getLong("userId", 2));
            }catch(MalformedURLException e){
                Log.d("Nnjabook","urlconnection");
            }
            int response=borrowRequest.BorrowPutRequest(urlToBorrow,params[0]);


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
    public class BorrowNegativeDialog extends DialogFragment {
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

