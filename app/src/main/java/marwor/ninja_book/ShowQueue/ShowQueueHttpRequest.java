package marwor.ninja_book.ShowQueue;

import android.util.JsonReader;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 2017-06-09.
 */

public class ShowQueueHttpRequest {
    //public ArrayList<ShowQueueData> ShowQueueGetRequest(URL url){
      public void ShowQueueGetRequest(URL url){
          HttpURLConnection urlConnectionToUsers = null;
          List <DbBookClass> queueList;
          ShowQueueJsonReader showQueueJsonReader=new ShowQueueJsonReader();

        try{
            urlConnectionToUsers = (HttpURLConnection) url.openConnection();
            urlConnectionToUsers.setRequestMethod("GET");
            InputStream userDataInputStream = urlConnectionToUsers.getInputStream();
            JsonReader reader = new JsonReader(new InputStreamReader(userDataInputStream, "UTF-8"));
            showQueueJsonReader.QueueJsonReader(reader);


            /*reader.beginObject();
            while(reader.hasNext()){
                String name = reader.nextName();
                if(name.equals("Queues list")){
                    reader.beginArray();
                    while(reader.hasNext()){
                      queueList.add(readMessage(reader));



                        }
                    }
                }

            }
*/

        } catch (IOException e) {
            e.printStackTrace();
        }
      }

}


