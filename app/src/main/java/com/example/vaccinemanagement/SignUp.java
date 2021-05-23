package com.example.vaccinemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignUp extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    int success;
    Button signup_b;
    EditText username;
    TextInputEditText password;
    TextInputLayout usernamelo,passwordlo;
    String usernametxt,passwordtxt;
    TextView loginhere;
    Intent login,signup_success;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        username=(EditText)findViewById(R.id.username);
        usernamelo=(TextInputLayout)findViewById(R.id.username_lo);
        password=(TextInputEditText) findViewById(R.id.password);
        passwordlo=(TextInputLayout)findViewById(R.id.password_lo);
        signup_b = (Button)findViewById(R.id.signup_b);
        loginhere=(TextView)findViewById(R.id.loginhere);
        login = new Intent(this,MainActivity.class);
        signup_success = new Intent(this,Home.class);
        ImageView Image = (ImageView)findViewById(R.id.title);
        Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this,FirstActivity.class);
                startActivity(intent);
                finish();
            }
        });

        signup_b.setOnClickListener(new View.OnClickListener() {
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
                    databaseHelper = new DatabaseHelper(SignUp.this);
                    UserModel userModel = new UserModel(usernametxt,passwordtxt);
                    boolean userCreated = databaseHelper.addUser(userModel);
                    if(userCreated==true)
                    {
                        MainActivity.usernametxt=usernametxt;
                        Toast.makeText(SignUp.this, "User Successfully Created", Toast.LENGTH_SHORT).show();
                        startActivity(signup_success);
                        finish();
                    }
                    else{
                        usernamelo.setErrorEnabled(true);
                        usernamelo.setError("Username already taken");
                    }

                }
            }
        });

        loginhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(login);
                finish();
            }
        });

        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(usernamelo.isErrorEnabled())
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
}