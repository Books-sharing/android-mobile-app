package marwor.ninja_book.Login;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.JsonReader;

import java.io.IOException;

/**
 * Created by HP on 2017-06-11.
 */

public class AuthenticationJsonReader {
    public void ReadUserDataJson(android.util.JsonReader reader, Context context){
        SharedPreferences sharedPref = context.getSharedPreferences("UserData", context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        try {
            reader.beginObject();
            while (reader.hasNext()) {
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
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void ReadTokenJson(JsonReader reader,Context context){
        String token=null;
        SharedPreferences sharedPref = context.getSharedPreferences("UserData", context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        try {
            reader.beginObject();
            String name = reader.nextName();

            if (name.equals("token")) {
                token = reader.nextString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        editor.putString("token", token);
        editor.commit();

    }
}
