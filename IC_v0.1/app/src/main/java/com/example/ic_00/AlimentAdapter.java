package com.example.ic_00;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AlimentAdapter extends RecyclerView.Adapter<AlimentAdapter.ViewProcessHolder> {

    Context context;
    private ArrayList<Aliment> item; //memanggil modelData

    public AlimentAdapter(Context context, ArrayList<Aliment> item) {
        this.context = context;
        this.item = item;
    }

    @NonNull
    @Override
    public ViewProcessHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.liked_food_list, parent, false); //memanggil layout list recyclerview
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

        final Aliment data = item.get(position);
        holder.id.setText(""+data.getId());//menampilkan data
        holder.aliment.setText(data.getAliment());//menampilkan data
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class ViewProcessHolder extends RecyclerView.ViewHolder {

        TextView aliment,id;

        public ViewProcessHolder(@NonNull View itemView) {
            super(itemView);

            id = (TextView) itemView.findViewById(R.id.food_list_id);
            aliment = (TextView) itemView.findViewById(R.id.food_list_aliment);

        }
    }
}