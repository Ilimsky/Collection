package de.romantischenoma.fetchapi;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
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

import static android.provider.ContactsContract.Intents.Insert.NAME;

public class LoginActivity extends Activity {

    ConnectionClass connectionClass;
    EditText edtuserid;
    Button btnlogin;
    ProgressBar pbbar;
    SharedPreferences sPref;
    final String SAVED_USER ="saved_user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        connectionClass = new ConnectionClass();
        edtuserid = findViewById(R.id.edtuserid);
        btnlogin = findViewById(R.id.btnlogin);
        pbbar = findViewById(R.id.pbbar);
        pbbar.setVisibility(View.GONE);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DoLogin doLogin = new DoLogin();
                doLogin.execute("");
                switch (v.getId()){
                    case R.id.btnlogin:
                        saveUser();
                        break;
                    default:
                        break;
                }
            }
        });
        //loadUser();
    }


    void saveUser(){
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_USER, edtuserid.getText().toString());
        ed.commit();
    }

    void loadUser(){
        sPref = getPreferences(MODE_PRIVATE);
        String savedUser = sPref.getString(SAVED_USER, "");
        edtuserid.setText(savedUser);
        if (!savedUser.equals("")){
            Intent intent = new Intent(LoginActivity.this, WelcomeActivity.class);
            intent.putExtra(NAME, savedUser);
            startActivity(intent);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveUser();
    }

    public class DoLogin extends AsyncTask<String,String,String> {
        String z = "";
        Boolean isSuccess = false;

        String userid = edtuserid.getText().toString();

        @Override
        protected void onPreExecute() {
            pbbar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String r) {
            pbbar.setVisibility(View.GONE);
            Toast.makeText(LoginActivity.this,r,Toast.LENGTH_SHORT).show();

            if(isSuccess) {
                Intent i = new Intent(LoginActivity.this, PasswordActivity.class);
                i.putExtra("name", userid);
                startActivity(i);
                finish();
            }
        }

        @Override
        protected String doInBackground(String... params) {
            if(userid.trim().equals(""))
                z = "Please enter User Id";
            else{
                try {
                    Connection con = connectionClass.CONN();
                    if (con == null) {
                        z = "Error in connection with SQL server";
                    } else {
                        String query = "select * from Usertbl where UserId ='" + userid + "'";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(query);

                        if(rs.next())
                        {

                            z = "Login successfull";
                            isSuccess=true;
                        }
                        else
                        {
                            z = "Invalid Credentials";
                            isSuccess = false;
                        }

                    }
                }
                catch (Exception ex)
                {
                    isSuccess = false;
                    z = "Exceptions";
                }
            }
            return z;
        }
    }
}