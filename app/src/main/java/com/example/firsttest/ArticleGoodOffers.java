package com.example.firsttest;

import java.util.ArrayList;

public class ArticleGoodOffers {

    String error = null;
    Boolean success;
    ArrayList<ArticleGoodOffersData> data;



    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public ArrayList<ArticleGoodOffersData> getData() {
        return data;
    }

    public void setData(ArrayList<ArticleGoodOffersData> data) { this.data = data; }


}
