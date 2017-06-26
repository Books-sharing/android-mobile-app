package marwor.ninja_book.Return;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Marcin_stacjonarny on 2017-06-26.
 */

public class ReturnJsonMaker {
    public JSONObject ReturnJson(String bookId){
        JSONObject returnData = null;
        try {
            returnData = new JSONObject();
            returnData.put("data", bookId);
        } catch (JSONException e) {
            Log.d("Ninjabook", "ERROR WHILE CREATING RETURN JSON" + e.getMessage());
        }
        return returnData;
    }
}
