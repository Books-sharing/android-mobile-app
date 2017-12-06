package marwor.ninja_book.SearchBook;

import android.util.JsonReader;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Marcin_stacjonarny on 2017-10-04.
 */

public class SearchBookJsonReader {
    public ArrayList <SearchBookBookClass> SearchBookJsonReader(JsonReader reader){
        ArrayList <SearchBookBookClass> readedArray= new ArrayList<>();
        try{
            reader.beginObject();
            while (reader.hasNext()) {
                String name = reader.nextName();
                if (name.equals("searchResult")) {
                    reader.beginArray();
                    while (reader.hasNext()) {
                        readedArray.add(SearchBookBookReader(reader));
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
        return readedArray;
    }
    private SearchBookBookClass SearchBookBookReader(JsonReader reader){
        int id;
        String author=null;
        String title=null;
        String isbn=null;
        String status=null;
        String description=null;
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
                } else if(name.equals("description")) {
                    description=reader.nextString();
                }else if(name.equals("status")) {
                    status=reader.nextString();
                }else{
                    reader.skipValue();
                }
            }

            reader.endObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new SearchBookBookClass(author,title,isbn,status,description);



    }
}

