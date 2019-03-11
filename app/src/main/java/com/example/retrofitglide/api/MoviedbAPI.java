package com.example.retrofitglide.api;
import com.example.retrofitglide.model.CharactersResponse;
import com.example.retrofitglide.model.MoviesResponse;
import com.example.retrofitglide.model.ObjectResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviedbAPI {
    @GET("movies")
    Call<MoviesResponse> getMovies();

    @GET("characters")
    Call<CharactersResponse> getCharacters();

    @GET("objects")
    Call<ObjectResponse> getObjects();


}
