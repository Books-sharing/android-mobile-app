package marwor.ninja_book.ShowQueue;

import android.util.JsonReader;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by HP on 2017-06-11.
 */

public class ShowQueueJsonReader {
    public ArrayList<QueueBookClass> QueueJsonReader(JsonReader reader) {
        ArrayList<QueueBookClass> queueList=new ArrayList<QueueBookClass>();
        try {
            reader.beginObject();
            while (reader.hasNext()) {
                String name = reader.nextName();
                if (name.equals("Queues list")) {
                    reader.beginArray();
                    while (reader.hasNext()) {
                        queueList.add(getBookforJson(reader));
                    }
                    reader.endArray();
                }else{
                    reader.skipValue();
                }
            }
            reader.endObject();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return queueList;
    }
    private QueueBookClass getBookforJson(JsonReader reader){
        String orderDate=null;
        String title = null;
        String author = null;
        String isbn = null;
        int id=0;
        int place = -1;
        try {
            reader.beginObject();
            while (reader.hasNext()) {
                String name = reader.nextName();
                 if (name.equals("title")) {
                    title = reader.nextString();
                 }else if (name.equals("author")) {
                     author = reader.nextString();
                 }else if (name.equals("id")) {
                    id= reader.nextInt();
                } else if (name.equals("isbn")) {
                    isbn = reader.nextString();
                } else if(name.equals("orderDate")) {
                    orderDate=reader.nextString();
                }else if(name.equals("positionInQueue")) {
                     place=reader.nextInt();
                 }else{
                     reader.skipValue();
                 }
            }

            reader.endObject();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new QueueBookClass(title, author, isbn,orderDate,place);


    }

    }

