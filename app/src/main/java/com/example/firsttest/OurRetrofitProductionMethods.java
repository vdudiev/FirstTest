package com.example.firsttest;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OurRetrofitProductionMethods {
    @GET("getIssuance.php")
    Call<ArticleProductionMethods> getArticleProductionMethods();
}
