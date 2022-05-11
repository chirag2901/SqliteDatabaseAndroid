package com.sqllitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {
    EditText eFirstName,eLastName;
    Button btn_update,btn_delete;
   private  DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        eFirstName = findViewById(R.id.efirstName);
        eLastName = findViewById(R.id.elastName);
        db = new DatabaseHandler(this);
        btn_update = findViewById(R.id.tv_update);
        btn_delete = findViewById(R.id.tv_delete);

        Intent i = getIntent();
        String strfn = i.getStringExtra("FN_KEY");
        String strln = i.getStringExtra("LN_KEY");
        String strid = i.getStringExtra("ID_KEY");
        eFirstName.setText(strfn);
        eLastName.setText(strln);

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strfn = eFirstName.getText().toString();
                String strln = eLastName.getText().toString();
                DetailModel detailModel = new DetailModel();
                detailModel.setFirstName(strfn);
                detailModel.setLastName(strln);
                detailModel.setId(strid);
                db.updateRecord(detailModel);
                Intent i = new Intent(UpdateActivity.this,DisplayActivity.class);
                startActivity(i);
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailModel  detailModel = new DetailModel();
                detailModel.setId(strid);
                db.deleteRecord(detailModel);
                Intent i = new Intent(UpdateActivity.this,DisplayActivity.class);
                startActivity(i);
            }
        });


        
    }
}