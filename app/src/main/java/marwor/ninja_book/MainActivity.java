package marwor.ninja_book;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import marwor.ninja_book.Camera.CameraActivity;
import marwor.ninja_book.MyBooks.MyBooks;
import marwor.ninja_book.SearchBook.SearchBook;
import marwor.ninja_book.ShowQueue.ShowQueue;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {


    private Button buttonBorrow;
    private Button buttonReturn;
    private Button buttonQueue;
    private Button buttonSearch;
    private Button buttonComment;
    private Button buttonMyBooks;
    private Intent clickToAction;
    private static boolean isUserLogin=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        buttonBorrow=(Button) findViewById(R.id.borrow);
        buttonReturn=(Button) findViewById(R.id.returnBook);
        buttonQueue=(Button) findViewById(R.id.queue);
        buttonSearch=(Button) findViewById(R.id.searchBook);
        buttonComment=(Button) findViewById(R.id.comment);
        buttonMyBooks=(Button) findViewById(R.id.myBooks);
        buttonBorrow.setOnClickListener(this);
        buttonReturn.setOnClickListener(this);
        buttonQueue.setOnClickListener(this);
        buttonSearch.setOnClickListener(this);
        buttonComment.setOnClickListener(this);
        buttonMyBooks.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.borrow:
                clickToAction= new Intent(this, CameraActivity.class);
                clickToAction.putExtra("nextActivity","Borrow");
                startActivity(clickToAction);
                break;
            case R.id.returnBook:
                clickToAction= new Intent(this, CameraActivity.class);
                clickToAction.putExtra("nextActivity","Return");
                startActivity(clickToAction);
                break;
            case R.id.queue:
                clickToAction= new Intent(this, ShowQueue.class);
                startActivity(clickToAction);
                break;
            case R.id.searchBook:
                clickToAction= new Intent(this, SearchBook.class);
                startActivity(clickToAction);
                break;
            case R.id.myBooks:
                clickToAction= new Intent(this, MyBooks.class);
                startActivity(clickToAction);
                break;
            case R.id.comment:
                clickToAction= new Intent(this, AddComment.class);
                startActivity(clickToAction);
                break;

            default:
                break;
        }
    }
}
