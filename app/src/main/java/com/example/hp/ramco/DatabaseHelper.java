package com.example.hp.ramco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hp on 14/04/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
    private static final String Database_name="info2.db";
    private static final String Table_name="customerDetail";
    private static final String Table_name1="productDetail";
    private static final String status1="Pending";
    public static final String COL_1="ID";
    private static final String COL_2="CUSTOMER_NAME";
    private static final String COL_3="COMPANY_NAME";
    private static final String COL_4="COMPANY_ADDRESS";
    private static final String COL_5="CITY";
    private static final String COL_6="PINCODE";
    private static final String COL_7="EMAIL_ADDRESS";
    private static final String COL_8="MAILING_ADDRESS";
    private static final String COL_9="MOBILE_NUMBER";
    private static final String COL_10="WORK_PHONE_NUMBER";
    public static final String COL_11="ID1";
    public static final String COL_12="STATUS";
    private static final String COL_13="SIZE";
    private static final String COL_14="AREA";
    private static final String COL_15="TYPE";
    private static final String COL_16="MEDIA";
    private static final String COL_17="WIDTH";
    private static final String COL_18="CIRCUMFERENCE";
    private static final String COL_19="DIAMETER";
    private static final String COL_20="KEYWAYSIZE";
    private static final String COL_21="FLANGESIZE";
    private static final String COL_22="COLOR";
    private static final String COL_23="NOOFCOLOR";



    public DatabaseHelper(Context context) {
        super(context, Database_name, null,2);
        SQLiteDatabase dp=this.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL("create table " + Table_name + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,CUSTOMER_NAME TEXT,COMPANY_NAME TEXT,COMPANY_ADDRESS TEXT,CITY TEXT,PINCODE INTEGER,EMAIL_ADDRESS TEXT,MAILING_ADDRESS TEXT,MOBILE_NUMBER INTEGER,WORK_PHONE_NUMBER INTEGER)");
       db.execSQL("create table " + Table_name1 + " (ID1 INTEGER PRIMARY KEY AUTOINCREMENT,STATUS TEXT,SIZE INTEGER,AREA INTEGER,TYPE TEXT, MEDIA TEXT,WIDTH INTEGER,CIRCUMFERENCE INTEGER,DIAMETER INTEGER,KEYWAYSIZE INTEGER,FLANGESIZE INTEGER,COLOR TEXT,NOOFCOLOR INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ Table_name);
        db.execSQL("DROP TABLE IF EXISTS "+ Table_name1);
        onCreate(db);
    }



    public boolean insertData(String customerName,String companyName,String companyAddress,String city,String pincode,String emailAddress,String mailingAddress, String mobileNumber, String phoneNumber){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(COL_2,customerName);
        values.put(COL_3,companyName);
        values.put(COL_4,companyAddress);
        values.put(COL_5,city);
        values.put(COL_6,pincode);
        values.put(COL_7,emailAddress);
        values.put(COL_8,mailingAddress);
        values.put(COL_9,mobileNumber);
        values.put(COL_10,phoneNumber);

        long result=db.insert(Table_name,null,values);
        if(result==-1) {
            return false;
        }
        else {
            return true;
        }
    }

//    public boolean insertData1(String size,String area,String type,String media,String width,String circumference,String diameter, String keywaysize, String flangesize,String color,String noofcolor){
//        SQLiteDatabase db=this.getWritableDatabase();
//
//        ContentValues values=new ContentValues();
//        values.put(COL_12,size);
//        values.put(COL_13,area);
//        values.put(COL_14,type);
//        values.put(COL_15,media);
//        values.put(COL_16,width);
//        values.put(COL_17,circumference);
//        values.put(COL_18,diameter);
//        values.put(COL_19,keywaysize);
//        values.put(COL_20,flangesize);
//        values.put(COL_21,color);
//        values.put(COL_22,noofcolor);
//
//        long result=db.insert(Table_name1,null,values);
//        if(result==-1) {
//            return false;
//        }
//        else {
//            return true;
//        }
//    }
    public boolean insertData2(String status,String si,String ar,String type, String media,String wi,String circum,String diameter, String keysize,String flange,String co,String number){
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues values1=new ContentValues();
        values1.put(COL_12,status);
        values1.put(COL_13,si);
        values1.put(COL_14,ar);
        values1.put(COL_15,type);
        values1.put(COL_16,media);
        values1.put(COL_17,wi);
        values1.put(COL_18,circum);
        values1.put(COL_19,diameter);
        values1.put(COL_20,keysize);
        values1.put(COL_21,flange);
        values1.put(COL_22,co);
        values1.put(COL_23,number);

        long result1=db.insert(Table_name1,null,values1);
        if(result1==-1){
            return false;
        }
        else {
            return true;
        }
    }

    public Cursor getAllData()//cursor class provied random read write
    {
        SQLiteDatabase db=this.getWritableDatabase();                                                                                       //"SELECT * FROM tbl1 WHERE TRIM(name) = '"+name.trim()+"'"
        Cursor res=db.rawQuery("SELECT * FROM " + Table_name1 + " INNER JOIN " + Table_name + " WHERE " + COL_1 + " = " + COL_11 + " AND " + COL_12 + " == " + "'Pending'" + " OR " + COL_12 + " == " + "'Partly Completed'" ,null);
        return res;
    }

    public Cursor getOrderId(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("SELECT " + COL_11 + " FROM " + Table_name1,null);
        return res;
    }

    public Cursor getAllData1(String id){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();

        Cursor res=sqLiteDatabase.rawQuery("SELECT * FROM productDetail inner join customerDetail WHERE ID1='"+id+"'",null);

        return res;

    }


    public void updateData(String id, String status){

        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(COL_11,id);
        values.put(COL_12,status);
        sqLiteDatabase.update(Table_name1,values,COL_11+" = "+ "'id'",null);
        sqLiteDatabase.close();
    }
}

