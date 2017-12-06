package marwor.ninja_book;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Marcin_stacjonarny on 2017-11-07.
 */

public class UserData {
    private Context context;
    public UserData(Context context){
        this.context=context;
    }
    public void setToken(String token) {
        SharedPreferences sharedPref = context.getSharedPreferences("UserData", context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("token", token);
        editor.commit();
    }

    public void setUserId(Long userId) {
        SharedPreferences sharedPref = context.getSharedPreferences("UserData", context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putLong("userId", userId);
        editor.commit();
    }

    public void setUserFirstName(String userFirstName) {
        SharedPreferences sharedPref = context.getSharedPreferences("UserData", context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("userFirstName", userFirstName);
        editor.commit();
    }

    public void setUserLastName(String userLastName) {
        SharedPreferences sharedPref = context.getSharedPreferences("UserData", context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("userLastName", userLastName);
        editor.commit();
    }

    public void setUserEmail(String userEmail) {
        SharedPreferences sharedPref = context.getSharedPreferences("UserData", context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("userEmail",userEmail);
        editor.commit();
    }

    public String getToken(){
        SharedPreferences sharedPref = context.getSharedPreferences("UserData", context.MODE_PRIVATE);
        return sharedPref.getString("token","");

    }
    public long getUserId() {
        SharedPreferences sharedPref = context.getSharedPreferences("UserData", context.MODE_PRIVATE);
        return sharedPref.getLong("userId", 0);


    }

    public String getUserFirstName() {
        SharedPreferences sharedPref = context.getSharedPreferences("UserData", context.MODE_PRIVATE);
        return sharedPref.getString("userFirstName", "");
    }

    public String getUserLastName() {
        SharedPreferences sharedPref = context.getSharedPreferences("UserData", context.MODE_PRIVATE);
        return sharedPref.getString("userLastName", "");
    }

    public String getUserEmail() {
        SharedPreferences sharedPref = context.getSharedPreferences("UserData", context.MODE_PRIVATE);
        return sharedPref.getString("userEmail", "");
    }



}
