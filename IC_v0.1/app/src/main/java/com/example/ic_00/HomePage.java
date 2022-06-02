package com.example.ic_00;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.jar.Attributes;

public class HomePage extends AppCompatActivity {

    private Button LikedFoodsButton;
    private Button DislikedFoodsButton;
    private Button InMyFridgeButton;
    private Button WhatToEatButton;
    private Button MyListButton;
    private Button AddRecipeButton;
    private Button LogoutButton;
    private ImageButton DarkMode;
    private TextView NameLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        NameLabel = (TextView) findViewById(R.id.textViewName);
        NameLabel.setText("Hello,\n " + Login.getUsername() + " ! ");

        LikedFoodsButton = (Button) findViewById(R.id.likedFoods_button);
        LikedFoodsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(HomePage.this, LikedFoods.class);
                startActivity(intent);
            }
        });

        DislikedFoodsButton = (Button) findViewById(R.id.dislikedFoods_button);
        DislikedFoodsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(HomePage.this, DislikedFoods.class);
                startActivity(intent);
            }
        });

        InMyFridgeButton = (Button) findViewById(R.id.inMyFridge_button);
        InMyFridgeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(HomePage.this, InMyFridge.class);
                startActivity(intent);
            }
        });

        WhatToEatButton = (Button) findViewById(R.id.whatToEat_button);
        WhatToEatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(HomePage.this, WhatToEat.class);
                startActivity(intent);
            }
        });

        MyListButton = (Button) findViewById(R.id.myList_button);
        MyListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(HomePage.this, MyList.class);
                startActivity(intent);
            }
        });

        AddRecipeButton = (Button) findViewById(R.id.addRecipe_button)  ;
        AddRecipeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(HomePage.this, AddRecipe.class);
                startActivity(intent);
            }
        });

        LogoutButton = (Button) findViewById(R.id.logout_button)  ;
        LogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(HomePage.this, MainActivity.class);
                startActivity(intent);
            }
        });

        DarkMode = (ImageButton) findViewById(R.id.dark_light);
        DarkMode.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //if(isNightModeOn())
                if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES)
                {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    //DarkMode.text = "Enable Dark Mode";
                } else
                {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    //DarkMode.text = "Disable Dark Mode";
                }
            }
        });
    }
}