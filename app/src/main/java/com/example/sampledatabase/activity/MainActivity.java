package com.example.sampledatabase.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sampledatabase.R;
import com.example.sampledatabase.helper.RequestHelper;
import com.example.sampledatabase.main.G;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestForWriteSDCardPermission();
    }

    private void requestForWriteSDCardPermission() {
        RequestHelper requestHelper = new RequestHelper(this);
        requestHelper.request(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                () -> G.app.createAppDirectories(),
                () -> new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Permission Required")
                        .setMessage("Writing to SDCARD required for this app.")
                        .setPositiveButton("Ask me again", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                requestForWriteSDCardPermission();
                            }
                        })
                        .create()
                        .show(),
                () -> G.app.createOrOpenDatabase());
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        RequestHelper.onRequestPermissionsResult(requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}