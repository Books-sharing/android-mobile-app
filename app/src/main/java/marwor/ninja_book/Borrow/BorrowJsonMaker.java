package marwor.ninja_book.Borrow;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Marcin_stacjonarny on 2017-06-25.
 */

public class BorrowJsonMaker {
    public JSONObject BorrowJson(String bookID){
        JSONObject BorrowData = null;
        try {
            BorrowData = new JSONObject();
            BorrowData.put("data", bookID);
            } catch (JSONException e) {
            Log.d("Ninjabook", "ERROR WHILE CREATING BORROW JSON" + e.getMessage());
        }
        return BorrowData;
    }
}
