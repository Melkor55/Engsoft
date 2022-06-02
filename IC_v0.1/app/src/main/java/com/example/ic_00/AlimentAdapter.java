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
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vishnusivadas.advanced_httpurlconnection.PutData;

import java.util.ArrayList;

public class AlimentAdapter extends RecyclerView.Adapter<AlimentAdapter.ViewProcessHolder> {

    Context context;
    private String table;
    private ArrayList<Aliment> aliments; //memanggil modelData
    private ItemClickListener mClickListener;

    public AlimentAdapter(Context context, ArrayList<Aliment> aliments, String table) {
        this.context = context;
        this.table = table;
        this.aliments = aliments;
    }

    @NonNull
    @Override
    public ViewProcessHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_list, parent, false); //memanggil layout list recyclerview
        ViewProcessHolder processHolder = new ViewProcessHolder(view);
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
    public void onBindViewHolder(@NonNull ViewProcessHolder holder, int position) {

        final Aliment data = aliments.get(position);
        //holder.id.setText(""+data.getId());//menampilkan data
        holder.id.setText(null);//
        holder.aliment.setText(data.getAliment());//menampilkan data
        //int position = holder.getAdapterPosition();
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
                aliments.remove(theRemovedItem);  // remove the item from list
                notifyItemRemoved(holder.getAdapterPosition()); // notify the adapter about the removed item
            }
        });

    }

    @Override
    public int getItemCount() {
        return aliments.size();
    }

    public class ViewProcessHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView aliment,id;
        FloatingActionButton delete;

        public ViewProcessHolder(@NonNull View itemView) {
            super(itemView);

            id = (TextView) itemView.findViewById(R.id.food_list_id);
            aliment = (TextView) itemView.findViewById(R.id.food_list_aliment);
            delete = (FloatingActionButton) itemView.findViewById(R.id.remove_liked_food);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}