package marwor.ninja_book;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import marwor.ninja_book.Camera.CameraActivity;
import marwor.ninja_book.Login.LoginActivity;
import marwor.ninja_book.ShowQueue.ShowQueue;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    public static Context contextOfAplication;
    private Button buttonBorrow;
    private Button buttonReturn;
    private Button buttonQueue;
    private Button buttonSearch;
    private Button buttonComment;
    private Intent clickToAction;
    private static boolean IsUserLogin=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       contextOfAplication=getApplicationContext();
        if(IsUserLogin==false){
            Intent startLoggingActivity=new Intent(this,LoginActivity.class);
            startActivity(startLoggingActivity);
        }
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

                break;

            default:
                break;
        }
    }
}
