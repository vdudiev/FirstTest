package com.example.firsttest;

import java.util.ArrayList;

public class Article {

    String error = null;
    Boolean success;
    ArrayList<ArticleData> data;



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

    public ArrayList<ArticleData> getData() {
        return data;
    }

    public void setData(ArrayList<ArticleData> data) { this.data = data; }


}
