package com.example.sampledatabase.activity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sampledatabase.R;
import com.example.sampledatabase.main.G;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readData();
    }

    @SuppressLint("Range")
    private void readData() {
        Cursor cursor = G.database.rawQuery("SELECT * FROM person", null);
        while (cursor.moveToNext()) {
            int personId = cursor.getInt(cursor.getColumnIndex("personId"));
            String firstname = cursor.getString(cursor.getColumnIndex("firstname"));
            String lastname = cursor.getString(cursor.getColumnIndex("lastname"));
            int gender = cursor.getInt(cursor.getColumnIndex("gender"));
            String email = cursor.getString(cursor.getColumnIndex("email"));
            Log.i("LOG", "personId: " + personId + ", firstname: " + firstname + ", lastname: " + lastname + ", gender: " + gender + ", email: " + email);
        }
        cursor.close();
    }

    private void modifyData() {
        try {
            for (int i = 0; i < 10; i++) {
                String firstname = "FirstName" + i;
                String lastname = "LastName" + i;
                int gender = 0;
                String email = "email" + i + "@c.com";
                String query = "INSERT INTO 'person' ('firstname','lastname','gender','email') VALUES ('" + firstname + "', '" + lastname + "', " + gender + " , '" + email + "')";
                G.database.execSQL(query);
            }
        } catch (SQLiteConstraintException e) {
            Log.e("LOG", e.getMessage());
        }

        G.database.execSQL("DELETE FROM person WHERE personId=5");
        G.database.execSQL("UPDATE person SET firstname='behnam', lastname='aghajani', email='uncocoder@gmail.com' WHERE personId=17");
    }
}