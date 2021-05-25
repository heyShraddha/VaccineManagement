package com.example.vaccinemanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {


    static int count_of_total_18_vaccine = 40;
    static int count_of_total_18_test = 70;
    static int count_of_total_45_vaccine = 60;
    static int count_of_total_45_test = 50;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        getSupportActionBar().hide();
        CardView card1 = (CardView)findViewById(R.id.card1);
        CardView card2 = (CardView)findViewById(R.id.card2);
        CardView card3 = (CardView)findViewById(R.id.card3);
        CardView card4 = (CardView)findViewById(R.id.card4);
        Button logout = (Button)findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this,MainActivity.class);
                startActivity(intent);
                Toast.makeText(FirstActivity.this, "Logged Out Successfully", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        card1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(FirstActivity.this,AdminEighteen.class);
                startActivity(intent);

            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this,AdminFortyFive.class);
                startActivity(intent);

            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this,AdminTest.class);
                startActivity(intent);

            }
        });
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this,Admin_Analysis.class);
                startActivity(intent);
            }
        });

    }

}