package com.example.firsttest;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class BottomSheetDialogDetailsCompanies extends BottomSheetDialogFragment {
    ArticleProductionMethodsAdapter adapter;

    private TextView textViewSumToSumDetailsBottomSheet;
    private TextView textViewDateToDateDetailsBottomSheet;
    private TextView texViewRateDetailsBottomSheet;
    private TextView textViewRequirementForBorrowerDetailsBottomSheet;
    private TextView textViewWayOfGettingDetailsBottomSheet;
    private TextView textViewRepaymentOptionDetailsBottomSheet;
    private ImageView imageViewLogoDetailsBottomSheet;
    private Button buttonSendRequestDetailsBottomSheet;

    ArticleLoansData dataListLoans;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.bottom_sheet_companies_details, container, false);


        textViewSumToSumDetailsBottomSheet = root.findViewById(R.id.textView_sum_toSum_details_bottomSheet);
        textViewDateToDateDetailsBottomSheet = root.findViewById(R.id.textView_date_toDate_details_bottomSheet);
        texViewRateDetailsBottomSheet = root.findViewById(R.id.texView_rate_details_bottomSheet);
        textViewRequirementForBorrowerDetailsBottomSheet = root.findViewById(R.id.textView_requirement_for_borrower_details_bottomSheet);
        textViewWayOfGettingDetailsBottomSheet = root.findViewById(R.id.textView_way_of_getting_details_bottomSheet);
        textViewRepaymentOptionDetailsBottomSheet  = root.findViewById(R.id.textView_repayment_option_details_bottomSheet);
        imageViewLogoDetailsBottomSheet = root.findViewById(R.id.imageView_logo_details_bottomSheet);
        buttonSendRequestDetailsBottomSheet = root.findViewById(R.id.button_send_request_details_bottomSheet);
        setDataBottomSheetDetails(dataListLoans);
        Button buttonCloseBottomSheetDetails = root.findViewById(R.id.button_close_details_bottomSheet);
        buttonCloseBottomSheetDetails.setOnClickListener(v -> dismiss());
        return root;
    }


    private void setDataBottomSheetDetails(ArticleLoansData dataList){
        textViewSumToSumDetailsBottomSheet.setText("ОТ "+ toInt(dataList.getSum())+" ДО "+ toInt(dataList.getTo_sum()));
        textViewDateToDateDetailsBottomSheet.setText("ОТ "+ toInt(dataList.getDate())+" ДО "+ toInt(dataList.to_date));
        texViewRateDetailsBottomSheet.setText(dataList.getRate()+"%"+" - "+dataList.getTo_rate()+"%");
        textViewRequirementForBorrowerDetailsBottomSheet.setText(dataList.getRequirement_for_borrower());
        textViewWayOfGettingDetailsBottomSheet.setText(dataList.getWay_of_getting());
        textViewRepaymentOptionDetailsBottomSheet.setText(dataList.getRepayment_option());
        Picasso.get().load(dataList.getLogo()).into(imageViewLogoDetailsBottomSheet);
        buttonSendRequestDetailsBottomSheet.setText(dataList.button_text);
        buttonSendRequestDetailsBottomSheet.setOnClickListener(v -> {
            Intent browserIntent = new
                    Intent(Intent.ACTION_VIEW, Uri.parse(dataList.getButton_url()));
            startActivity(browserIntent);
        });
    }

    private static String format ( double value )
    {
        return NumberFormat.getInstance (Locale.US).format ( value ) ;
    }
    private int toInt(Float value){
        return value.intValue();
    }

}
