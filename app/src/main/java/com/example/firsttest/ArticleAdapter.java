package com.example.firsttest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    LayoutInflater inflater;
    private List<ArticleData> list;
    private String titleDetailsToSet;
    private String textDetailsToSet;
    private String imageDetailsToSet;
    private Context cont;

    ArticleAdapter(List<ArticleData> list,Context context) {
        this.list = list;
        this.inflater = LayoutInflater.from(context);
        cont = context;
    }

    @NonNull
    @Override
    public ArticleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycler_row,parent,false);

        return new ViewHolder(view);
    }

    @Override

    public void onBindViewHolder(@NonNull ArticleAdapter.ViewHolder holder, int position) {
       ArticleData currentArticleData = list.get(position);
       holder.titleView.setText(currentArticleData.getTitle());
       holder.textView.setText(currentArticleData.getText());
       Picasso.get().load(currentArticleData.getImage()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;
        final TextView textView, titleView;
        ViewHolder(View view){
            super(view);
            view.setOnClickListener(v -> {
                titleDetailsToSet = list.get(getAdapterPosition()).title;
                textDetailsToSet = list.get(getAdapterPosition()).text;
                imageDetailsToSet = list.get(getAdapterPosition()).image;


                   FragmentTransaction fragmentTransactionNewsDetails = ((FragmentActivity)cont).getSupportFragmentManager().beginTransaction();
                    FragmentNewsDetails fragmentNewsDetails = new FragmentNewsDetails();
                    fragmentNewsDetails.titleDetails = titleDetailsToSet;
                    fragmentNewsDetails.imageDetails = imageDetailsToSet;
                    fragmentNewsDetails.textDetails = textDetailsToSet;
                    fragmentTransactionNewsDetails.replace(R.id.Fragment_content,fragmentNewsDetails);
                    fragmentTransactionNewsDetails.addToBackStack(null);
                    fragmentTransactionNewsDetails.commit();
            });

            imageView = view.findViewById(R.id.image_news);
            textView =  view.findViewById(R.id.body_text_news);
            titleView = view.findViewById(R.id.title_text_news);
        }
    }

}
