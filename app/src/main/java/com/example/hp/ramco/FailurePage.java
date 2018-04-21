package com.example.hp.ramco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FailurePage extends AppCompatActivity {

    Button tryagain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_failure_page);

        tryagain=(Button)findViewById(R.id.tryagain);
    }
    public void tryAgain(View view){
        Intent try1=new Intent(this,CustomerDetailsPage.class);
        startActivity(try1);
    }
}
