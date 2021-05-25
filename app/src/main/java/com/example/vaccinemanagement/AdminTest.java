package com.example.vaccinemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AdminTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_test);

        //show count in the bar
        int value = FirstActivity.count_of_total_18_test;
        TextView showTest = (TextView)findViewById(R.id.show18vaccine);
        String s = String.valueOf(value);
        showTest.setText(s);
        TextView showVaccine = (TextView)findViewById(R.id.show45vaccine);
        showVaccine.setText(String.valueOf(FirstActivity.count_of_total_45_test));


        Button b_back = (Button)findViewById(R.id.back);
        Button b_submit =(Button)findViewById(R.id.submit);


        EditText incBy = (EditText)findViewById(R.id.getIncBy);
        EditText decBy = (EditText)findViewById(R.id.getDecBy);

        int zeroValue = 0;
        incBy.setText(String.valueOf(zeroValue));
        decBy.setText(String.valueOf(zeroValue));


        TextView IncreaseByText = (TextView)findViewById(R.id.increaseBy);
        TextView DecreaseByText = (TextView)findViewById(R.id.decreaseBy);


        incBy.setEnabled(true);
        decBy.setEnabled(false);

        IncreaseByText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                incBy.setEnabled(true);
                decBy.setEnabled(false);
            }
        });

        DecreaseByText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                decBy.setEnabled(true);
                incBy.setEnabled(false);
            }
        });

//        //BACK button
        b_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminTest.this,FirstActivity.class);
                startActivity(intent);
                finish();
            }
        });

        b_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int flag = 0;
                if(incBy.isEnabled())
                {
                    flag =1;
                    int value = Integer.parseInt(incBy.getText().toString());
                    int value18 = (int) value / 3 ;
                    int value45 = value - value18;
                    FirstActivity.count_of_total_18_test = value18 + FirstActivity.count_of_total_18_test;
                    FirstActivity.count_of_total_45_test = value45 + FirstActivity.count_of_total_45_test;


                }
                if(decBy.isEnabled())
                {
                    flag=0;
                    int value = Integer.parseInt(decBy.getText().toString());
                    int value18 = value / 3 ;
                    int value45 = value - value18;
                    FirstActivity.count_of_total_18_test = FirstActivity.count_of_total_18_test - value18;
                    FirstActivity.count_of_total_45_test = FirstActivity.count_of_total_45_test - value45;

                }

                if(flag == 0)
                    Toast.makeText(AdminTest.this, "Vaccine Decreased By "+decBy.getText(), Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AdminTest.this, "Vaccine Increased By "+incBy.getText(), Toast.LENGTH_SHORT).show();


                String value1 = String.valueOf(FirstActivity.count_of_total_18_test);
                showTest.setText(value1);
                String value2 = String.valueOf(FirstActivity.count_of_total_45_test);
                showVaccine.setText(value2);

                incBy.setText(String.valueOf(zeroValue));
                decBy.setText(String.valueOf(zeroValue));
                incBy.setFocusable(true);

            }
        });
    }
}