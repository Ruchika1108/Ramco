package com.example.hp.ramco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerDetailsPage extends AppCompatActivity {
    Button next;
    EditText customerName, companyName, companyAddress, city, pincode,emailAddress,mailingAddress, mobileNumber, phoneNumber;
    String emailPattern="[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}"+
            "\\@" +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
            "(" +
            "\\." +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
            ")+";

    DatabaseHelper myDB;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details_page);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        myDB=new DatabaseHelper(this);

        customerName=(EditText)findViewById(R.id.customerName);
        companyName=(EditText)findViewById(R.id.companyName);
        companyAddress=(EditText)findViewById(R.id.companyAddress);
        city=(EditText)findViewById(R.id.city);
        pincode=(EditText)findViewById(R.id.pincode);
        emailAddress=(EditText)findViewById(R.id.email);
        mailingAddress=(EditText)findViewById(R.id.mailingAddress);
        mobileNumber=(EditText)findViewById(R.id.mobile);
        phoneNumber=(EditText)findViewById(R.id.phone);
        next=(Button)findViewById(R.id.button);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(customerName.getText().toString().length()==0) {
                    customerName.setError("Enter valid name");
                    customerName.requestFocus();
                }
                else if(companyName.getText().toString().length()==0){
                    companyName.setError("Enter valid company name");
                    companyName.requestFocus();
                }
                else if(companyAddress.getText().toString().length()==0){
                    companyAddress.setError("Enter valid address");
                    companyAddress.requestFocus();
                }
                else if(city.getText().toString().length()==0){
                    city.setError("Enter valid city");
                    city.requestFocus();
                }
                else if(pincode.getText().toString().length()==0){
                    pincode.setError("Enter valid pincode");
                    pincode.requestFocus();
                }
                else if(!validateEmail(emailAddress.getText().toString()) || emailAddress.getText().toString().length()==0){
                    emailAddress.setError("Enter valid email address");
                    emailAddress.requestFocus();
                }
               else if(!validateMailing(mailingAddress.getText().toString()) || mailingAddress.getText().toString().length()==0){
                    mailingAddress.setError("Enter valid mailing address");
                    mailingAddress.requestFocus();
                }

                else if(mobileNumber.getText().toString().length()==0 || mobileNumber.getText().toString().length()!=10){
                    mobileNumber.setError("Enter valid mobile number");
                    mobileNumber.requestFocus();
                }
                else if(phoneNumber.getText().toString().length()==0){
                    phoneNumber.setError("Enter valid work phone number");
                    phoneNumber.requestFocus();
                }
                else{
                    boolean isInserted=myDB.insertData(customerName.getText().toString(),companyName.getText().toString(),companyAddress.getText().toString(),city.getText().toString(),pincode.getText().toString(),emailAddress.getText().toString(),mailingAddress.getText().toString(),mobileNumber.getText().toString(),phoneNumber.getText().toString());
                if(isInserted) {
                    Toast.makeText(CustomerDetailsPage.this, "Data Inserted", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplication(),ProductDetailsPage.class));
                }
                else {
                    Toast.makeText(CustomerDetailsPage.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplication(),FailurePage.class));
                }
                }


            }
        });

    }

    private boolean validateEmail(String emailAddress) {
        Pattern pattern=Pattern.compile(emailPattern);
        Matcher matcher=pattern.matcher(emailAddress);

        return matcher.matches();
    }

    private boolean validateMailing(String mailingAddress) {
        Pattern pattern=Pattern.compile(emailPattern);
        Matcher matcher=pattern.matcher(mailingAddress);

        return matcher.matches();
    }

}
