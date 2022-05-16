package com.example.ic_00;
import java.io.*;
import java.net.UnknownHostException;

import androidx.appcompat.app.AppCompatActivity;

//import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

public class Register extends AppCompatActivity {

    EditText textInputEditTextName, textInputEditTextUsername, textInputEditTextEmail, textInputEditTextPassword;
    Button registerButton;
    TextView textViewLogin;
    ProgressBar progressBar;
    private Button loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        textInputEditTextName = (EditText) findViewById(R.id.register_nameField);
        textInputEditTextUsername = (EditText) findViewById(R.id.register_usernameField);
        textInputEditTextEmail = (EditText) findViewById(R.id.register_emailField);
        textInputEditTextPassword = (EditText) findViewById(R.id.register_passwordField);
        loginButton = (Button) findViewById(R.id.login_button);
        registerButton  = findViewById(R.id.register_button_stage2);
        progressBar = findViewById(R.id.register_progressBar);
        progressBar.setVisibility(View.INVISIBLE);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String name,username,email,password;
                name = String.valueOf(textInputEditTextName.getText());
                username = String.valueOf(textInputEditTextUsername.getText());
                email = String.valueOf(textInputEditTextEmail.getText());
                password = String.valueOf(textInputEditTextPassword.getText());


                if( !name.equals("") && !username.equals("") && !email.equals("") && !password.equals("") )
                {
                    //Start ProgressBar first (Set visibility VISIBLE)
                    progressBar.setVisibility(View.VISIBLE);
                    for(int i = 0 ; i < 10000 ; i ++);
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println(name);
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[4];
                            field[0] = "name";
                            field[1] = "username";
                            field[2] = "email";
                            field[3] = "password";

                            //Creating array for data
                            String[] data = new String[4];

                            data[0] = name;
                            data[1] = username;
                            data[2] = email;
                            data[3] = password;
                        /*
                        data[0] = "ana";
                        data[1] = "anaa";
                        data[2] = "anaaaa";
                        data[3] = "1234";
                         */
                            //  url : http://current_ip_adress(ip_config)/the_folder_where_signup.php_is_stored/signup.php
                            try {
                                IPAdress.setMyIP();
                            } catch (UnknownHostException e) {
                                e.printStackTrace();
                            }

                            String URL = "http://" +IPAdress.getMyIP()+ "/LoginRegister/signup.php";
                            System.out.println(">>>"+URL);
                            PutData putData = new PutData("http://192.168.1.113/LoginRegister/signup.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    progressBar.setVisibility(View.GONE);
                                    String result = putData.getResult();
                                    System.out.println("--->" + result);
                                    //End ProgressBar (Set visibility to GONE)
                                    if (result.equals("Sign Up Success")) {
                                        System.out.println("[31m Good job!");
                                        //Intent intent = new Intent(getApplicationContext(),)

                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();

                                        Intent intent = new Intent(Register.this, MainActivity.class);
                                        startActivity(intent);
                                    }
                                    else {
                                        System.out.println("[31m Bad job!");
                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                    }
                                } else
                                    System.out.println("\u001B[31m Incomplete!\u001B[0m");
                            } else
                                System.out.println("\u001B[31m Data is not put!\u001B[0m");
                            //End Write and Read data with URL
                        }
                    });
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"All fields required",Toast.LENGTH_SHORT).show();
                }

                /*
                Intent intent = new Intent(Register.this, HomePage.class);
                startActivity(intent);
                 */
            }
        });




    }
}