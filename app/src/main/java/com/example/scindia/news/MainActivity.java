package com.example.scindia.news;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    RecyclerView recyclerView;
    NewsAdapter newsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.rv);
        newsAdapter = new NewsAdapter(this,new ArrayList<BaseNews>());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(newsAdapter);

        NewsApi newsApi = RestApi.getInstance().getNewsApi();
        newsApi.getNews("abc-news-au","top","5c393c0600584930a6c1834a911fb243").enqueue(new Callback<Newsfeed>() {
            @Override
            public void onResponse(Call<Newsfeed> call, Response<Newsfeed> response) {
                Log.d(TAG, "onResponse: "+response.body().component4());
                newsAdapter.onUpdateList(new ArrayList<BaseNews>(Arrays.asList(response.body().getArticles())));
            }

            @Override
            public void onFailure(Call<Newsfeed> call, Throwable t) {

            }
        });

    }
}
