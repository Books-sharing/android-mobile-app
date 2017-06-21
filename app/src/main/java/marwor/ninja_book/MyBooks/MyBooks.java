package marwor.ninja_book.MyBooks;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import marwor.ninja_book.R;
import marwor.ninja_book.ShowQueue.QueueBookClass;
import marwor.ninja_book.ShowQueue.QueueListAdapter;
import marwor.ninja_book.ShowQueue.ShowQueueHttpRequest;

public class MyBooks extends AppCompatActivity {
    private ArrayList<MyBooksBookClass> list;
    private ListView MyBooksList;
    private MyBooksListAdapter adapter;
    GetingBooksDataTask getingBooksDataTask=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_books);

        list=new ArrayList<MyBooksBookClass>();
        MyBooksList = (ListView)findViewById(R.id.MyBooksList);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getingBooksDataTask=null;
        getingBooksDataTask=new GetingBooksDataTask();
        getingBooksDataTask.execute();
        getingBooksDataTask.onPostExecute(list);
    }



    public class GetingBooksDataTask extends AsyncTask<Void, Void, ArrayList<MyBooksBookClass>> {

        @Override
        protected ArrayList<MyBooksBookClass> doInBackground(Void... params) {
            SharedPreferences sharedPref = getSharedPreferences("UserData", Activity.MODE_PRIVATE);
            MyBooksHttpRequest myBooksHttpRequest=new MyBooksHttpRequest();
            URL urlToNotification=null;
            ArrayList<MyBooksBookClass> myBooksList=new ArrayList<>();
            try{
                urlToNotification = new URL("http://192.168.0.29:8080/api/notification/" + sharedPref.getLong("userId", 0));
            }catch(MalformedURLException e){
                Log.d("Nnjabook","urlconnection");
            }
            myBooksList=myBooksHttpRequest.MyBooksGetRequest(urlToNotification);


            return myBooksList;
        }

        @Override
        protected void onPostExecute(ArrayList<MyBooksBookClass> list) {
            super.onPostExecute(list);
            adapter = new MyBooksListAdapter(list,getApplicationContext());
            MyBooksList.setAdapter(adapter);
        }
    }
}
