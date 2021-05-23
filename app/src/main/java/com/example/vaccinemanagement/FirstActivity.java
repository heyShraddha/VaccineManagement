package com.example.vaccinemanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FirstActivity extends AppCompatActivity {


    static int count_of_total_18_vaccine = 40;
    static int count_of_total_18_test = 70;
    static int count_of_total_45_vaccine = 60;
    static int count_of_total_45_test = 50;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        CardView card1 = (CardView)findViewById(R.id.card1);
        CardView card2 = (CardView)findViewById(R.id.card2);
        CardView card3 = (CardView)findViewById(R.id.card3);
        CardView card4 = (CardView)findViewById(R.id.card4);
        card1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(FirstActivity.this,AdminEighteen.class);
                startActivity(intent);
                finish();
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this,AdminFortyFive.class);
                startActivity(intent);
                finish();
            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

}