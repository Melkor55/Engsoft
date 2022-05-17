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

public class AddRecipe extends AppCompatActivity {

    EditText textInputEditTextName,  textInputEditTextDescription, textInputEditTextCookingTime;
    private Button AddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);

        textInputEditTextName = (EditText) findViewById(R.id.recipe_name_field);
        textInputEditTextDescription = (EditText) findViewById(R.id.recipe_description_field);
        textInputEditTextCookingTime = (EditText) findViewById(R.id.recipe_cookingTime_field);

        AddButton = (Button) findViewById(R.id.add_recipe);
        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String username,name,description,cooking_time;
                username = Login.getUsername();
                name = String.valueOf(textInputEditTextName.getText());
                description = String.valueOf(textInputEditTextDescription.getText());
                cooking_time = String.valueOf(textInputEditTextCookingTime.getText());

                if( !name.equals("") && !username.equals("") && !description.equals("") && !cooking_time.equals("") )
                {
                    Handler handler = new Handler(Looper.getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //Starting Write and Read data with URL
                            //Creating array for parameters
                            String[] field = new String[4];
                            field[0] = "username";
                            field[1] = "name";
                            field[2] = "description";
                            field[3] = "cooking_time";

                            //Creating array for data
                            String[] data = new String[4];

                            data[0] = username;
                            data[1] = name;
                            data[2] = description;
                            data[3] = cooking_time;

                            PutData putData = new PutData("http://192.168.1.102/LikedFoods/addRecipe.php", "POST", field, data);
                            if (putData.startPut()) {
                                if (putData.onComplete()) {
                                    String result = putData.getResult();
                                    System.out.println("--->" + result);
                                    //End ProgressBar (Set visibility to GONE)
                                    if (result.equals("Recipe Added Successfully")) {
                                        System.out.println("Good job!");
                                        //Intent intent = new Intent(getApplicationContext(),)

                                        Toast.makeText(getApplicationContext(),result,Toast.LENGTH_SHORT).show();

                                        Intent intent = new Intent(AddRecipe.this, LikedFoods.class);
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