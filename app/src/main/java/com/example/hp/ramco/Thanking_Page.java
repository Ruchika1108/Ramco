package com.example.hp.ramco;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Thanking_Page extends AppCompatActivity {

//    EditText orderid;
    TextView tv;
    Button ret;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanking__page);
//        orderid=(EditText)findViewById(R.id.orderId);
        tv=(TextView)findViewById(R.id.textView);
        ret=(Button)findViewById(R.id.return1);


    }

    public void return1(View view){
        Intent i4=new Intent(this,HomePage.class);
        startActivity(i4);
    }

}
