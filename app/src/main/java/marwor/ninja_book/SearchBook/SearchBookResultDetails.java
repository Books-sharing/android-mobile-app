package marwor.ninja_book.SearchBook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.awt.font.TextAttribute;

import marwor.ninja_book.R;

public class SearchBookResultDetails extends AppCompatActivity {
    private TextView title;
    private TextView author;
    private TextView description;
    private SearchBookBookClass searchBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_book_result_details);
        searchBook=getIntent().getParcelableExtra("SelectedBook");
        title=(TextView) findViewById(R.id.resultDetailsTitle);
        author=(TextView) findViewById(R.id.resultDetailsAuthor);
        description=(TextView) findViewById(R.id.resualtDetailsDescription);
        title.setText(searchBook.getTitle());
        author.setText(searchBook.getAuthor());
        description.setText(searchBook.getDescription());

    }
}
