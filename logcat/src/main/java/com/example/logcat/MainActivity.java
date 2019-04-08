package com.example.logcat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String string = "String";

    TextView tvOut;
    Button btnOk;
    Button btnCancel;

    private static final String TAG = "MyLogs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvOut = findViewById(R.id.tvOut);
        btnOk = findViewById(R.id.btnOk);
        btnCancel = findViewById(R.id.btnCancel);

        btnOk.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "по id определяем кнопку, вызвавшую этот обработчик");
        switch (v.getId()){
            case R.id.btnOk:
                Log.d(TAG, "Кнопка OK");
                tvOut.setText("Нажата кнопка ОК");
                Toast.makeText(this, "Вы нажали кнопку OK", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnCancel:
                Log.d(TAG, "Кнопка Cancel");
                tvOut.setText("Нажата кнопка Cancel");
                Toast.makeText(this, "Вы нажали кнопку Cancel", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
