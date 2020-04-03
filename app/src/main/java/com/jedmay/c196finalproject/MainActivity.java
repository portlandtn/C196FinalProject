package com.jedmay.c196finalproject;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import DataProvider.SampleData;

public class MainActivity extends AppCompatActivity {

    SampleData data;

    @Override
    protected void onResume() {
        super.onResume();
        updateList();
    }

    private void updateList() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = new SampleData();
    }

    public void showTermsActivity(View view) {

    }

    public void createSampleData(View view) {
        data.populateDatabaseWithSampleData(getApplicationContext());
    }

    public void clearDataBase(View view) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("This will clear out the database. Are you sure you want to proceed?");
                    alertDialogBuilder.setPositiveButton("ERASE",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface arg0, int arg1) {
                                    data.deleteAllDataFromDatabase(getApplicationContext());
                                    Toast.makeText(MainActivity.this,"Database has been erased.",Toast.LENGTH_LONG).show();
                                }
                            });
            alertDialogBuilder.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }

