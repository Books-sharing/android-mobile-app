package marwor.ninja_book.ShowQueue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import marwor.ninja_book.R;

public class LoadingActivity extends AppCompatActivity {
    private TextView QRText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        String result=getIntent().getStringExtra("qrResult");
        QRText=(TextView)findViewById(R.id.qrText);
        QRText.setText(result);
    }
}
