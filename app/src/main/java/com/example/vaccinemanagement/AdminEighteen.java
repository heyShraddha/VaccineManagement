package com.example.vaccinemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class AdminEighteen extends AppCompatActivity {


    static int count_of_vaccine_18;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_eighteen);
        int value = FirstActivity.count_of_total_18_test;
        TextView showTest = (TextView)findViewById(R.id.showTest);
        String s = String.valueOf(value);
        showTest.setText(s);
        TextView showVaccine = (TextView)findViewById(R.id.showVaccine);
        showVaccine.setText(String.valueOf(FirstActivity.count_of_total_18_vaccine));
        Button b_back = (Button)findViewById(R.id.back);
        Button b_submit =(Button)findViewById(R.id.submit);
        EditText incBy = (EditText)findViewById(R.id.getIncBy);
        EditText decBy = (EditText)findViewById(R.id.getDecBy);
        int zeroValue = 0;
        incBy.setText(String.valueOf(zeroValue));
        decBy.setText(String.valueOf(zeroValue));
        b_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminEighteen.this,FirstActivity.class);
                startActivity(intent);
                finish();
            }
        });
        b_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(incBy.getText().toString().equalsIgnoreCase("") )&& decBy.getText().toString().equalsIgnoreCase("") )
                {
                    FirstActivity.count_of_total_18_vaccine = FirstActivity.count_of_total_18_vaccine + Integer.parseInt(incBy.getText().toString());
                }
                else if(!(decBy.getText().toString().equalsIgnoreCase("") )&& incBy.getText().toString().equalsIgnoreCase(""))
                {
                    FirstActivity.count_of_total_18_vaccine = FirstActivity.count_of_total_18_vaccine - Integer.parseInt(decBy.getText().toString());
                }
                else if (!(decBy.getText().toString().equalsIgnoreCase("") ) &&  !(incBy.getText().toString().equalsIgnoreCase("") ))
                {
                    Toast.makeText(AdminEighteen.this, "Enter something to process", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    FirstActivity.count_of_total_18_vaccine = FirstActivity.count_of_total_18_vaccine + Integer.parseInt(incBy.getText().toString());
                    FirstActivity.count_of_total_18_vaccine = FirstActivity.count_of_total_18_vaccine - Integer.parseInt(decBy.getText().toString());
                }

                showVaccine.setText(String.valueOf(FirstActivity.count_of_total_18_vaccine));
                incBy.setText(String.valueOf(zeroValue));
                decBy.setText(String.valueOf(zeroValue));
                incBy.setFocusable(true);

            }
        });
    }
}