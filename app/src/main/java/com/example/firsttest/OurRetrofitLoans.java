package com.example.firsttest;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OurRetrofitLoans {
    @GET("getCompanies.php")
    Call<ArticleLoans> getArticleLoans();
}
