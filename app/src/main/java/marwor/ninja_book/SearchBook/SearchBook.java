package marwor.ninja_book.SearchBook;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import marwor.ninja_book.R;

public class SearchBook extends AppCompatActivity implements View.OnClickListener {
    private EditText searchEditText;
    private String searchText;
    private Button searchButton;
    private SearchTask searchTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_book);
        searchEditText= (EditText) findViewById(R.id.searchBookEditText);
        searchButton=(Button) findViewById(R.id.searchButton);
        searchButton.setOnClickListener(this);
        searchTask = new SearchTask();
    }

    @Override
    public void onClick(View v) {
        searchText=searchEditText.getText().toString();
        searchTask.execute(searchText);
    }


    public class SearchTask extends AsyncTask<String,Void,Void>{

        @Override
        protected Void doInBackground(String... params) {
            SearchBookHttpRequest httpRequest=new SearchBookHttpRequest();
            ArrayList<SearchBookBookClass> result=new ArrayList<SearchBookBookClass>();
            UrlToSearch urlToSearch=new UrlToSearch(getApplicationContext(),params[0]);

            result=httpRequest.searchBookGetRequest(urlToSearch.getUrl());

            Intent intent=new Intent(SearchBook.this,SearchBookShowResultList.class);
            intent.putParcelableArrayListExtra("SearchBookResult",result);
            intent.putExtra("searchList",result);
            startActivity(intent);

            return null;
        }
    }
}
