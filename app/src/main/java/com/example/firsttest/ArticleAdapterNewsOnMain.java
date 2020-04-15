package com.example.firsttest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ArticleAdapterNewsOnMain extends RecyclerView.Adapter<ArticleAdapterNewsOnMain.ViewHolder> {

    LayoutInflater inflater;
    List<ArticleData> list;

    public ArticleAdapterNewsOnMain(List<ArticleData> list, Context context) {
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ArticleAdapterNewsOnMain.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycler_row_news_on_main,parent,false);

        return new ViewHolder(view);
    }

    @Override

    public void onBindViewHolder(@NonNull ArticleAdapterNewsOnMain.ViewHolder holder, int position) {
       ArticleData currentArticleData = list.get(position);
       holder.titleView.setText(currentArticleData.getTitle());
       holder.textView.setText(currentArticleData.getText());
       Picasso.get().load(currentArticleData.getImage()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;
        final TextView textView, titleView;
        ViewHolder(View view){
            super(view);
            imageView = view.findViewById(R.id.image_news);
            textView =  view.findViewById(R.id.body_text_news);
            titleView = view.findViewById(R.id.title_text_news);
        }
    }
}
