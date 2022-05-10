package com.example.ic_00;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {

    private Button LikedFoodsButton;
    private Button DislikedFoodsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

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
    }
}