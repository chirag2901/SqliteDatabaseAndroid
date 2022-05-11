package com.sqllitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class OnetimeLoginSharedPref extends AppCompatActivity implements View.OnClickListener {
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    EditText fn,ln,pwd;
    Button btnlogin,btnlogout;
    TextView data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onetime_login_shared_pref);
        fn = findViewById(R.id.tv_firstname);
        ln = findViewById(R.id.tv_lastname);
        pwd = findViewById(R.id.tv_password);
        btnlogin = findViewById(R.id.tv_login);
        btnlogout = findViewById(R.id.tv_logout);
//        btnlogout.setOnClickListener(this);
        btnlogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_login:
                String strfn = fn.getText().toString();
                String strln = ln.getText().toString();
                String strpwd  = pwd.getText().toString();
                sharedPref= getSharedPreferences("LoginData",MODE_PRIVATE);
                editor = sharedPref.edit();
                editor.putString("PREF_KEY_FN",strfn);
                editor.putString("PREF_KEY_LN",strln);
                editor.putString("PREF_KEY_PWD",strpwd);
                editor.commit();
                Intent i = new Intent(OnetimeLoginSharedPref.this,HomePage.class);
                startActivity(i);
                break;
        }
    }
}