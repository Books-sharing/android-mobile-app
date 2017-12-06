package marwor.ninja_book.MyBooks;

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

public class UrlToMyBooks {
    private URL urlToMyBooks=null;
    public UrlToMyBooks(Context context){
        UserData userData=new UserData(context);
        Resources res=context.getResources();
        try{
            urlToMyBooks = new URL(context.getString(R.string.url_to_notification) +userData.getUserId() );
        }catch(MalformedURLException e){
            Log.d("Nnjabook","urlconnection");
        }
    }

    public URL getUrl() {
        return urlToMyBooks;
    }
}
