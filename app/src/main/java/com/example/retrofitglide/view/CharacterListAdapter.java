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
import com.example.retrofitglide.model.Character;
import com.example.retrofitglide.model.Movie;

import java.util.ArrayList;
import java.util.List;

public  class CharacterListAdapter extends RecyclerView.Adapter<CharacterListAdapter.CharacterViewHolder>{
    public List<Character> characterList = new ArrayList<>();

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_character, parent, false);
        return new CharacterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position){
        Character character = characterList.get(position);

        holder.title.setText(character.name);
        holder.id.setText(String.valueOf(character.id));
        GlideApp.with(holder.itemView.getContext()).load(character.image.medium_url).into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return characterList.size();
    }

    class CharacterViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView id;
        ImageView poster;
        public CharacterViewHolder(View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.heroeid);
            title = itemView.findViewById(R.id.movieTitle);
            poster = itemView.findViewById(R.id.movieImage);
        }
    }
}