package com.example.firsttest;

import java.util.ArrayList;

public class ArticleProductionMethods {

    String error = null;
    Boolean success;
    ArrayList<ArticleProductionMethodsData> data;


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

    public ArrayList<ArticleProductionMethodsData> getData() {
        return data;
    }

    public void setData(ArrayList<ArticleProductionMethodsData> data) {
        this.data = data;
    }
}
