package marwor.ninja_book.Borrow;



import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.IOException;

import java.net.HttpURLConnection;

import java.net.URL;

import marwor.ninja_book.UserData;

/**
 * Created by Marcin_stacjonarny on 2017-06-25.
 */

public class BorrowHttpRequest {
    HttpURLConnection urlConnectionToBorrow = null;

    public int BorrowPutRequest(URL url,String token){
        int response=0;
        try {
            urlConnectionToBorrow = (HttpURLConnection) url.openConnection();
            urlConnectionToBorrow.setRequestMethod("POST");
            urlConnectionToBorrow.setRequestProperty("Authorization","Bearer "+token);
            urlConnectionToBorrow.setChunkedStreamingMode(0);

            response=urlConnectionToBorrow.getResponseCode();


        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

}
