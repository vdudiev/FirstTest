package com.example.firsttest;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SecondActivityMain extends AppCompatActivity {
    public static final String EXTRA_TEXT = "com.example.application.example.EXTRA_TEXT";

    Retrofit retrofit;
    Retrofit retrofitGoodOffers;
    RecyclerView recyclerView;
    RecyclerView recyclerViewGoodOffers;
    static TextView method;
    String name = "Наличными";
    Context context = this;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_main);

        method = findViewById(R.id.textView_name_selected_method);
        method.setText(name);


        //FOR NEWS
        recyclerView = findViewById(R.id.recyclerViewOnMain);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
         retrofit = new Retrofit.Builder()
                .baseUrl("http://uzaim.ru/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        OurRetrofit ourRetrofit = retrofit.create(OurRetrofit.class);
        ourRetrofit.getArticle().enqueue(new Callback<Article>(){
            @Override
            public void onResponse(Call<Article> call, Response<Article> response) {
                ArticleAdapterNewsOnMain adapter = new ArticleAdapterNewsOnMain(response.body().getData(), context);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Article> call, Throwable t) {

            }
        });

        //FOR GOOD OFFERS
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                SecondActivityMain.this,LinearLayoutManager.HORIZONTAL,false
        );
        recyclerViewGoodOffers = findViewById(R.id.recyclerView_good_offers);
        recyclerViewGoodOffers.setLayoutManager(layoutManager);

        retrofitGoodOffers = new Retrofit.Builder()
                .baseUrl("http://uzaim.ru/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        OurRetrofitGoodOffers ourRetrofitGoodOffers = retrofitGoodOffers.create(OurRetrofitGoodOffers.class);
        ourRetrofitGoodOffers.getArticleGoodOffers().enqueue(new Callback<ArticleGoodOffers>() {

            @Override
            public void onResponse(Call<ArticleGoodOffers> call, Response<ArticleGoodOffers> responseGoodOffers) {
                ArticleGoodOffersAdapter adapterGoodOffers = new ArticleGoodOffersAdapter(responseGoodOffers.body().getData(), context);
                recyclerViewGoodOffers.setAdapter(adapterGoodOffers);
            }
            @Override
            public void onFailure(Call<ArticleGoodOffers> call, Throwable t) {

            }
        });
    }


    public void changeNameMethod (String n){
        name = n;
        method.setText(name);
    }


    public void calcOpenSecondAct(View view) {
        String bottomBarItemNumber = "2";
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(EXTRA_TEXT, bottomBarItemNumber);
        startActivity(intent);
    }

    public void pickUpOpenSecondAct(View view) {


        TextView textViewNameSelectedMethod = findViewById(R.id.textView_name_selected_method);
        EditText textViewSumLoansSecondMain = findViewById(R.id.textView_sum_loans_second_main);
        EditText textViewDateLoansSecondMain = findViewById(R.id.textView_date_loans_second_main);

        String methodNameToSend = textViewNameSelectedMethod.getText().toString();
        Float sumLoansToSend = Float.parseFloat(textViewSumLoansSecondMain.getText().toString());
        Float dateLoansToSend = Float.parseFloat(textViewDateLoansSecondMain.getText().toString());

        fragmentHome  fragmentHome = new fragmentHome();

        fragmentHome.changeParametersOnMainToHome(methodNameToSend,sumLoansToSend,dateLoansToSend);





        String bottomBarItemNumber = "1";
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(EXTRA_TEXT, bottomBarItemNumber);
        startActivity(intent);
    }
    public void newsOpenSecondAct(View view) {
        String bottomBarItemNumber = "3";
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(EXTRA_TEXT, bottomBarItemNumber);
        startActivity(intent);
    }

    static String buttonGoodOffersUrl;
    public void OpenBrowserGoodOffers(View view) {
        Intent browserIntent = new
                Intent(Intent.ACTION_VIEW, Uri.parse(buttonGoodOffersUrl));
        startActivity(browserIntent);
    }

    public void openBottomSheet(View view){
        BottomSheetDialogSecondMain bottomSheetDialogSecondMain = new BottomSheetDialogSecondMain();
        bottomSheetDialogSecondMain.show(getSupportFragmentManager(),"bottomSheetDialogSecondMain");
    }














}
