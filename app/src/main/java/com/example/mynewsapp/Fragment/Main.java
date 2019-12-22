package com.example.mynewsapp.Fragment;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mynewsapp.Adapter;
import com.example.mynewsapp.MainActivity;
import com.example.mynewsapp.Network.Api;
import com.example.mynewsapp.Network.ApiInt;
import com.example.mynewsapp.NewsDetailsActivity;
import com.example.mynewsapp.R;
import com.example.mynewsapp.models.Article;
import com.example.mynewsapp.models.News;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main extends Fragment {

    public static final String API_KEY = "a7005718783643a99d8d61f79325aa58";
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Article> articles = new ArrayList<>();
    private Adapter adapter;
    private String TAG = MainActivity.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = inflater.inflate(R.layout.activity_main, container, false);


        recyclerView = view.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);

        loadJson();

        return view;
    }

    public void loadJson(){
        ApiInt apiInt = Api.getApi().create(ApiInt.class);
        final String country = "tr";

        Call<News> call;
        call = apiInt.getNews(country, API_KEY , "general");

        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                if (response.isSuccessful() && response.body().getArticle() != null){
                    if(articles.isEmpty()){
                        articles.clear();
                    }
                    articles = response.body().getArticle();
                    adapter = new Adapter(articles,getActivity());
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                    initListener();

                }else{
                    Toast.makeText(getActivity(),"İnternet bağlantısını kontrol edin",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

            }
        });

    }

    private void initListener(){
        adapter.setOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), NewsDetailsActivity.class);
                Article article = articles.get(position);

                intent.putExtra("url", article.getUrl());

                startActivity(intent);
            }
        });

    }

}
