package marwor.ninja_book.Login;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import java.net.MalformedURLException;
import java.net.URL;

import marwor.ninja_book.R;

/**
 * Created by Marcin_stacjonarny on 2017-11-05.
 */

public class UrlToAuthorization {
    private URL urlToAuth=null;
    public UrlToAuthorization(Context context){
        Resources res=context.getResources();
        try{
            urlToAuth = new URL(res.getString(R.string.url_to_auth));
        }catch(MalformedURLException e){
            Log.d("Nnjabook","urlconnection");
        }
    }
    public URL getUrl(){
        return urlToAuth;
    }
}
