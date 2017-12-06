package marwor.ninja_book.Borrow;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import java.net.MalformedURLException;
import java.net.URL;

import marwor.ninja_book.R;
import marwor.ninja_book.UserData;

/**
 * Created by Marcin_stacjonarny on 2017-11-09.
 */

public class UrlToBorrow {
    private URL urlToBorrow=null;

    public UrlToBorrow(Context context,String bookId){
        UserData userData=new UserData(context);
        Resources res=context.getResources();
        try{
            urlToBorrow = new URL(context.getString(R.string.url_to_borrow) + Long.toString(userData.getUserId())+"/"+"?qrCode="+bookId);
        }catch(MalformedURLException e){

        }
    }

    public URL getUrl() {
        return urlToBorrow;
    }
}
