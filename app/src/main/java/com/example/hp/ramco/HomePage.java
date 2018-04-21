package com.example.hp.ramco;

import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class HomePage extends AppCompatActivity {
        Button ourService;
        Button placeAnOrder, aboutus,viewOrder;

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static final Integer[] XMEN= {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e};
    private ArrayList<Integer> XMENArray = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        ourService = (Button) findViewById(R.id.button2);
        placeAnOrder = (Button) findViewById(R.id.button3);
        aboutus=(Button)findViewById(R.id.button5);
        viewOrder=(Button)findViewById(R.id.button6);
        init();
    }

    private void init() {
        for(int i=0;i<XMEN.length;i++)
            XMENArray.add(XMEN[i]);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new SlidingImage_Adapter(HomePage.this,XMENArray));
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == XMEN.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);
    }


    public void OurService(View view){
        Intent i1=new Intent(this,ServicesPage.class);
        startActivity(i1);
    }

    public void PlaceAnOrder(View view){
        Intent i2=new Intent(this,CustomerDetailsPage.class);
        startActivity(i2);
    }

    public void aboutus(View view){
        Intent i3=new Intent(this,AboutUsPage.class);
        startActivity(i3);
    }


    public void viewOrder(View view){
        Intent intent=new Intent(this,LoginPage.class);
        startActivity(intent);
    }

}
