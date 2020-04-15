package com.example.firsttest;

import android.view.ViewDebug;

import java.util.ArrayList;

public class ArticleLoansData {
    Float id;
    String logo;
    String name;
    Float sum;
    Float to_sum;
    Float date;
    Float to_date;
    Float rate;
    Float to_rate;
    String requirement_for_borrower;
    String way_of_getting;
    String repayment_option;
    String button_url;
    String button_text;
    ArrayList<String> issuance;

    public Float getId() {
        return id;
    }

    public void setId(Float id) {
        this.id = id;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getSum() {
        return sum;
    }

    public void setSum(Float sum) {
        this.sum = sum;
    }

    public Float getTo_sum() {
        return to_sum;
    }

    public void setTo_sum(Float to_sum) {
        this.to_sum = to_sum;
    }

    public Float getDate() {
        return date;
    }

    public void setDate(Float date) {
        this.date = date;
    }

    public Float getTo_date() {
        return to_date;
    }

    public void setTo_date(Float to_date) {
        this.to_date = to_date;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    public Float getTo_rate() {
        return to_rate;
    }

    public void setTo_rate(Float to_rate) {
        this.to_rate = to_rate;
    }

    public String getRequirement_for_borrower() {
        return requirement_for_borrower;
    }

    public void setRequirement_for_borrower(String requirement_for_borrower) {
        this.requirement_for_borrower = requirement_for_borrower;
    }

    public String getWay_of_getting() {
        return way_of_getting;
    }

    public void setWay_of_getting(String way_of_getting) {
        this.way_of_getting = way_of_getting;
    }

    public String getRepayment_option() {
        return repayment_option;
    }

    public void setRepayment_option(String repayment_option) {
        this.repayment_option = repayment_option;
    }

    public String getButton_url() {
        return button_url;
    }

    public void setButton_url(String button_url) {
        this.button_url = button_url;
    }

    public String getButton_text() {
        return button_text;
    }

    public void setButton_text(String button_text) {
        this.button_text = button_text;
    }

    public ArrayList<String> getIssuance() {
        return issuance;
    }

    public void setIssuance(ArrayList<String> issuance) {
        this.issuance = issuance;
    }
}
