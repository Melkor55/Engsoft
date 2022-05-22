package com.example.ic_00;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.net.UnknownHostException;

public class AddLikedFoods extends AppCompatActivity {

    EditText textInputEditTextLikedFood;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_liked_foods);


    textInputEditTextLikedFood = (EditText) findViewById(R.id.liked_foods_field);
    addButton = (Button) findViewById(R.id.add_liked_foods_stage2);

        addButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view)
        {
            String  username, aliment;
            username = Login.getUsername();
            aliment = String.valueOf(textInputEditTextLikedFood.getText());


            if( !aliment.equals("") )
            {
                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //Starting Write and Read data with URL
                        //Creating array for parameters
                        String[] field = new String[2];
                        field[0] = "username";
                        field[1] = "aliment";

                        //Creating array for data
                        String[] data = new String[2];

                        data[0] = username;
                        data[1] = aliment;

                        //  url : http://current_ip_adress(ip_config)/the_folder_where_signup.php_is_stored/signup.php
                        String URL = "http://" +IPAdress.getMyIP()+ "/LoginRegister/signup.php";
                        System.out.println(">>>"+URL);
                        //PutData putData = new PutData("http://192.168.1.102/LikedFoods/addFood.php", "POST", field, data);
                        PutData putData = new PutData(new Database_URL("/LikedFoods", "/addFood.php").getURL(), "POST", field, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                String result = putData.getResult();
                                System.out.println("--->" + result);
                                //End ProgressBar (Set visibility to GONE)
                                if (result.equals("Food Added Succefully")) {
                                    System.out.println("Good job!");
                                    //Intent intent = new Intent(getApplicationContext(),)

                                    Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(AddLikedFoods.this, LikedFoods.class);
                                    startActivity(intent);
                                    finish();
                                }
                                else {
                                    System.out.println("Bad job!");
                                    Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                }
                            } else
                                System.out.println("Incomplete!");
                        } else
                            System.out.println("Data is not put!");
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