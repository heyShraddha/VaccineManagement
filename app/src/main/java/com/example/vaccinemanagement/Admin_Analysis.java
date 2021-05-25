package com.example.vaccinemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Admin_Analysis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__analysis);

        getSupportActionBar().hide();

        TextView show_18_vaccine = (TextView)findViewById(R.id.show18Vaccine);
        TextView show_45_vaccine = (TextView)findViewById(R.id.show45Vaccine);
        TextView show_18_test = (TextView)findViewById(R.id.show18test);
        TextView show_45_test = (TextView)findViewById(R.id.show45test);
        show_18_vaccine.setText(String.valueOf(FirstActivity.count_of_total_18_vaccine));
        show_45_vaccine.setText(String.valueOf(FirstActivity.count_of_total_45_vaccine));
        show_18_test.setText(String.valueOf(FirstActivity.count_of_total_18_test));
        show_45_test.setText(String.valueOf(FirstActivity.count_of_total_45_test));
    }
}