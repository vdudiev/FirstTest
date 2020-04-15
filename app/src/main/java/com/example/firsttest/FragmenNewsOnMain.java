package com.example.firsttest;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmenNewsOnMain extends Fragment {
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_second_main, container, false);
        recyclerView = root.findViewById(R.id.recyclerViewOnMain);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        Context context = getActivity();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://uzaim.ru/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        OurRetrofit ourRetrofit = retrofit.create(OurRetrofit.class);
        ourRetrofit.getArticle().enqueue(new Callback<Article>(){
            @Override
            public void onResponse(Call<Article> call, Response<Article> response) {
                ArticleAdapterNewsOnMain adapter = new ArticleAdapterNewsOnMain(response.body().getData(), context);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Article> call, Throwable t) {

            }
        });


        // Inflate the layout for this fragment
        return root;
    }
}
