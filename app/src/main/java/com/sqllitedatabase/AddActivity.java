package com.sqllitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {
    EditText firstName;
    EditText lastName;
    Button add,display;
    private DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        firstName = (EditText)findViewById(R.id.firstName);
        lastName = (EditText)findViewById(R.id.lastName);
        add = (Button) findViewById(R.id.tv_add);
        display = (Button) findViewById(R.id.tv_display);
        db = new DatabaseHandler(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fName =firstName.getText().toString();
                String lName = lastName.getText().toString();
                Toast.makeText(AddActivity.this, "User"+fName+" "+lName, Toast.LENGTH_SHORT).show();
//
                DetailModel detailModel = new DetailModel();
                detailModel.setFirstName(fName);
                detailModel.setLastName(lName);
                db.insertRecord(detailModel);
                firstName.setText("");
                lastName.setText("");
                Intent i = new Intent(AddActivity.this,DisplayActivity.class);

                startActivity(i);
                finish();


            }
        });
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  i = new Intent(AddActivity.this,DisplayActivity.class);
                startActivity(i);
            }
        });
    }
}