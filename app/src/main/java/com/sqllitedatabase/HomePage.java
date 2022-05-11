package com.sqllitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.sqllitedatabase.R.layout.activity_home_page;

public class HomePage extends AppCompatActivity implements View.OnClickListener{
    TextView txtInfo;
    Button logout;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_home_page);
        txtInfo = findViewById(R.id.tv_data);
        logout = findViewById(R.id.tv_logout);
        sharedPreferences = getSharedPreferences("LoginData",MODE_PRIVATE);
        String text_info = sharedPreferences.getString("PREF_KEY_FN","");
        txtInfo.setText(text_info);
        logout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.tv_logout:

                Intent i = new Intent(HomePage.this,OnetimeLoginSharedPref.class);
                startActivity(i);
                finish();
                break;
        }
    }
}