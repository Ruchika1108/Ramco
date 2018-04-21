package com.example.hp.ramco;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class LoginPage extends AppCompatActivity {
    EditText pass;
    Button vieworder,updatestatus;
    DatabaseHelper myDB2;
    final String pass1="adminpassword";
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        myDB2=new DatabaseHelper(this);
        pass=(EditText)findViewById(R.id.password);
        vieworder=(Button)findViewById(R.id.button7);
        updatestatus=(Button)findViewById(R.id.button8);

        updatestatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pass.getText().toString().equals(pass1)){
                    Intent intent=new Intent(LoginPage.this,UpdatePage.class);
                    startActivity(intent);
                }
                else{
                    pass.setError("Invalid Password");
                }
            }
        });

        viewAll();

//        vieworder.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(pass.getText().toString().equals(pass1)){
//                    startActivity(new Intent(getApplication(),ViewOrder.class));
//                }
//                else{
//                    pass.setError("Password is Incorrect");
//                }
//            }
//        });

    }


    public void viewAll()
    {
        vieworder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                final RadioButton pending = new RadioButton(LoginPage.this);
//                final RadioButton complete = new RadioButton(LoginPage.this);
//                final RadioGroup rg2 = new RadioGroup(LoginPage.this);
//                final Button update = new Button(LoginPage.this);
//                final LinearLayout linearLayout = new LinearLayout(LoginPage.this);
//                builder = new AlertDialog.Builder(LoginPage.this);
//                pending.setText("Pending");
//                complete.setText("Complete");
//                update.setText("UPDATE");
//                rg2.addView(pending);
//                rg2.addView(complete);
//                linearLayout.setBackgroundColor(0xFFFFFFFF);
//                linearLayout.setOrientation(LinearLayout.VERTICAL);
//                linearLayout.addView(rg2);
//                linearLayout.addView(update);
//                builder.setView(linearLayout);


                Cursor res=myDB2.getAllData();//res have some property
                if(res.getCount()==0)
                {
                    showMessage("Error","No data to show");
                    return;
                }
                else if(pass.getText().toString().equals(pass1))
                {
//create some string buffer
//                    Bundle bundle=new Bundle();
                    StringBuffer buffer=new StringBuffer();
                    while (res.moveToNext()){
                        buffer.append("\nID:"+res.getString(0)+"\n");
                        buffer.append("CustomerName:"+res.getString(14)+"\n");
                        buffer.append("CompanyName:"+res.getString(15)+"\n");
                        buffer.append("MobileNumber:"+res.getString(21)+"\n");
                        buffer.append("MailingAddress:"+res.getString(20)+"\n\n");
                        buffer.append("SizeofCylinder:"+res.getString(2)+"\n");
                        buffer.append("AreaofCylinder:"+res.getString(3)+"\n");
                        buffer.append("TypeofPrinting:"+res.getString(4)+"\n");
                        buffer.append("MediaofPrinting:"+res.getString(5)+"\n");
                        buffer.append("WidthofCylinder:"+res.getString(6)+"\n");
                        buffer.append("Circumference:"+res.getString(7)+"\n");
                        buffer.append("BoreDiameter:"+res.getString(8)+"\n");
                        buffer.append("KeyWaySize:"+res.getString(9)+"\n");
                        buffer.append("FlangeSize:"+res.getString(10)+"\n");
                        buffer.append("CylinderColor:"+res.getString(11)+"\n");
                        buffer.append("Quantity:"+res.getString(12)+"\n");
                        buffer.append("Status of Order:"+res.getString(1)+"\n");
//                        buffer.append("<Button type=\"submit\">Transfer</Button>");
                        buffer.append("------------------------------------------\n");

//                        bundle.putString("ID",res.getString(0));
//                        bundle.putString("CustomerName",res.getString(14));
//                        bundle.putString("CompanyName",res.getString(15));
//                        bundle.putString("MobileNumber",res.getString(21));
//                        bundle.putString("MailingAddress",res.getString(20));
//                        bundle.putString("SizeofCylinder",res.getString(2));
//                        bundle.putString("AreaofCylinder",res.getString(3));
//                        bundle.putString("TypeofPrinting",res.getString(4));
//                        bundle.putString("MediaofPrinting",res.getString(5));
//                        bundle.putString("WidthofCylinder",res.getString(6));
//                        bundle.putString("Circumference",res.getString(7));
//                        bundle.putString("BoreDiameter",res.getString(8));
//                        bundle.putString("KeyWaySize",res.getString(9));
//                        bundle.putString("FlangeSize",res.getString(10));
//                        bundle.putString("CylinderColor",res.getString(11));
//                        bundle.putString("Quantity",res.getString(12));

                    }
                    showMessage("Data",buffer.toString());
                }
            }
        });
    }
    public void showMessage(String title,String msg)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginPage.this);
        builder.setCancelable(true);//can cancel it after use
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.show();
    }
}