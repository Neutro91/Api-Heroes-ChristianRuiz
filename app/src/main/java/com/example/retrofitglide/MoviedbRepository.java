package com.example.retrofitglide;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.example.retrofitglide.api.MoviedbAPI;
import com.example.retrofitglide.api.MoviedbModule;
import com.example.retrofitglide.model.Character;
import com.example.retrofitglide.model.CharactersResponse;
import com.example.retrofitglide.model.Movie;
import com.example.retrofitglide.model.MoviesResponse;
import com.example.retrofitglide.model.ObjectHeroes;
import com.example.retrofitglide.model.ObjectResponse;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviedbRepository {
    MoviedbAPI moviedbAPI;

    public MoviedbRepository(){
        moviedbAPI = MoviedbModule.getAPI();
    }

    public LiveData<List<Movie>> getMovies(){
        final MutableLiveData<List<Movie>> lista = new MutableLiveData<>();

        moviedbAPI.getMovies().enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                lista.setValue(response.body().results);
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
            }
        });
        return lista;
    }

    public LiveData<List<Character>> getCharacters(){
        final MutableLiveData<List<Character>> lista = new MutableLiveData<>();

        moviedbAPI.getCharacters().enqueue(new Callback<CharactersResponse>() {
            @Override
            public void onResponse(Call<CharactersResponse> call, Response<CharactersResponse> response) {
                lista.setValue(response.body().results);
            }

            @Override
            public void onFailure(Call<CharactersResponse> call, Throwable t) {
            }
        });
        return lista;
    }

    public LiveData<List<ObjectHeroes>> getObjects(){
        final MutableLiveData<List<ObjectHeroes>> lista = new MutableLiveData<>();

        moviedbAPI.getObjects().enqueue(new Callback<ObjectResponse>() {
            @Override
            public void onResponse(Call<ObjectResponse> call, Response<ObjectResponse> response) {
                lista.setValue(response.body().results);
            }

            @Override
            public void onFailure(Call<ObjectResponse> call, Throwable t) {
            }
        });
        return lista;
    }

}