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
        createPersonTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion == 1 && newVersion == 2) {
            createPersonTable(db);
        }
    }

    private void createPersonTable(SQLiteDatabase db) {
        String query = "CREATE TABLE 'person' (" +
                "'personId' INTEGER PRIMARY KEY AUTOINCREMENT  NOT NULL , " +
                "'firstname' TEXT, " +
                "'lastname' TEXT, " +
                "'gender' INTEGER, " +
                "'email' TEXT UNIQUE, " +
                "'imageUrl' TEXT, " +
                "'creationTime' INTEGER" +
                ")";
        db.execSQL(query);
    }
}
