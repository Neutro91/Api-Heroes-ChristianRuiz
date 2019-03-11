package com.example.retrofitglide.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.retrofitglide.GlideApp;
import com.example.retrofitglide.R;
import com.example.retrofitglide.model.ObjectHeroes;

import java.util.ArrayList;
import java.util.List;

public class ObjectListAdapter extends RecyclerView.Adapter<ObjectListAdapter.ObjectViewHolder>{
    public List<ObjectHeroes> objectHeroesList = new ArrayList<>();

    @NonNull
    @Override
    public ObjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_character, parent, false);
        return new ObjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ObjectViewHolder holder, int position){
        ObjectHeroes objectHeroes = objectHeroesList.get(position);

        holder.title.setText(objectHeroes.name);
        holder.id.setText(String.valueOf(objectHeroes.id));
        GlideApp.with(holder.itemView.getContext()).load(objectHeroes.image.medium_url).into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return objectHeroesList.size();
    }

    class ObjectViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView id;
        ImageView poster;
        public ObjectViewHolder(View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.heroeid);
            title = itemView.findViewById(R.id.movieTitle);
            poster = itemView.findViewById(R.id.movieImage);
        }
    }
}