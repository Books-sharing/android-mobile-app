package marwor.ninja_book.ShowQueue;

import android.util.JsonReader;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP on 2017-06-11.
 */

public class ShowQueueJsonReader {
    public List<DbBookClass> QueueJsonReader(JsonReader reader) {
        List<DbBookClass> queueList=new ArrayList<DbBookClass>();
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
    private DbBookClass getBookforJson(JsonReader reader){
        String orderDate=null;
        String title = null;
        String author = null;
        String isbn = null;
        try {
            reader.beginObject();
            while (reader.hasNext()) {
                String name = reader.nextName();
                 if (name.equals("title")) {
                    title = reader.nextString();
                } else if (name.equals("author")) {
                    author = reader.nextString();
                } else if (name.equals("isbn")) {
                    isbn = reader.nextString();
                } else if(name.equals("orderDate")) {
                    orderDate=reader.nextString();
                }
            }

            reader.endObject();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new DbBookClass(title, author, isbn,orderDate);


    }

    }

