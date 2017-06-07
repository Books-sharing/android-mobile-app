package marwor.ninja_book;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.JsonReader;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Marcin_stacjonarny on 2017-06-07.
 */

public class HttpRequests {
    /*AuthenticationPostRequest funtion conect with serwer, sending user email and password in json. If email and password is correct, serwer send to app jwtk token */
    public String AuthenticationPostRequest(URL url, String mail, String password){
        HttpURLConnection urlConnectionToAuth=null;
        String token=null;
        JsonMaker jsonMaker=new JsonMaker();
        try{
            urlConnectionToAuth = (HttpURLConnection) url.openConnection();
            urlConnectionToAuth.setDoOutput(true);
            urlConnectionToAuth.setRequestMethod("POST");
            urlConnectionToAuth.setRequestProperty("Content-Type", "application/json");
            urlConnectionToAuth.setChunkedStreamingMode(0);

            JSONObject userAuthData = jsonMaker.AuthenticationJson(mail,password);

            DataOutputStream outAuthData = new DataOutputStream(urlConnectionToAuth.getOutputStream());
            outAuthData.writeBytes(userAuthData.toString());
            outAuthData.flush();
            outAuthData.close();
            InputStream tokenInputStream = new BufferedInputStream(urlConnectionToAuth.getInputStream());
            JsonReader reader = new JsonReader(new InputStreamReader(tokenInputStream, "UTF-8"));
            reader.beginObject();
            String name = reader.nextName();

            if (name.equals("token")) {
                token = reader.nextString();
            }


        }catch(IOException|IllegalStateException|SecurityException|NullPointerException e){
            Log.d("Ninjabook","httprequest");
        }finally {
            if(urlConnectionToAuth!=null){
                urlConnectionToAuth.disconnect();
            }
        }
        return token;
    }



}
