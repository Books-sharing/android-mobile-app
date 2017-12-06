package marwor.ninja_book.SearchBook;




import android.util.JsonReader;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;


import java.net.URL;
import java.util.ArrayList;





/**
 * Created by Marcin_stacjonarny on 2017-10-03.
 */

public class SearchBookHttpRequest {

    public ArrayList<SearchBookBookClass> searchBookGetRequest(URL url){
        HttpURLConnection urlConnectionToSearch = null;
        ArrayList <SearchBookBookClass> searchResult=new ArrayList<SearchBookBookClass>();
        int response;
        SearchBookJsonReader searchBookJsonReader= new SearchBookJsonReader();
        try{
            urlConnectionToSearch = (HttpURLConnection) url.openConnection();
            urlConnectionToSearch.setRequestMethod("GET");
            InputStream searchDataInputStream = urlConnectionToSearch.getInputStream();
            JsonReader reader = new JsonReader(new InputStreamReader(searchDataInputStream, "UTF-8"));
            response=urlConnectionToSearch.getResponseCode();
            if(response==204){
                return searchResult;
            }
            if(response==200){
                searchResult=searchBookJsonReader.SearchBookJsonReader(reader);
                return searchResult;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return searchResult;
    }

}
