package de.romantischenoma.sharedpreference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtuserid;
    Button btnlogin;
    SharedPreferences sPref;
    final String SAVED_TEXT = "saved_text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtuserid = findViewById(R.id.edtuserid);
        btnlogin = findViewById(R.id.btnlogin);

        loadUser();

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btnlogin:
                        saveUser();
                        break;
                    default:
                        break;
                }
            }
        });
    }

    void saveUser(){
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, edtuserid.getText().toString());
        ed.commit();
        Toast.makeText(this,"User saved", Toast.LENGTH_SHORT).show();
    }

    void loadUser(){
        sPref = getPreferences(MODE_PRIVATE);
        String savedText = sPref.getString(SAVED_TEXT, "");
        edtuserid.setText(savedText);
        Toast.makeText(this,"User loaded", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveUser();
    }
}
