package com.example.firsttest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ArticleLoansAdapter extends RecyclerView.Adapter<ArticleLoansAdapter.ViewHolder> {

    LayoutInflater inflater;

    List<ArticleLoansData> list;

    public ArticleLoansAdapter(List<ArticleLoansData> list, Context context) {
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ArticleLoansAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycler_row_loans, parent, false);

        Button detailsButton = view.findViewById(R.id.button_details_row_loans);
        detailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondActivityMain secondActivityMain = new SecondActivityMain();
                secondActivityMain.openCompaniesDetailsBottomSheet();

            }
        });


        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override

    public void onBindViewHolder(@NonNull ArticleLoansAdapter.ViewHolder holder, int position) {
        ArticleLoansData currentArticleData = list.get(position);
        Picasso.get().load(currentArticleData.getLogo()).into(holder.logo);
        holder.name.setText(currentArticleData.getName());
        holder.sum.setText("Сумма: От " + currentArticleData.getSum() + " до " + currentArticleData.getTo_sum());
        holder.date.setText("Срок: От " + currentArticleData.getDate() + " до " + currentArticleData.getTo_date());
        holder.rate.setText("Ставка: " + currentArticleData.getRate() + "-" + currentArticleData.getTo_rate() + "%");


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView logo;
        final TextView name;
        final TextView sum;
        final TextView date;
        final TextView rate;

        ViewHolder(View view) {
            super(view);
            logo = view.findViewById(R.id.image_Loans_row);
            name = view.findViewById(R.id.textView_name_loans);
            sum = view.findViewById(R.id.textView_sum_loans);
            date = view.findViewById(R.id.textView_date_loans);
            rate = view.findViewById(R.id.textView_rate_loans);

        }
    }

}
