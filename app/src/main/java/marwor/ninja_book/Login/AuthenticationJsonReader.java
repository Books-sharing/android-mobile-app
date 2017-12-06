package marwor.ninja_book.Login;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.JsonReader;

import java.io.IOException;

import marwor.ninja_book.UserData;

/**
 * Created by HP on 2017-06-11.
 */

public class AuthenticationJsonReader {
    public void ReadUserDataJson(android.util.JsonReader reader, Context context){
        UserData userData=new UserData(context);
        try {
            reader.beginObject();
            while (reader.hasNext()) {
                String name = reader.nextName();
                if (name.equals("id")) {
                userData.setUserId(reader.nextLong());
                }
                if (name.equals("firstName")) {
                    userData.setUserFirstName(reader.nextString());
                }
                if (name.equals("lastName")) {
                    userData.setUserLastName(reader.nextString());
                }
                if (name.equals("email")) {
                    userData.setUserEmail(reader.nextString());
                }

            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void ReadTokenJson(JsonReader reader,Context context){
        UserData userData=new UserData(context);

        try {
            reader.beginObject();
            String name = reader.nextName();

            if (name.equals("token")) {
                userData.setToken(reader.nextString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
