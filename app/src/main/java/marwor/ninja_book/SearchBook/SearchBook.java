package marwor.ninja_book.SearchBook;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.MalformedURLException;
import java.net.URL;

import marwor.ninja_book.R;

public class SearchBook extends AppCompatActivity implements View.OnClickListener {
    private EditText searchEditText;
    private String searchText;
    private Button searchButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_book);
        searchEditText= (EditText) findViewById(R.id.searchBookEditText);
        searchButton=(Button) findViewById(R.id.searchButton);
        searchButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        searchText=searchEditText.getText().toString();

    }


    public class SearchTask extends AsyncTask<String,Void,Void>{

        @Override
        protected Void doInBackground(String... params) {

            URL urlToSearch;
            try{
                urlToSearch= new URL(getString(R.string.url_to_search)+params[0]);
            }catch (MalformedURLException e){
                Log.d("Ninjabook","urlToSearch");
            }



            return null;
        }
    }
}
