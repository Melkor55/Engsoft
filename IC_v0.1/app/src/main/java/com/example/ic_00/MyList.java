package com.example.ic_00;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MyList extends AppCompatActivity {

    private Button AddButton;

    private ArrayList<Aliment> aliments;
    private JSONArray result;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    RecyclerView.Adapter recyclerViewadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);

        recyclerView = (RecyclerView) findViewById(R.id.shoping_list);
        recyclerViewlayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewlayoutManager);


        aliments = new ArrayList<>();

        getData();

        AddButton = (Button) findViewById(R.id.add_list_foods);
        AddButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                Intent intent = new Intent(MyList.this, AddFoodInMyList.class);
                startActivity(intent);
            }
        });
    }

    private void getData()
    {
        //StringRequest stringRequest = new StringRequest("http://192.168.1.102/LikedFoods/getFood.php",
        StringRequest stringRequest =  new StringRequest(new Database_URL("/LikedFoods","/getShopingList.php").getURL(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject j = null;
                        try {
                            j = new JSONObject(response);
                            result = j.getJSONArray(Config.JSON_ARRAY);
                            getAliments(result);

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

    private void getAliments(JSONArray j){
        for(int i=0;i<j.length();i++){
            try {
                JSONObject json = j.getJSONObject(i);
                //students.add(json.getString(Config.TAG_ID));
                if (json.getString("username").equals(Login.getUsername()))
                    aliments.add(new Aliment(
                            json.getInt("id"),
                            json.getString("username"),
                            json.getString("aliment")
                    ));
                //System.out.println("no no no");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        aliments.toString();
        System.out.println(aliments);
        //spinner.setAdapter(new ArrayAdapter<String>(LikedFoods.this, android.R.layout.simple_spinner_dropdown_item, students));
        recyclerViewadapter = new AlimentAdapter(this, aliments, "shoping_list");

        recyclerView.setAdapter(recyclerViewadapter);

    }
}