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
import com.example.retrofitglide.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder>{
    public List<Movie> movieList = new ArrayList<>();

    @NonNull
    @Override
    public MovieListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new MovieListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieListViewHolder holder, int position){
        Movie movie = movieList.get(position);

        holder.title.setText(movie.name);
        holder.id.setText(String.valueOf(movie.id));
        GlideApp.with(holder.itemView.getContext()).load(movie.image.medium_url).into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class MovieListViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView id;
        ImageView poster;
        public MovieListViewHolder(View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.heroeid);
            title = itemView.findViewById(R.id.movieTitle);
            poster = itemView.findViewById(R.id.movieImage);
        }
    }
}