package com.sqllitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.lights.LightsManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class DisplayActivity extends AppCompatActivity {
    ListView listView;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        listView = findViewById(R.id.list_view);
//        ArrayList<DetailModel>  arrayList = new ArrayList<DetailModel>();

        DatabaseHandler db = new DatabaseHandler(this);
        ArrayList<DetailModel> detailsarray = db.getAllRecords();

        MyBaseAdapter myBaseAdapter = new MyBaseAdapter(this, detailsarray);
        listView.setAdapter(myBaseAdapter);
        btnAdd = findViewById(R.id.btn_addData);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DisplayActivity.this, AddActivity.class);
                startActivity(i);
            }
        });
////
//        if (detailsarray.size() > 0) {
//            for (int i = 0; i < detailsarray.size(); i++) {
//
//                Log.e("Name====>", detailsarray.get(i).getFirstName());
//            }
//        }
    }
}