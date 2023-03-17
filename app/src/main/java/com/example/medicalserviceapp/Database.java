package com.example.medicalserviceapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.ContentView;
import androidx.annotation.Nullable;

import java.sql.SQLData;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String usersQuery = "create table users (username text,password text)";
        sqLiteDatabase.execSQL(usersQuery);

        String cartQuery = "create table cart (username text,product text,price float,orderType text)";
        sqLiteDatabase.execSQL(cartQuery);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void register(String username, String password){
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        SQLiteDatabase dataBase = getWritableDatabase();
        dataBase.insert("users",null,contentValues);
        dataBase.close();
    }

    public int login(String username, String password){
        int result = 0;
        String string[] = new String[2];
        string[0] = username;
        string[1] = password;
        SQLiteDatabase dataBase = getReadableDatabase();
        Cursor cursor = dataBase.rawQuery("Select * from users where username=? and password=?",string);
        if(cursor.moveToLast()){
            result = 1;
        }
        return result;
    }

    public void addToCart(String username,String product,float price,String orderType){
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("product",product);
        contentValues.put("price",price);
        contentValues.put("orderType",orderType);
        SQLiteDatabase database = getWritableDatabase();
        database.insert("addToCart",null,contentValues);
        database.close();

    }

    public int checkCart(String username,String product){
        int result = 0;
        String str[] = new String[2];
        str[0] = username;
        str[1] = product;
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery("select * from Cart where username=? and product=?", str);
        if(cursor.moveToFirst()){
            result = 1;
        }
        database.close();
        return result;

    }

    public void removeCart(String username,String orderType){
        String str[] = new String[2];
        str[0]= username;
        str[1]= orderType;
        SQLiteDatabase database = getWritableDatabase();
        database.delete("addToCart","username=? and orderType=?",str);
        database.close();
    }
}
