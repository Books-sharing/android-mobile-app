package marwor.ninja_book.Login;

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

public class AuthenticationHttpRequests {
    /*AuthenticationPostRequest funtion conect with serwer, sending user email and password in json. If email and password is correct, serwer send to app jwtk token */
    public void AuthenticationPostRequest(URL url, String mail, String password,Context context){
        HttpURLConnection urlConnectionToAuth=null;
        AuthenticationJsonMaker jsonMaker=new AuthenticationJsonMaker();
        AuthenticationJsonReader authenticationJsonReader=new AuthenticationJsonReader();

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
            authenticationJsonReader.ReadTokenJson(reader,context);

        }catch(IOException|IllegalStateException|SecurityException|NullPointerException e){
            Log.d("Ninjabook","httpPostRequest");
        }finally {
            if(urlConnectionToAuth!=null){
                urlConnectionToAuth.disconnect();
            }
        }

    }
public void AutenticationGetRequest(URL url,String token,Context context){
    HttpURLConnection urlConnectionToUsers = null;
    AuthenticationJsonReader authenticationJsonReader=new AuthenticationJsonReader();

    try{
        urlConnectionToUsers = (HttpURLConnection) url.openConnection();
        urlConnectionToUsers.setRequestMethod("GET");
        urlConnectionToUsers.setRequestProperty("Authorization","Bearer "+token);

        InputStream userDataInputStream = urlConnectionToUsers.getInputStream();
        JsonReader reader = new JsonReader(new InputStreamReader(userDataInputStream, "UTF-8"));
        authenticationJsonReader.ReadUserDataJson(reader,context);



    }catch(IOException|IllegalStateException|SecurityException|NullPointerException e){
        Log.d("Ninjabook","httpGetRequest"+e.getMessage());
    }finally {
        if(urlConnectionToUsers!=null){
            urlConnectionToUsers.disconnect();
        }

}

}

}
