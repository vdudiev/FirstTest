package com.example.firsttest;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OurRetrofitGoodOffers {
    @GET("getOffers.php")
    Call<ArticleGoodOffers> getArticleGoodOffers();
}
