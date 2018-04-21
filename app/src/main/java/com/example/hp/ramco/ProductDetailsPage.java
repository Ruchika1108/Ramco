package com.example.hp.ramco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

public class ProductDetailsPage extends AppCompatActivity {
    ElegantNumberButton btn;
    Button placeOrder;
    EditText sizeOfCylinder,areaOfCylinder,typeOfPrinting,mediaOfPrint,width,circumference,diameter,keyWaySize,flangeSize,color;
    DatabaseHelper myDB1;
    String status="Pending";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details_page);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        myDB1 = new DatabaseHelper(this);
        sizeOfCylinder = (EditText) findViewById(R.id.size);
        areaOfCylinder = (EditText) findViewById(R.id.area);
        typeOfPrinting = (EditText) findViewById(R.id.typeOfPrinting);
        mediaOfPrint = (EditText) findViewById(R.id.mediaOfPrint);
        width = (EditText) findViewById(R.id.width);
        circumference = (EditText) findViewById(R.id.circumference);
        diameter = (EditText) findViewById(R.id.boreDiameter);
        keyWaySize = (EditText) findViewById(R.id.keywaysize);
        flangeSize = (EditText) findViewById(R.id.flangeSize);
        color = (EditText) findViewById(R.id.noOfColor);
        placeOrder = (Button) findViewById(R.id.button);

//        int selectedRadioButtonID = rg1.getCheckedRadioButtonId();
//        final RadioButton selectedRadioButton = (RadioButton) findViewById(selectedRadioButtonID);
//    value=selectedRadioButton.getText().toString();

//        int selectedRadioButtonID = rg.getCheckedRadioButtonId();
//        // If nothing is selected from Radio Group, then it return -1
//        if (selectedRadioButtonID != -1) {
//
//            RadioButton selectedRadioButton = (RadioButton) findViewById(selectedRadioButtonID);
//            String selectedRadioButtonText = selectedRadioButton.getText().toString();
//
//            tv_result.setText(selectedRadioButtonText + " selected.");
//        }
//        else{
//            tv_result.setText("Nothing selected from Radio Group.");
//        }


        btn = (ElegantNumberButton) findViewById(R.id.elegantButton);
        btn.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = btn.getNumber();
                Log.e("Num", num);
            }
        });

        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sizeOfCylinder.getText().toString().length() == 0) {
                    sizeOfCylinder.setError("Enter size of cylinder");
                    sizeOfCylinder.requestFocus();
                } else if (areaOfCylinder.getText().toString().length() == 0) {
                    areaOfCylinder.setError("Enter area of cylinder");
                    areaOfCylinder.requestFocus();
                } else if (typeOfPrinting.getText().toString().length() == 0) {
                    typeOfPrinting.setError("Enter type of printing");
                    typeOfPrinting.requestFocus();
                } else if (mediaOfPrint.getText().toString().length() == 0) {
                    mediaOfPrint.setError("Enter media of printing");
                    mediaOfPrint.requestFocus();
                } else if (width.getText().toString().length() == 0) {
                    width.setError("Enter width of cylinder");
                    width.requestFocus();
                } else if (circumference.getText().toString().length() == 0) {
                    circumference.setError("Enter circumference of cylinder");
                    circumference.requestFocus();
                } else if (diameter.getText().toString().length() == 0) {
                    diameter.setError("Enter diameter of cylinder");
                    diameter.requestFocus();
                } else if (keyWaySize.getText().toString().length() == 0) {
                    keyWaySize.setError("Enter key way size");
                    keyWaySize.requestFocus();
                } else if (flangeSize.getText().toString().length() == 0) {
                    flangeSize.setError("Enter flange size");
                    flangeSize.requestFocus();
                } else if (color.getText().toString().length() == 0) {
                    color.setError("Enter color");
                    color.requestFocus();
                } else {
                    boolean isInserted = myDB1.insertData2(status, sizeOfCylinder.getText().toString(), areaOfCylinder.getText().toString(), typeOfPrinting.getText().toString(), mediaOfPrint.getText().toString(), width.getText().toString(), circumference.getText().toString(), diameter.getText().toString(), keyWaySize.getText().toString(), flangeSize.getText().toString(), color.getText().toString(), btn.getNumber());
                    if (isInserted) {
                        Toast.makeText(ProductDetailsPage.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplication(), Thanking_Page.class));
                    } else {
                        Toast.makeText(ProductDetailsPage.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplication(), FailurePage.class));
                    }
                }
            }
        });
    }


}
