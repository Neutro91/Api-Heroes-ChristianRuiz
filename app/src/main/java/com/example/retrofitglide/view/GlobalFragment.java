package com.example.retrofitglide.view;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.retrofitglide.MainViewModel;
import com.example.retrofitglide.R;
import com.example.retrofitglide.model.Movie;

import java.util.List;


public abstract class GlobalFragment extends Fragment {

    MainViewModel mViewModel;
    private MovieListAdapter mMovieListAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movies, container, false);

        RecyclerView mRecyclerView = view.findViewById(R.id.recyclermovies);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mMovieListAdapter = new MovieListAdapter();
        mRecyclerView.setAdapter(mMovieListAdapter);

        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        getPelis().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(@Nullable List<Movie> movies) {
                mMovieListAdapter.movieList=movies;
                mMovieListAdapter.notifyDataSetChanged();
            }
        });

//        mViewModel.getMovies().observe(this, new Observer<List<Movie>>() {
//            @Override
//            public void onChanged(@Nullable List<Movie> movies) {
//                mMovieListAdapter.movieList = movies;
//                mMovieListAdapter.notifyDataSetChanged();
//            }
//        });
        return view;
    }

    public abstract LiveData<List<Movie>> getPelis();
}
