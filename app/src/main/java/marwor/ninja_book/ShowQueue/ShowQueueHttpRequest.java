package marwor.ninja_book.ShowQueue;

import android.util.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by HP on 2017-06-09.
 */

public class ShowQueueHttpRequest {
    public ArrayList<QueueBookClass> ShowQueueGetRequest(URL url){
      //public void ShowQueueGetRequest(URL url){
          HttpURLConnection urlConnectionToUsers = null;
          ArrayList <QueueBookClass> queueList=new ArrayList<>();
          ShowQueueJsonReader showQueueJsonReader=new ShowQueueJsonReader();

        try{
            urlConnectionToUsers = (HttpURLConnection) url.openConnection();
            urlConnectionToUsers.setRequestMethod("GET");
            InputStream userDataInputStream = urlConnectionToUsers.getInputStream();
            JsonReader reader = new JsonReader(new InputStreamReader(userDataInputStream, "UTF-8"));
            queueList=showQueueJsonReader.QueueJsonReader(reader);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return queueList;
      }

}


