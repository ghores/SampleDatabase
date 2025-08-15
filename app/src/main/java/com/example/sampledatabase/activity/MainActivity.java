package com.example.sampledatabase.activity;

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