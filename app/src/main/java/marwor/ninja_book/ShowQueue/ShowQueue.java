package marwor.ninja_book.ShowQueue;

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

public class ShowQueue extends AppCompatActivity {
    private ArrayList<QueueBookClass> list;
    private ListView ShowQueueList;
    private QueueListAdapter adapter;
    GetingQueueDataTask getingQueueDataTask=null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_queue);
        list=new ArrayList<QueueBookClass>();
        ShowQueueList = (ListView)findViewById(R.id.ShowQueueList);



    }

    @Override
    protected void onResume() {
        super.onResume();
        getingQueueDataTask=null;
        getingQueueDataTask=new GetingQueueDataTask();
        getingQueueDataTask.execute();
        getingQueueDataTask.onPostExecute(list);




    }
    public void setList(ArrayList<QueueBookClass> list) {
        this.list = list;
    }

    public class GetingQueueDataTask extends AsyncTask<Void, Void, ArrayList<QueueBookClass>>{

        @Override
        protected ArrayList<QueueBookClass> doInBackground(Void... params) {
            SharedPreferences sharedPref = getSharedPreferences("UserData", Activity.MODE_PRIVATE);
            ShowQueueHttpRequest showQueueHttpRequest=new ShowQueueHttpRequest();
            URL urlToNotification=null;
            ArrayList<QueueBookClass> queueList=new ArrayList<>();
            try{
                urlToNotification = new URL("http://192.168.0.29:8080/api/notification/" + sharedPref.getLong("userId", 0));
            }catch(MalformedURLException e){
                Log.d("Nnjabook","urlconnection");
            }
            queueList=showQueueHttpRequest.ShowQueueGetRequest(urlToNotification);


            return queueList;
        }

        @Override
        protected void onPostExecute(ArrayList<QueueBookClass> list) {
            super.onPostExecute(list);
            adapter = new QueueListAdapter(list,getApplicationContext());
            ShowQueueList.setAdapter(adapter);
        }
    }
}
