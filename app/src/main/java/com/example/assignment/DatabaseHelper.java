package com.example.assignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {


    private static String DATABASE_NAME = "database";
    private static int version = 1;
    public static final String TABLE_NAME="users";
    public static final String COLUMN_ID="id";
    public static final String COLUMN_FULL_NAME="fullName";
    public static final String COLUMN_USER_NAME="userName";
    public static final String COLUMN_EMAIL="email";
    public static final String COLUMN_PASSWORD="password";
    public static final String COLUMN_PHONE="phone";
    public static final String COLUMN_GENDER="gender";


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, version);


    }

    public void insertUser(ContentValues contentValues){
        getWritableDatabase().insert(TABLE_NAME,"",contentValues);
    }

    public boolean isLoginValid(String email, String password){
        String sql = "select count(*) from users where email='" + email + "'and password='"+ password + "'";
        Cursor cursor=getReadableDatabase().rawQuery(sql, null);

        if(cursor.getCount()>0){
            return true;
        }else {
            return false;
        }

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTableUser = "CREATE TABLE "+TABLE_NAME+" ( " + COLUMN_ID+"	INTEGER PRIMARY KEY AUTOINCREMENT,"+
                COLUMN_FULL_NAME+"	TEXT, "+
                COLUMN_USER_NAME+"	TEXT," +
                COLUMN_EMAIL+"	TEXT, " +
                COLUMN_PASSWORD+"	TEXT, "+
                COLUMN_PHONE+"	INTEGER, "+
                COLUMN_GENDER+"	TEXT )" ;

        db.execSQL(createTableUser);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
