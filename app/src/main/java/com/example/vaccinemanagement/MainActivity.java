package com.example.vaccinemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    int success;
    TextView signuphere;
    EditText username;
    TextInputEditText password;
    TextInputLayout usernamelo,passwordlo;
    public static String usernametxt,passwordtxt;
    Button login;
    Intent login_success,signup,admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Getting all users
        databaseHelper = new DatabaseHelper(MainActivity.this);
        List<UserModel> userList = databaseHelper.getUsers();

        username=(EditText)findViewById(R.id.username);
        usernamelo=(TextInputLayout)findViewById(R.id.username_lo);
        password=(TextInputEditText) findViewById(R.id.password);
        passwordlo=(TextInputLayout)findViewById(R.id.password_lo);
        login=(Button)findViewById(R.id.login_b);
        TextView admin_view = (TextView)findViewById(R.id.admin);
        admin_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, Admin.class);
                startActivity(myIntent);
                finish();
            }
        });
        signuphere=(TextView)findViewById(R.id.signuphere);
        signup = new Intent(this,SignUp.class);
        login_success = new Intent(MainActivity.this, Home.class);
        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart", true);
        if (firstStart) {
            loadData();
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                success=2;
                usernametxt=username.getText().toString();
                passwordtxt=password.getText().toString();
                if(usernametxt.isEmpty())
                {
                    usernamelo.setErrorEnabled(true);
                    usernamelo.setError("Please Enter Username");
                }
                else if(usernametxt.length()<5)
                {
                    usernamelo.setErrorEnabled(true);
                    usernamelo.setError("Username must be >4 characters");
                }
                else{
                    success-=1;
                }
                if(passwordtxt.isEmpty())
                {
                    passwordlo.setErrorEnabled(true);
                    passwordlo.setError("Please Enter Password");
                }
                else if(passwordtxt.length()<5)
                {
                    passwordlo.setErrorEnabled(true);
                    passwordlo.setError("Password must be >4 characters");
                }
                else{
                    success-=1;
                }
                if(success==0)
                {
                    int x=userList.size();
                    int i=0;
                    int flag=0;
                    while(x>0)
                    {
                        if(userList.get(i).toString().equals("UserModel{Username='"+usernametxt+"', Password='"+passwordtxt+"'}"))
                        {
                            flag=1;
                            Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                            break;
                        }
                        i++;
                        x--;
                    }
                    if(flag==0)
                    {
                        Toast.makeText(MainActivity.this, "User doesn't exist/Password Incorrect", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        password.setText("");
                        startActivity(login_success);
                        finish();
                    }
                }
            }

        });

        signuphere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(signup);
                finish();
            }
        });

        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(usernamelo.isErrorEnabled()==true)
                {
                    usernamelo.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(passwordlo.isErrorEnabled()==true)
                {
                    passwordlo.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void loadData() {
        //Hard-coding "admin" user
        UserModel userModel = new UserModel("admin","admin");
        databaseHelper = new DatabaseHelper(MainActivity.this);
        boolean userCreated = databaseHelper.addUser(userModel);

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("firstStart", false);
        editor.apply();
    }
}