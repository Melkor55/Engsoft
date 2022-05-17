package com.example.ic_00;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class LikedFoods extends AppCompatActivity
{

    private Button AddButton;
    private FloatingActionButton AddButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liked_foods);

    AddButton = (Button) findViewById(R.id.add_liked_foods);
    AddButton.setOnClickListener(new View.OnClickListener()
    {

        @Override
        public void onClick(View view)
        {


            Intent intent = new Intent(LikedFoods.this, AddLikedFoods.class);
            startActivity(intent);
        }
    });

    AddButton2 = findViewById(R.id.addRecipe);
    AddButton2.setOnClickListener(new View.OnClickListener()
    {

        @Override
        public void onClick(View view)
        {


            Intent intent = new Intent(LikedFoods.this, AddRecipe.class);
            startActivity(intent);
        }
    });
    }


}


