package marwor.ninja_book.SearchBook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import marwor.ninja_book.R;

public class SearchBookShowResultList extends AppCompatActivity {

    private SearchResultListAdapter adapter;
    private ArrayList<SearchBookBookClass> list;
    private ListView SearchBookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_book_show_result_list);
        list=(ArrayList<SearchBookBookClass>) getIntent().getSerializableExtra("searchList");
        adapter=new SearchResultListAdapter(this,list);
        SearchBookList=(ListView) findViewById(R.id.searchBookList);
        SearchBookList.setAdapter(adapter);

    }
}
