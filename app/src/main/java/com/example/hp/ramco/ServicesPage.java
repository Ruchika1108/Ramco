package com.example.hp.ramco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ServicesPage extends AppCompatActivity {
    Button placeAnOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_page);
        placeAnOrder=(Button)findViewById(R.id.button3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void PlaceAnOrder(View view){
        Intent i2=new Intent(this,CustomerDetailsPage.class);
        startActivity(i2);
    }
}
