package marwor.ninja_book.Return;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import java.net.MalformedURLException;
import java.net.URL;

import marwor.ninja_book.R;
import marwor.ninja_book.UserData;

/**
 * Created by Marcin_stacjonarny on 2017-11-20.
 */

public class UrlToReturn {
    private URL urlToReturn=null;

    public UrlToReturn(Context context,String bookId){

        Resources res=context.getResources();
        try{
            urlToReturn = new URL(context.getString(R.string.url_to_return)+bookId);
        }catch(MalformedURLException e){
            Log.d("Nnjabook","urlconnection");
        }
    }

    public URL getUrl() {
        return urlToReturn;
    }
}
