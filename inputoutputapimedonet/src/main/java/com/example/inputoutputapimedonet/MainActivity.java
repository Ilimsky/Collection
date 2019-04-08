package com.example.inputoutputapimedonet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private Button getBtn;
    private EditText editTextInput;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getBtn = findViewById(R.id.getBtn);
        editTextInput = findViewById(R.id.input);
        result = findViewById(R.id.result);

        getBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWebsite();
            }
        });
    }

    private void getWebsite(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                final StringBuilder builder = new StringBuilder();

                int a = Integer.parseInt(editTextInput.getText().toString());
                int output;

                String content = null;
                URLConnection connection = null;
                try {
                    connection =  new URL("http://hanzo95-001-site1.dtempurl.com/api/apitest/" + a).openConnection();
                    Scanner scanner = new Scanner(connection.getInputStream());
                    scanner.useDelimiter("\\Z");
                    content = scanner.next();
                    scanner.close();
                }catch ( Exception ex ) {
                    ex.printStackTrace();
                }
                String s = content.replace("\"","");
                output = Integer.parseInt(s);
                builder.append(output);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        result.setText(builder.toString()); // вывод в TextView
                    }
                });
            }
        }).start();
    }
}
