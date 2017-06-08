package marwor.ninja_book.Login;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.JsonReader;
import android.util.Log;

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
    public void AuthenticationPostRequest(URL url, String mail, String password,Context context){
        HttpURLConnection urlConnectionToAuth=null;
        String token=null;
        JsonMaker jsonMaker=new JsonMaker();
        SharedPreferences sharedPref = context.getSharedPreferences("UserData", context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
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
            Log.d("Ninjabook","httpPostRequest");
        }finally {
            if(urlConnectionToAuth!=null){
                urlConnectionToAuth.disconnect();
            }
            editor.putString("token", token);
            editor.commit();
        }

    }
public void AutenticationGetRequest(URL url,String token,Context context){
    HttpURLConnection urlConnectionToUsers = null;
    SharedPreferences sharedPref = context.getSharedPreferences("UserData", context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPref.edit();
    try{
        urlConnectionToUsers = (HttpURLConnection) url.openConnection();
        urlConnectionToUsers.setRequestMethod("GET");
        urlConnectionToUsers.setRequestProperty("Authorization","Bearer "+token);

        InputStream userDataInputStream = urlConnectionToUsers.getInputStream();
        JsonReader reader = new JsonReader(new InputStreamReader(userDataInputStream, "UTF-8"));
        reader.beginObject();
        while(reader.hasNext()){
            String name = reader.nextName();
            if (name.equals("id")) {
                editor.putLong("userId", reader.nextLong());
                editor.commit();
            }
            if (name.equals("firstName")) {
                editor.putString("userFirstName", reader.nextString());
                editor.commit();
            }
            if (name.equals("lastName")) {
                editor.putString("userLastName", reader.nextString());
                editor.commit();
            }
            if (name.equals("email")) {
                editor.putString("userEmail", reader.nextString());
                editor.commit();
            }

        }


    }catch(IOException|IllegalStateException|SecurityException|NullPointerException e){
        Log.d("Ninjabook","httpGetRequest"+e.getMessage());
    }finally {
        if(urlConnectionToUsers!=null){
            urlConnectionToUsers.disconnect();
        }

}

}
}
