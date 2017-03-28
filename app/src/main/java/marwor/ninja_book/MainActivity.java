package marwor.ninja_book;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    Button buttonBorrow;
    Button buttonReturn;
    Button buttonQueue;
    Button buttonSearch;
    Button buttonComment;
    Intent clickToAction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonBorrow=(Button) findViewById(R.id.borrow);
        buttonReturn=(Button) findViewById(R.id.returnBook);
        buttonQueue=(Button) findViewById(R.id.queue);
        buttonSearch=(Button) findViewById(R.id.searchBook);
        buttonComment=(Button) findViewById(R.id.comment);

        buttonBorrow.setOnClickListener(this);
        buttonReturn.setOnClickListener(this);
        buttonQueue.setOnClickListener(this);
        buttonSearch.setOnClickListener(this);
        buttonComment.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.borrow:
                clickToAction= new Intent(this, CameraActivity.class);
                startActivity(clickToAction);
                break;
            case R.id.returnBook:
                clickToAction= new Intent(this, CameraActivity.class);
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
            case R.id.comment:
                clickToAction= new Intent(this, AddComment.class);
                startActivity(clickToAction);
                //sddf
                break;

            default:
                break;
        }
    }
}
