package com.example.firsttest;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ArticleProductionMethodsAdapter extends RecyclerView.Adapter<ArticleProductionMethodsAdapter.ViewHolder> {

    LayoutInflater inflater;
    List<ArticleProductionMethodsData> list;
    String selectedMethodName = "Наличными";

    public ArticleProductionMethodsAdapter(List<ArticleProductionMethodsData> list, Context context) {
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ArticleProductionMethodsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycler_row_bottom_sheet,parent,false);
        return new ViewHolder(view);
    }



    @Override

    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ArticleProductionMethodsData currentArticleProductionMethodsData = list.get(position);

        holder.name.setText(currentArticleProductionMethodsData.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView name;

        ViewHolder(View view){
            super(view);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                 selectedMethodName = list.get(getAdapterPosition()).name;
                }
            });

            name = view.findViewById(R.id.text_name_bottom_sheet_list);

        }
    }
    public interface OnNoteListener{
        void onNoteClick(int position);
    }


}
