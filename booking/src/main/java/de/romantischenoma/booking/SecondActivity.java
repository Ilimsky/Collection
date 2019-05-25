package de.romantischenoma.booking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textView;
    String a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
         textView = (TextView) findViewById(R.id.business_number);

         Intent intent = getIntent();
         a = intent.getStringExtra("business number");

         textView.setText(a);

    }
}
