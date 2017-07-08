package marwor.ninja_book.Borrow;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;



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
                urlToBorrow = new URL("@string/url_to_borrow" + sharedPref.getLong("userId", 2));
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
                toast = Toast.makeText(getApplicationContext(),"Ksiązka została poprawnie wypożyczona",Toast.LENGTH_LONG);
                toast.show();
            }if(integer==400){
                toast = Toast.makeText(getApplicationContext(),"Ksiązka nie została wypożyczona. Wystąpił bład. Sprónuj ponownie",Toast.LENGTH_LONG);
                toast.show();
            }
            Intent intent = new Intent(BorrowActivity.this, MainActivity.class);
            startActivity (intent);
        }
    }
}
