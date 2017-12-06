package marwor.ninja_book.Return;

import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Marcin_stacjonarny on 2017-06-26.
 */

public class ReturnHttpRequest {


    public int ReturnPostRequest(URL url,String token){


        HttpURLConnection urlConnectionToReturn = null;
        int response=0;
        try {
            urlConnectionToReturn = (HttpURLConnection) url.openConnection();
            urlConnectionToReturn.setRequestMethod("POST");
            urlConnectionToReturn.setRequestProperty("Authorization","Bearer "+token);

            response=urlConnectionToReturn.getResponseCode();


        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }
}
