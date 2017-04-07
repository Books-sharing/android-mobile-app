package marwor.ninja_book;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ShowQueue extends AppCompatActivity {
    private ArrayList<ShowQueueData> list;
    private ListView ShowQueueList;
    private ListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_queue);
        list=new ArrayList<>();
        list.add(new ShowQueueData("AMAMAMAM",4));
        list.add(new ShowQueueData("ewrwer",5));
        list.add(new ShowQueueData("Avcxzvc",1));
        list.add(new ShowQueueData("gjsdfhgkjsdhkj",10));

        ShowQueueList = (ListView)findViewById(R.id.ShowQueueList);
        adapter = new ListAdapter(list,getApplicationContext());
        ShowQueueList.setAdapter(adapter);

    }
}
