package com.example.ic_00;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.util.ArrayList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewProcessHolder>
{
    Context context;
    private ArrayList<Recipe> recipes;
    private String table;

    public RecipeAdapter(Context context, ArrayList<Recipe> recipes, String table) {
        this.context = context;
        this.table = table;
        this.recipes = recipes;
    }

    @NonNull
    @Override
    public RecipeAdapter.ViewProcessHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_list, parent, false); //memanggil layout list recyclerview
        RecipeAdapter.ViewProcessHolder processHolder = new RecipeAdapter.ViewProcessHolder(view);
        return processHolder;
    }

    /*
    @NonNull
    @Override
    public ViewProcessHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }
*/

    @Override
    public void onBindViewHolder(@NonNull RecipeAdapter.ViewProcessHolder holder, int position) {

        final Recipe data = recipes.get(position);
        //holder.id.setText(""+data.getId());//menampilkan data
        holder.id.setText(null);//
        holder.name.setText(data.getName());
        holder.username.setText(data.getUsername());
        holder.cooking_time.setText(""+data.getCooking_time());
        holder.description.setText(data.getDescription());
        //int position = holder.getAdapterPosition();
        /*
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Aliment theRemovedItem = aliments.get(holder.getAdapterPosition());

                // remove your item from data base

                String  username, aliment;
                username = Login.getUsername();
                aliment = theRemovedItem.getAliment();

                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        //Starting Write and Read data with URL
                        //Creating array for parameters
                        String[] field = new String[3];
                        field[0] = "table";
                        field[1] = "username";
                        field[2] = "aliment";

                        //Creating array for data
                        String[] data = new String[3];
                        data[0] = table;
                        data[1] = username;
                        data[2] = aliment;

                        //PutData putData = new PutData("http://192.168.1.102/LikedFoods/addFood.php", "POST", field, data);
                        PutData putData = new PutData(new Database_URL("/LikedFoods", "/deleteFood.php").getURL(), "POST", field, data);
                        if (putData.startPut()) {
                            if (putData.onComplete()) {
                                String result = putData.getResult();
                                System.out.println("--->" + result);
                                //End ProgressBar (Set visibility to GONE)
                                if (result.equals("Food Deleted Succefully")) {
                                    System.out.println("Good job!");
                                    Toast.makeText(context.getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    System.out.println("Bad job!");
                                    Toast.makeText(context.getApplicationContext(),result,Toast.LENGTH_SHORT).show();
                                }
                            } else
                                System.out.println("Incomplete!");
                        } else
                            System.out.println("Data is not put!");
                        //End Write and Read data with URL
                    }
                });


                System.out.println("<< " + theRemovedItem + " >>" + "--> Position :" + holder.getAdapterPosition());
                recipes.remove(theRemovedItem);  // remove the item from list
                notifyItemRemoved(holder.getAdapterPosition()); // notify the adapter about the removed item
            }
        });
        */
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public class ViewProcessHolder extends RecyclerView.ViewHolder {

        TextView id,name, username,cooking_time, description;
        FloatingActionButton delete;

        public ViewProcessHolder(@NonNull View itemView) {
            super(itemView);

            id = (TextView) itemView.findViewById(R.id.recipe_list_id);
            name = (TextView) itemView.findViewById(R.id.recipe_list_name);
            username = (TextView) itemView.findViewById(R.id.recipe_list_username);
            cooking_time = (TextView) itemView.findViewById(R.id.recipe_list_cooking_time);
            description = (TextView) itemView.findViewById(R.id.recipe_list_description);
            delete = (FloatingActionButton) itemView.findViewById(R.id.remove_recipe);

        }
    }



}
