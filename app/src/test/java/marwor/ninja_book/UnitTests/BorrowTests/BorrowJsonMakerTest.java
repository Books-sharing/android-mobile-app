package marwor.ninja_book.UnitTests.BorrowTests;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import marwor.ninja_book.Borrow.BorrowJsonMaker;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

/**
 * Created by Marcin_stacjonarny on 2017-09-19.
 */

public class BorrowJsonMakerTest {
    private String BookID="11111";
    private String jsonResult;
@Test
    public void BorrowJsonMakerTest(){
    BorrowJsonMaker borrowJsonMaker=new BorrowJsonMaker();
    JSONObject testJson=borrowJsonMaker.BorrowJson(BookID);
    try {
         jsonResult= testJson.getString("data");
    }catch(JSONException e){
        Log.d("BorrowJsonMakerTests", "error while reading json" + e.getMessage());
    }
        assertThat("Test Borrow Json",jsonResult,is(BookID));
}
}
