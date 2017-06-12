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
    private ArrayList<ShowQueueData> list;
    private ListView ShowQueueList;
    private ListAdapter adapter;
    GetingQueueDataTask getingQueueDataTask=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_queue);





        /*list=new ArrayList<>();
        list.add(new ShowQueueData(sharedPref.getString("userFirstName","error"),4));
        list.add(new ShowQueueData("ewrwer",5));
        list.add(new ShowQueueData("Avcxzvc",1));
        list.add(new ShowQueueData("gjsdfhgkjsdhkj",10));

        ShowQueueList = (ListView)findViewById(R.id.ShowQueueList);
        adapter = new ListAdapter(list,getApplicationContext());
        ShowQueueList.setAdapter(adapter);*/

    }

    @Override
    protected void onResume() {
        super.onResume();
        getingQueueDataTask=null;
        getingQueueDataTask=new GetingQueueDataTask();
        getingQueueDataTask.execute();

    }

    public class GetingQueueDataTask extends AsyncTask<Void, Void, Boolean>{

        @Override
        protected Boolean doInBackground(Void... params) {
            SharedPreferences sharedPref = getSharedPreferences("UserData", Activity.MODE_PRIVATE);
            ShowQueueHttpRequest showQueueHttpRequest=new ShowQueueHttpRequest();
            URL urlToNotification=null;

            try{
                urlToNotification = new URL("http://192.168.1.65:8080/api/notification/" + sharedPref.getLong("userId", 0));
            }catch(MalformedURLException e){
                Log.d("Nnjabook","urlconnection");
            }
            showQueueHttpRequest.ShowQueueGetRequest(urlToNotification);


            return null;
        }
    }
}
