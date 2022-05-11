package com.sqllitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.sqllitedatabase.R.layout.activity_shared_pref;

public class SharedPrefActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtfn,edtln;
    Button btnaddd,btndisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_shared_pref);

        edtfn = findViewById(R.id.edt_fn);
        edtln = findViewById(R.id.edt_ln);
        btnaddd = findViewById(R.id.tv_add);
        btndisplay = findViewById(R.id.tv_display);
        btnaddd.setOnClickListener(this);
        btndisplay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
            switch (v.getId()){
                case R.id.tv_add:
                String strfn = edtfn.getText().toString();
                String strln = edtln.getText().toString();
                    SharedPreferences sharedPreferences = getSharedPreferences("SqlLiteDatabase",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("PREF_KEY_FN",strfn);
                    editor.putString("PREF_KEY_LN",strln);
                    editor.commit();
                    edtfn.setText("");
                    edtln.setText("");

                break;


                case R.id.tv_display:

                    SharedPreferences sharedPreferences1 = getSharedPreferences("SqlLiteDatabase",MODE_PRIVATE);
                    String str_fn = sharedPreferences1.getString("PREF_KEY_FN","");
                    String str_ln = sharedPreferences1.getString("PREF_KEY_LN","");
                    edtfn.setText(str_fn);
                    edtln.setText(str_ln);



                    break;
            }
    }
//
//    public void MyClick(View view) {
//        switch ()
//    }
}