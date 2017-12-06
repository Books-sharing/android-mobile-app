package marwor.ninja_book.MyBooks;

import android.util.JsonReader;

import java.io.IOException;
import java.util.ArrayList;

import marwor.ninja_book.ShowQueue.QueueBookClass;

/**
 * Created by Marcin_stacjonarny on 2017-06-20.
 */

public class MyBooksJsonReader {
    public ArrayList<MyBooksBookClass> BookListJsonReader(JsonReader reader) {
        ArrayList<MyBooksBookClass> myBooksList=new ArrayList<MyBooksBookClass>();
        try {
            reader.beginObject();
            while (reader.hasNext()) {
                String name = reader.nextName();
                if (name.equals("Books list")) {
                    reader.beginArray();
                    while (reader.hasNext()) {
                        myBooksList.add(getBookforJson(reader));
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
        return myBooksList;
    }
    private MyBooksBookClass getBookforJson(JsonReader reader){
        String borrowDate=null;
        String returnDate=null;
        String title = null;
        String author = null;
        String isbn = null;
        Boolean canExtendBorrow=null;
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
                } else if(name.equals("borrowDate")) {
                    borrowDate=reader.nextString();
                }else if(name.equals("expectedReturnDate")) {
                    returnDate=reader.nextString();
                }else if(name.equals("canExtendBorrow")){
                    canExtendBorrow=reader.nextBoolean();
                }else{
                    reader.skipValue();
                }
            }

            reader.endObject();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new MyBooksBookClass(title, author, isbn,borrowDate,returnDate);


    }

}
