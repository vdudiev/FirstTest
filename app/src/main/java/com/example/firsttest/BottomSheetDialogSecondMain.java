package com.example.firsttest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class BottomSheetDialogSecondMain extends BottomSheetDialogFragment {
    private RecyclerView recyclerView;
    ArticleProductionMethodsAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.bottom_sheet_second_main_layout, container, false);
        recyclerView = root.findViewById(R.id.recyclerview_bottom_sheet_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        Context context = getActivity();
        Retrofit retrofitBottomSheet = new Retrofit.Builder()
                .baseUrl("http://uzaim.ru/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        OurRetrofitProductionMethods ourRetrofit = retrofitBottomSheet.create(OurRetrofitProductionMethods.class);
        ourRetrofit.getArticleProductionMethods().enqueue(new Callback<ArticleProductionMethods>(){
            @Override
            public void onResponse(Call<ArticleProductionMethods> call, Response<ArticleProductionMethods> response) {
                adapter = new ArticleProductionMethodsAdapter(response.body().getData(), context);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<ArticleProductionMethods> call, Throwable t) {

            }

        });

        Button closeButton   = root.findViewById(R.id.close_button_bottom_sheet);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondActivityMain secondActivityMain = new SecondActivityMain();
                secondActivityMain.changeNameMethod(adapter.selectedMethodName);
                dismiss();
            }
        });
        return root;
    }


}
