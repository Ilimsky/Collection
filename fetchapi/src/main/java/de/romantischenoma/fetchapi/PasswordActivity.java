package de.romantischenoma.fetchapi;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PasswordActivity extends Activity {

    ConnectionClass connectionClass;
    EditText edtpass;
    Button btnlogin;
    ProgressBar pbbar;
    int numberOfRemainingLoginAttempts = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        connectionClass = new ConnectionClass();
        edtpass = findViewById(R.id.edtpass);
        btnlogin = findViewById(R.id.btnlogin);
        pbbar = findViewById(R.id.pbbar);
        pbbar.setVisibility(View.GONE);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DoLogin doLogin = new DoLogin();
                doLogin.execute("");
            }
        });
    }

     public class DoLogin extends AsyncTask<String, String, String>{
        String z = "";
        Boolean isSuccess = false;

        String password = edtpass.getText().toString();

         @Override
         protected void onPreExecute() {
             pbbar.setVisibility(View.VISIBLE);
         }

         @Override
         protected void onPostExecute(String r) {
             pbbar.setVisibility(View.GONE);
             Toast.makeText(PasswordActivity.this, r, Toast.LENGTH_SHORT).show();

             if (isSuccess){
                 //if there is a need to go to WelcomeActivity
                 /*Intent passwordActivityIntent = getIntent();
                 String s = passwordActivityIntent.getStringExtra("name");
                 Intent i = new Intent(PasswordActivity.this, WelcomeActivity.class);
                 i.putExtra("name", s);*/

                 Intent i = new Intent(PasswordActivity.this, WebActivity.class);
                 startActivity(i);
                 finish();
             }else {
                 numberOfRemainingLoginAttempts--;
                 if (numberOfRemainingLoginAttempts == 0){
                     btnlogin.setEnabled(false);
                     try {
                         Thread.sleep(180000);
                         //Toast.makeText(getApplicationContext(), "Подождите 3 минуты", Toast.LENGTH_SHORT).show();
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                     btnlogin.setEnabled(true);
                 }
             }
         }

         @Override
         protected String doInBackground(String... params) {
             if (password.trim().equals("")){
                z = "Please enter password";
             }else {
                 try {
                     Connection con = connectionClass.CONN();
                     if (con == null){
                         z = "Error in connection with SQL server";
                     }else {
                         String query = "select * from Usertbl where Password ='" + password + "'";
                         Statement stmt =con.createStatement();
                         ResultSet rs = stmt.executeQuery(query);

                         if (rs.next()){
                            z = "Password successful";
                            isSuccess = true;
                         }else {
                             z = "Invalid credential";
                             isSuccess = false;
                         }

                     }
                 }catch (Exception ex){
                     isSuccess = false;
                     z = "Exception";
                 }
             }
             return z;
         }
     }
}
