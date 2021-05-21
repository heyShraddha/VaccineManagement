package com.example.vaccinemanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String USER_TABLE = "USER_TABLE";
    public static final String COLUMN_USERNAME = "USERNAME";
    public static final String COLUMN_PASSWORD = "PASSWORD";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "user.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + USER_TABLE + " (" + COLUMN_USERNAME + " TEXT PRIMARY KEY, " + COLUMN_PASSWORD + " TEXT)";
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addUser(UserModel userModel)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_USERNAME,userModel.getUsername());
        cv.put(COLUMN_PASSWORD,userModel.getPassword());

        long insert = db.insert(USER_TABLE, null, cv);

        if (insert == -1)
        {
            return false;
        }
        else{
            return true;
        }
    }

    public List<UserModel> getUsers()
    {
        List<UserModel> returnList = new ArrayList<>();
        String query = "SELECT * FROM "+USER_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do{
                String un = cursor.getString(0);
                String pw = cursor.getString(1);

                UserModel newUser = new UserModel(un,pw);
                returnList.add(newUser);
            }while(cursor.moveToNext());
        }
        else{
            //NO ITEMS IN TABLE
        }

        cursor.close();
        db.close();
        return returnList;
    }

}
