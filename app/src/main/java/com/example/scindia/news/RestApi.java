package com.example.scindia.news;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by SCINDIA on 7/10/2017.
 */

public class RestApi {

    private NewsApi newsApi;
    private static RestApi restApi;
    private Retrofit retrofit;

    public NewsApi getNewsApi() {
        return newsApi;
    }

    private RestApi() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org")
                .addConverterFactory(
                        GsonConverterFactory.create()
                )
                .build();
        newsApi = retrofit.create(NewsApi.class);
    }

    public static RestApi getInstance(){
        if(restApi==null){
            restApi = new RestApi();
        }
        return restApi;
    }
    }
