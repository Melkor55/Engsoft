package com.example.ic_00;

import androidx.appcompat.app.AppCompatActivity;

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

import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Login extends AppCompatActivity {
    EditText textInputEditTextUsername, textInputEditTextPassword;
    Button loginButton;
    TextView textViewLogin;
    ProgressBar progressBar;
    public static String username;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textInputEditTextUsername = (EditText) findViewById(R.id.login_usernameField);
        textInputEditTextPassword = (EditText) findViewById(R.id.login_passwordField);
        loginButton = (Button) findViewById(R.id.login_button);
        //progressBar = findViewById(R.id.register_progressBar);
        //progressBar.setVisibility(View.INVISIBLE);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String password;
                username = String.valueOf(textInputEditTextUsername.getText());
                password = String.valueOf(textInputEditTextPassword.getText());


                if( !username.equals("") && !password.equals("") )
                {
                    //Start ProgressBar first (Set visibility VISIBLE)
                    for(int i = 0 ; i < 10000 ; i ++);
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[2];
                            field[0] = "username";
                            field[1] = "password";

                            //Creating array for data
                            String[] data = new String[2];
                            data[0] = username;
                            data[1] = password;
                        /*
                        data[0] = "ana";
                        data[1] = "anaa";
                        data[2] = "anaaaa";
                        data[3] = "1234";
                         */
/*
                            Runtime runtime = Runtime.getRuntime();
                            try {
                                Process p1 = runtime.exec("cmd /c start getIP.bat");
                                InputStream is = p1.getInputStream();
                                int i = 0;
                                while( (i = is.read() ) != -1) {
                                    System.out.print((char)i);
                                }
                            } catch(IOException ioException) {
                                System.out.println(ioException.getMessage() );
                            }

*/
                            /*
                            String header = "http://" ;
                            String ip = getIP.getIp();
                            String folder = "/LoginRegister" ;
                            String phpFile = "/login.php";
                            String URL = header + ip + folder + phpFile ;
                            */
                            //  url : http://current_ip_adress(ip_config)/the_folder_where_signup.php_is_stored/signup.php
                            System.out.println(new Database_URL("/LoginRegister","/login.php").getURL());
                            PutData putData = new PutData(new Database_URL("/LoginRegister","/login.php").getURL(), "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    System.out.println("--->" + result);
                                    //End ProgressBar (Set visibility to GONE)
                                    if (result.equals("Login Success")) {
                                        System.out.println("[31m Good job!");
                                        //Intent intent = new Intent(getApplicationContext(),)

                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();

                                        Intent intent = new Intent(Login.this, HomePage.class);
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

    public static String getUsername()
    {
        return username;
    }
}