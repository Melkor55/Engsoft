package com.example.ic_00;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class WhatToEat extends AppCompatActivity {

    private ArrayList<Recipe> recipes;
    private JSONArray result;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    RecyclerView.Adapter recyclerViewadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_to_eat);

        recyclerView = (RecyclerView) findViewById(R.id.recipes_list);
        recyclerViewlayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewlayoutManager);

        recipes = new ArrayList<>();

        getData();
    }

    private void getData(){
        //StringRequest stringRequest = new StringRequest("http://192.168.1.102/LikedFoods/getFood.php",
        StringRequest stringRequest =  new StringRequest(new Database_URL("/LikedFoods","/getRecipes.php").getURL(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject j = null;
                        try {
                            j = new JSONObject(response);
                            result = j.getJSONArray(Config.JSON_ARRAY);
                            getRecipes(result);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("no no no");
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void getRecipes(JSONArray j){
        for(int i=0;i<j.length();i++){
            try {
                JSONObject json = j.getJSONObject(i);
                //students.add(json.getString(Config.TAG_ID));
                    recipes.add(new Recipe(
                            json.getInt("id"),
                            json.getString("username"),
                            json.getString("name"),
                            json.getString("description"),
                            json.getInt("cooking_time")
                    ));
                //System.out.println("no no no");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        recipes.toString();
        System.out.println(recipes);
        //spinner.setAdapter(new ArrayAdapter<String>(LikedFoods.this, android.R.layout.simple_spinner_dropdown_item, students));
        recyclerViewadapter = new RecipeAdapter(this, recipes, "recipes");

        recyclerView.setAdapter(recyclerViewadapter);
    }
}