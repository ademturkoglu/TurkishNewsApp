package com.example.mynewsapp.Network;

import com.example.mynewsapp.models.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInt {
    @GET("top-headlines")
    Call<News> getNews(
            @Query("country") String country,
            @Query("apiKey") String apiKey,
            @Query("category") String category
    );

}
