package marwor.ninja_book;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Marcin_stacjonarny on 2017-06-07.
 */

public class JsonMaker {

    public JSONObject AuthenticationJson(String email, String password) {

        JSONObject userAuthData = null;
        try {
            userAuthData = new JSONObject();
            userAuthData.put("email", email);
            userAuthData.put("password", password);
        } catch (JSONException e) {
            Log.d("Ninjabook", "ERROR WHILE CREATING AUTHENTICATION JSON" + e.getMessage());
        }
        return userAuthData;
    }
}
