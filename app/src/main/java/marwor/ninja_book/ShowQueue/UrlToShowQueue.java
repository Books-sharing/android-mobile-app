package marwor.ninja_book.ShowQueue;

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

public class UrlToShowQueue {
    private URL urlToShowQueue=null;

    public UrlToShowQueue(Context context){
        UserData userData=new UserData(context);
        Resources res=context.getResources();
        try{
            urlToShowQueue = new URL(context.getString(R.string.url_show_queue) + userData.getUserId());
        }catch(MalformedURLException e){
            Log.d("Nnjabook","urlconnection");
        }
    }

    public URL getUrl() {
        return urlToShowQueue;
    }
}

