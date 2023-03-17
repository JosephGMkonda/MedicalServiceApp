package com.example.medicalserviceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    EditText edusername, edpassword,confirmPassword;
    Button registration_btn;
    TextView login_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        edusername = findViewById(R.id.username_reg);
        edpassword = findViewById(R.id.Password_reg);
        confirmPassword = findViewById(R.id.ConfirmPassword_reg);
        registration_btn = findViewById(R.id.signupButton);
        login_text = findViewById(R.id.sign_up);

        //Signup Function Button
        registration_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edusername.getText().toString();
                String password = edpassword.getText().toString();
                String confirm = confirmPassword.getText().toString();
                Database dataBase = new Database(getApplicationContext(),"MobileHealthCare",null,1);

                if (username.length() == 0 || password.length() == 0 || confirmPassword.length() == 0){

                    Toast.makeText(RegistrationActivity.this, "Fill details", Toast.LENGTH_SHORT).show();
                }else {
                    if(password.compareTo(confirm) == 0){

                            dataBase.register(username,password);
                            Toast.makeText(RegistrationActivity.this, "Registration successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegistrationActivity.this,MainActivity.class));


                    }else {
                        Toast.makeText(RegistrationActivity.this, "Password and " +
                                "Confirmed password didn't match", Toast.LENGTH_SHORT).show();

                    }
                }



            }
        });

        // Signin textview function
        login_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegistrationActivity.this,MainActivity.class));
            }
        });



    }

    public static boolean isValid(String passwordhere){
        int f1=0,f2=0,f3=0;
        if(passwordhere.length() < 8){
            return false;
        }else {
            for(int p = 0; p<passwordhere.length(); p++){
                if(Character.isLetter(passwordhere.charAt(p))) {
                    f1 = 1;
                }
            }
            for(int r = 0; r<passwordhere.length(); r++){
                if(Character.isDigit(passwordhere.charAt(r))){
                    f2=1;
                }
            }
            if(f1==1 && f2 == 2 && f3==3)
                return true;
            return false;
        }


        }



    }
