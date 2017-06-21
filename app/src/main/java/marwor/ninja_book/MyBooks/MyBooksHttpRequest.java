package marwor.ninja_book.MyBooks;

import android.util.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import marwor.ninja_book.ShowQueue.QueueBookClass;
import marwor.ninja_book.ShowQueue.ShowQueueJsonReader;

/**
 * Created by Marcin_stacjonarny on 2017-06-20.
 */

public class MyBooksHttpRequest {
    public ArrayList<MyBooksBookClass> MyBooksGetRequest(URL url){

        HttpURLConnection urlConnectionToUsers = null;
        ArrayList <MyBooksBookClass> myBooksList=new ArrayList<>();
        MyBooksJsonReader myBooksJsonReader=new MyBooksJsonReader();

        try{
            urlConnectionToUsers = (HttpURLConnection) url.openConnection();
            urlConnectionToUsers.setRequestMethod("GET");
            InputStream userDataInputStream = urlConnectionToUsers.getInputStream();
            JsonReader reader = new JsonReader(new InputStreamReader(userDataInputStream, "UTF-8"));
            myBooksList=myBooksJsonReader.BookListJsonReader(reader);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return myBooksList;
}
}
