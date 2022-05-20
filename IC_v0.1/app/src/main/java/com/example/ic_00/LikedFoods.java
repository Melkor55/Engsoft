package com.example.ic_00;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class LikedFoods extends AppCompatActivity
{

    private Button AddButton;
    private FloatingActionButton AddButton2;

    private Spinner spinner;
    private ArrayList<Aliment> students;
    private JSONArray result;
    private TextView textViewName;
    private TextView textViewCourse;
    private TextView textViewSession;

    RecyclerView recyclerView;

    RecyclerView.LayoutManager recyclerViewlayoutManager;

    RecyclerView.Adapter recyclerViewadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liked_foods);

        recyclerView = (RecyclerView) findViewById(R.id.liked_foods_list);
        recyclerViewlayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(recyclerViewlayoutManager);

        /*
        //Start ProgressBar first (Set visibility VISIBLE)
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                FetchData fetchData = new FetchData("http://192.168.1.102/LikedFoods/getFood.php");
                if (fetchData.startFetch()) {
                    if (fetchData.onComplete()) {
                        String result = fetchData.getResult();
                        //for(int i = 0 ; i < result.length() ; i ++)
                            System.out.println(result+"\n"+"gata");
                        //End ProgressBar (Set visibility to GONE)
                    }
                }
            }
        });
        */

        students = new ArrayList<>();
        /*spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        textViewName = (TextView) findViewById(R.id.textViewName);
        textViewCourse = (TextView) findViewById(R.id.textViewCourse);
        textViewSession = (TextView) findViewById(R.id.textViewSession);*/

        getData();



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
    private void getData(){
        StringRequest stringRequest = new StringRequest("http://192.168.1.102/LikedFoods/getFood.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject j = null;
                        try {
                            j = new JSONObject(response);
                            result = j.getJSONArray(Config.JSON_ARRAY);
                            getStudents(result);

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

    private void getStudents(JSONArray j){
        for(int i=0;i<j.length();i++){
            try {
                JSONObject json = j.getJSONObject(i);
                //students.add(json.getString(Config.TAG_ID));
                students.add(new Aliment(
                        json.getInt("id"),
                        json.getString("aliment")
                ));
                //System.out.println("no no no");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        students.toString();
        System.out.println(students);
        //spinner.setAdapter(new ArrayAdapter<String>(LikedFoods.this, android.R.layout.simple_spinner_dropdown_item, students));
        recyclerViewadapter = new AlimentAdapter(this, students);

        recyclerView.setAdapter(recyclerViewadapter);
    }




}


