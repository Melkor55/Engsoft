package com.example.ic_00;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DislikedFoods extends AppCompatActivity {

    private Button AddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disliked_foods);

        AddButton = (Button) findViewById(R.id.add_disliked_foods);
        AddButton.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {


                Intent intent = new Intent(DislikedFoods.this, AddDislikedFoods.class);
                startActivity(intent);
            }
        });
    }

}