package com.example.retrofitglide;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.retrofitglide.model.Character;
import com.example.retrofitglide.model.Movie;
import com.example.retrofitglide.model.ObjectHeroes;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private MoviedbRepository moviedbRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        moviedbRepository = new MoviedbRepository();

    }

    public LiveData<List<Movie>> getMovies() {
        return moviedbRepository.getMovies();
    }

    public LiveData<List<Character>> getCharacter() {
        return moviedbRepository.getCharacters();
    }

    public LiveData<List<ObjectHeroes>> getObjects() {
        return moviedbRepository.getObjects();
    }

}
