package com.example.medicalserviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText userName,userPassword;
    Button loginBtn;
    TextView signUpText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = findViewById(R.id.username);
        userPassword = findViewById(R.id.Password);
        loginBtn = findViewById(R.id.loginButton);
        signUpText = findViewById(R.id.signup_reg);


        //login function on the button
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = userName.getText().toString();
                String password = userPassword.getText().toString();
                Database dataBase = new Database(getApplicationContext(),"MobileHealthCare",null,1);

                if(username.length() == 0 || password.length() == 0){
                    Toast.makeText(MainActivity.this, "Fill all details", Toast.LENGTH_SHORT).show();

                } else {
                    if(dataBase.login(username,password) == 1){
                        Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username",username);
                        editor.apply();
                        startActivity(new Intent(MainActivity.this,HomeActivity.class));
                    }else {
                        Toast.makeText(MainActivity.this, "Invalid Login", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

     signUpText.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             startActivity(new Intent(MainActivity.this,RegistrationActivity.class));
         }
     });

    }
}