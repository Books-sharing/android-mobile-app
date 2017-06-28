package marwor.ninja_book.Return;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

import marwor.ninja_book.Borrow.BorrowActivity;
import marwor.ninja_book.MainActivity;
import marwor.ninja_book.R;

public class ReturnActivity extends AppCompatActivity {
    int response;
    Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return_book);
        String bookId=getIntent().getStringExtra("qrResult");
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
                urlToReturn = new URL("http://192.168.1.199:8080/api/borrow/return/");
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
                toast = Toast.makeText(getApplicationContext(),"Ksiązka została poprawnie oddana",Toast.LENGTH_LONG);
                toast.show();
            }if(integer==400){
                toast = Toast.makeText(getApplicationContext(),"Ksiązka nie została oddana. Wystąpił bład. Sprónuj ponownie",Toast.LENGTH_LONG);
                toast.show();
            }
            Intent intent = new Intent(ReturnActivity.this, MainActivity.class);
            startActivity (intent);
        }
    }
}
