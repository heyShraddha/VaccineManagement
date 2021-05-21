package com.example.vaccinemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        EditText un = (EditText) findViewById(R.id.username);
        EditText ps = (EditText)findViewById(R.id.password);
        Button b = (Button)findViewById(R.id.login_b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int success = 0;
                if(un.getText().toString().equalsIgnoreCase("admin"))
                {

                    if(ps.getText().toString().equalsIgnoreCase("admin"))
                    {
                        success = 1;
                        Intent myIntent = new Intent(Admin.this, Home.class);
                        startActivity(myIntent);
                        finish();
                    }
                }
                if(success == 0)
                {
                    un.setText("");
                    ps.setText("");
                    un.requestFocus();
                    Toast.makeText(Admin.this, "Invalid credentials.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}