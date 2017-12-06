package marwor.ninja_book.SearchBook;

import android.content.Context;
import android.util.Log;

import java.net.MalformedURLException;
import java.net.URL;

import marwor.ninja_book.R;

/**
 * Created by Marcin_stacjonarny on 2017-11-22.
 */

public class UrlToSearch {
    private URL url=null;

    public UrlToSearch(Context context,String searchString){
        try{
            url= new URL(context.getString(R.string.url_to_search)+searchString);
        }catch (MalformedURLException e){
            Log.d("Ninjabook","urlToSearch");
        }

    }

    public URL getUrl() {
        return url;
    }
}
