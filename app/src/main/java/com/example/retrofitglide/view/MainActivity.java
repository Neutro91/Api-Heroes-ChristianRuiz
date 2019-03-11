package com.example.retrofitglide.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.retrofitglide.MainViewModel;
import com.example.retrofitglide.R;
import com.example.retrofitglide.model.Movie;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mViewModel;
    private RecyclerView mRecyclerView;
    private MovieListAdapter mMovieListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.movieList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mMovieListAdapter = new MovieListAdapter();
        mRecyclerView.setAdapter(mMovieListAdapter);

        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mViewModel.getMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(@Nullable List<Movie> movies) {
                mMovieListAdapter.movieList = movies;
                mMovieListAdapter.notifyDataSetChanged();
            }
        });
    }
}
