package com.example.firsttest;

import java.util.ArrayList;

public class ArticleLoans {

    String error = null;
    Boolean success;
    ArrayList<ArticleLoansData> data;


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

    public ArrayList<ArticleLoansData> getData() {
        return data;
    }

    public void setData(ArrayList<ArticleLoansData> data) {
        this.data = data;
    }
}
