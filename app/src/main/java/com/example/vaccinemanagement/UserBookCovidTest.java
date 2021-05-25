package com.example.vaccinemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserBookCovidTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_book_covid_test);
        getSupportActionBar().hide();
        Button submit_b = (Button)findViewById(R.id.submit_b);
        submit_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EditText ed_name = (EditText) findViewById(R.id.name_do);
                EditText ed_age = (EditText) findViewById(R.id.age_do);
                EditText ed_gender = (EditText) findViewById(R.id.gender_do);
                EditText ed_addhar = (EditText) findViewById(R.id.addhar_do);

                String s1 = ed_name.getText().toString();
                String s2 = ed_addhar.getText().toString();
                String s3 = ed_age.getText().toString();
                String s4 = ed_gender.getText().toString();

                if ((s1.equalsIgnoreCase("")) || (s2.equalsIgnoreCase("")) || (s3.equalsIgnoreCase("")) || (s4.equalsIgnoreCase(""))) {
                    Toast.makeText(UserBookCovidTest.this, "Please enter the field which is empty! ", Toast.LENGTH_SHORT).show();
                } else {
                    if ((Integer.parseInt(ed_age.getText().toString()) > 44)) {
                        FirstActivity.count_of_total_45_vaccine = FirstActivity.count_of_total_45_vaccine - 1;
                    } else {
                        FirstActivity.count_of_total_18_vaccine = FirstActivity.count_of_total_18_vaccine - 1;
                    }
                    Toast.makeText(UserBookCovidTest.this, " " + ed_name.getText().toString() + "  got registered", Toast.LENGTH_SHORT).show();
                    Intent myIntent = new Intent(UserBookCovidTest.this, Home.class);
                    startActivity(myIntent);
                    finish();

                }
            }
                    });
        Button back_b = (Button)findViewById(R.id.back_b);
        back_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(UserBookCovidTest.this,Home.class);
                startActivity(myIntent);
                finish();

            }
        });


    }

}