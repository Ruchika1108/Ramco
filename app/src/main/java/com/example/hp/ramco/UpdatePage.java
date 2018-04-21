package com.example.hp.ramco;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class UpdatePage extends AppCompatActivity {
    String status="";
    EditText searchNo, Uname, id;
    Button search, update;
    RadioGroup rgg;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_page);
        searchNo=(EditText)findViewById(R.id.etSearch);
        Uname=(EditText)findViewById(R.id.currentcustname);
        id=(EditText)findViewById(R.id.idorder);

        search=(Button)findViewById(R.id.btSearch);
        update=(Button)findViewById(R.id.btnUpdateData);

        rgg=(RadioGroup)findViewById(R.id.radiogroup);


        databaseHelper = new DatabaseHelper(this);


        search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Cursor res = databaseHelper.getAllData1(searchNo.getText().toString());

                Uname.setText(" ");

                id.setText(" ");


                while (res.moveToNext()) {

                    Uname.setText(res.getString(14));

                    id.setText(res.getString(0));

                }
                update.setOnClickListener(new View.OnClickListener() {

                    @Override

                    public void onClick(View view) {

                        databaseHelper.updateData(id.getText().toString(),status);

                    }

                });


            }


        });


    }

    public void radio1(View view) {

        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.radioButton:
                if (checked)
                    status = "Partly Completed";
                break;
            case R.id.radioButton4:
                if (checked)
                    status = "Complete";
                break;
        }


    }
}
