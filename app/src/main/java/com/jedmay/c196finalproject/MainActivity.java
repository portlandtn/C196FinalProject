package com.jedmay.c196finalproject;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

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
    }

    public void showTermsActivity(View view) {

    }

    public void createSampleData(View view) {
    }

    public void clearDataBase(View view) {
    }
}
