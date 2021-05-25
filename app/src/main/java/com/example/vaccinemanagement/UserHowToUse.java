package com.example.vaccinemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class UserHowToUse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_how_to_use);
        getSupportActionBar().hide();
    }
}