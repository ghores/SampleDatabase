package com.example.sampledatabase.main;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.example.sampledatabase.helper.MyDatabaseHelper;

import java.io.File;

public class G extends Application {

    public static G app;

    public static SQLiteDatabase database;
    public static boolean isDatabaseOpen;

    public static final String SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static final String BRAND_DIR = SDCARD + "/uncox-learn";
    public static final String APP_DIR = BRAND_DIR + "/sample_database";
    public static final String DB_DIR = APP_DIR + "/db";

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    public void createAppDirectories() {
        File dbDir = new File(DB_DIR);
        if (!dbDir.exists()) {
            dbDir.mkdirs();
        }
        createOrOpenDatabase();
    }

    public void createOrOpenDatabase() {
        if (database != null) {
            return;
        }
        MyDatabaseHelper databaseHelper = new MyDatabaseHelper(this);
        database = databaseHelper.getWritableDatabase();
        isDatabaseOpen = true;
    }
}
