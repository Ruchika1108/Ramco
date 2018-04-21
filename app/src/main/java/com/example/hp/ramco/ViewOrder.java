package com.example.hp.ramco;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewOrder extends AppCompatActivity {
    TextView tv2,tv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order);

        tv2=(TextView)findViewById(R.id.textView3);
        tv3=(TextView)findViewById(R.id.textView5);
        Bundle bundle=getIntent().getExtras();
        String ID=bundle.getString("ID");
        String cust=bundle.getString("CustomerName");
        String comp=bundle.getString("CompanyName");
        String mob=bundle.getString("MobileNumber");
        String mail=bundle.getString("MailingAddress");
        String size=bundle.getString("SizeofCylinder");
        String area=bundle.getString("AreaofCylinder");
        String type=bundle.getString("TypeofPrinting");
        String media=bundle.getString("MediaofPrinting");
        String width=bundle.getString("WidthofCylinder");
        String circum=bundle.getString("Circumference");
        String bore=bundle.getString("BoreDiameter");
        String key=bundle.getString("KeyWaySize");
        String flange=bundle.getString("FlangeSize");
        String col=bundle.getString("CylinderColor");
        String quan=bundle.getString("Quantity");


        tv2.setText(ID);
        tv3.setText(cust);
    }
}

