package com.example.scindia.news;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {

    @GET("/v1/articles")
    Call<Newsfeed> getNews(
            @Query("source") String source,
            @Query("sortBy") String sort,
            @Query("apiKey") String key
    );
}
