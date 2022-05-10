package com.example.ic_00;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Register extends AppCompatActivity {

    private Button LoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        LoginButton = (Button) findViewById(R.id.likedFoods_button);
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Register.this, LikedFoods.class);
                startActivity(intent);
            }
        });

    }
}