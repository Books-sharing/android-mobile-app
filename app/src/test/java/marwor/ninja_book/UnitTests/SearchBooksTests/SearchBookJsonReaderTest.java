package marwor.ninja_book.UnitTests.SearchBooksTests;

import android.util.JsonReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import marwor.ninja_book.SearchBook.SearchBookBookClass;
import marwor.ninja_book.SearchBook.SearchBookJsonReader;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Marcin_stacjonarny on 2017-10-19.
 */

public class SearchBookJsonReaderTest {

    private JSONObject prepareJson(){
        JSONObject firstJson=new JSONObject();
        JSONObject secondJson=new JSONObject();
        JSONArray jsonArray=new JSONArray();
        JSONObject finalJson=new JSONObject();
        try {
            firstJson.put("title","FirstTitle");
            firstJson.put("author","FirstAuthor");
            firstJson.put("isbn","FirstIsbn");
            firstJson.put("description","FirstDescription");
            firstJson.put("status","FirstStatus");

            secondJson.put("title","SecondTitle");
            secondJson.put("author","SecondAuthor");
            secondJson.put("isbn","SecondIsbn");
            secondJson.put("description","SecondDescription");
            secondJson.put("status","SecondStatus");


        } catch (JSONException e) {
            e.printStackTrace();
        }
        jsonArray.put(firstJson);
        jsonArray.put(secondJson);

        try {
            finalJson.put("searchResult",jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return finalJson;
    }


    @Test
    public void JsonReaderTest(){
        JSONObject testJson=prepareJson();
        InputStream in= new ByteArrayInputStream(testJson.toString().getBytes());


            JsonReader reader= new JsonReader(new InputStreamReader(in));

        SearchBookJsonReader searchBookJsonReader= new SearchBookJsonReader();
        ArrayList<SearchBookBookClass>list=searchBookJsonReader.SearchBookJsonReader(reader);
        assertThat("Test first title",list.get(1).getTitle(),is("FirstTitle"));
        assertThat("Test second title",list.get(2).getTitle(),is("SecondTitle"));
        assertThat("Test first author",list.get(1).getAuthor(),is("FirstAuthor"));
        assertThat("Test second title",list.get(2).getAuthor(),is("SecondAuthor"));
        assertThat("Test first isbn",list.get(1).getIsbn(),is("FirstIsbn"));
        assertThat("Test second isbn",list.get(2).getIsbn(),is("SecondIsbn"));
        assertThat("Test first description",list.get(1).getDescription(),is("FirstDescription"));
        assertThat("Test second title",list.get(2).getDescription(),is("SecondDescription"));
        assertThat("Test first status",list.get(1).getStatus(),is("FirstStatus"));
        assertThat("Test second status",list.get(2).getStatus(),is("SecondStatus"));
    }

}
