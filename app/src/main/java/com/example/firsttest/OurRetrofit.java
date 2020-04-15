package com.example.firsttest;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OurRetrofit {
    @GET("getNews.php")
    Call<Article> getArticle();
}
