package com.example.firsttest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Target;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ArticleGoodOffersAdapter extends RecyclerView.Adapter<ArticleGoodOffersAdapter.ViewHolder> {

    LayoutInflater inflater;
    List<ArticleGoodOffersData> list;


    public ArticleGoodOffersAdapter(List<ArticleGoodOffersData> list, Context context) {
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ArticleGoodOffersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycler_good_offers_row,parent,false);

        return new ViewHolder(view);
    }

    @Override

    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ArticleGoodOffersData currentArticleGoodOffersData = list.get(position);

        holder.dateGoodOffers.setText(currentArticleGoodOffersData.getDate().toString() + " дней");
        holder.textGoodOffers.setText(currentArticleGoodOffersData.getText());
        holder.rateGoodOffers.setText(currentArticleGoodOffersData.getRate());
        holder.sumGoodOffers.setText(currentArticleGoodOffersData.getSum() + " рублей");
        holder.buttonTextGoodOffer.setText(currentArticleGoodOffersData.getButton_text());

        SecondActivityMain.buttonGoodOffersUrl = currentArticleGoodOffersData.button_url;

        //  RequestCreator bgImage =  Picasso.get().load(currentArticleGoodOffersData.getImage());

       /* Drawable drw = ImageOperations(this,currentArticleGoodOffersData.getImage(), "drawable");
        holder.bgGoodOffers.setBackground(drw);*/


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView dateGoodOffers;
        final TextView rateGoodOffers;
        final TextView textGoodOffers;
        final TextView sumGoodOffers;
        final TextView buttonTextGoodOffer;
        final LinearLayout bgGoodOffers;

        ViewHolder(View view){
            super(view);
            //imageView = view.findViewById(R.id.linearLayout_row_good_offers);
            dateGoodOffers =  view.findViewById(R.id.text_date_good_offers);
            rateGoodOffers = view.findViewById(R.id.text_rate_good_offers);
            textGoodOffers = view.findViewById(R.id.text_text_good_offers);
            sumGoodOffers = view.findViewById(R.id.text_sum_good_offers);
            buttonTextGoodOffer = view.findViewById(R.id.button_good_offers);
            bgGoodOffers = view.findViewById(R.id.linearLayout_row_good_offers);



        }
    }
    /*private Drawable ImageOperations(ArticleGoodOffersAdapter ctx, String url, String saveFilename) {
        try {
            InputStream is = (InputStream) this.fetch(url);
            Drawable d = Drawable.createFromStream(is, saveFilename);
            return d;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object fetch(String address) throws MalformedURLException,IOException {
        URL url = new URL(address);
        Object content = url.getContent();
        return content;
    }*/
}
