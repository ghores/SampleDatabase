package com.example.sampledatabase.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.sampledatabase.main.G;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "sample.sqlite";
    public static final int DB_VERSION = 1;

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, G.DB_DIR + "/" + DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
