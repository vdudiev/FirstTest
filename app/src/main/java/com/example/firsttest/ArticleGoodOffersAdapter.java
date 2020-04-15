package com.example.firsttest;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

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


      //Picasso.get().load(currentArticleGoodOffersData.getImage()).into(holder.imageView);

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
        //final ImageView imageView;
        //final  buttonTextGoodOfferURL;
        ViewHolder(View view){
            super(view);
            //imageView = view.findViewById(R.id.linearLayout_row_good_offers);
            dateGoodOffers =  view.findViewById(R.id.text_date_good_offers);
            rateGoodOffers = view.findViewById(R.id.text_rate_good_offers);
            textGoodOffers = view.findViewById(R.id.text_text_good_offers);
            sumGoodOffers = view.findViewById(R.id.text_sum_good_offers);
            buttonTextGoodOffer = view.findViewById(R.id.button_good_offers);



        }
    }
}
