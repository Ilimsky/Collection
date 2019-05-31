package de.romantischenoma.booking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    String a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
         textView = (TextView) findViewById(R.id.business_number);
         button = (Button) findViewById(R.id.button_booking);

         Intent intent = getIntent();
         a = intent.getStringExtra("business number");

         textView.setText(a);

         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intentBooking = new Intent(SecondActivity.this, ThirdActivity.class);
                 startActivity(intentBooking);
             }
         });

    }

}
