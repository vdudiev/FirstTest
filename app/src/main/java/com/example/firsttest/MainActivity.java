package com.example.firsttest;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import static com.example.firsttest.R.id;
import static com.example.firsttest.R.layout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        BottomNavigationView navigationView  = findViewById( R.id.BottomNavigation);
        Intent intent = getIntent();
        String buttomBarItemNumber = intent.getStringExtra(SecondActivityMain.EXTRA_TEXT);

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id){
                    case R.id.action_calculator:
                        FragmentCalculator fragmentCalc = new FragmentCalculator();
                        FragmentTransaction fragmentTransactionCalc = getSupportFragmentManager().beginTransaction();
                        fragmentTransactionCalc.replace(R.id.Fragment_content,fragmentCalc);
                        fragmentTransactionCalc.commit();
                        break;
                    case R.id.action_news:
                        FragmentNews fragmentNews = new FragmentNews();
                        FragmentTransaction fragmentTransactionNews = getSupportFragmentManager().beginTransaction();
                        fragmentTransactionNews.replace(R.id.Fragment_content,fragmentNews);
                        fragmentTransactionNews.commit();
                        break;
                    case R.id.action_home:
                        fragmentHome fragmentHome = new fragmentHome();
                        FragmentTransaction fragmentTransactionHome = getSupportFragmentManager().beginTransaction();
                        fragmentTransactionHome.replace(R.id.Fragment_content,fragmentHome);
                        fragmentTransactionHome.commit();
                        break;
                }
                return true;
            }
        });
       switch (buttomBarItemNumber){
           case "1":
               navigationView.setSelectedItemId(id.action_home);
           break;
           case "2":
               navigationView.setSelectedItemId(id.action_calculator);
               break;
           case "3":
               navigationView.setSelectedItemId(id.action_news);
               break;
       }
    }




    @SuppressLint("SetTextI18n")
    public void onClick(View view) {
        TextView amountOut = findViewById(id.amount_output);
        EditText amountIn = findViewById(id.Edit_amount_input);
        EditText daysIn = findViewById(id.EditText_input_days);
        EditText ratePrIn = findViewById(id.EditText_input_rate_percent);

        TextView daysOut = findViewById(id.days_output);
        TextView ratePrOut = findViewById(id.percent_output);
        TextView amountToReturnOut = findViewById(id.amount_to_return_output);
        TextView overpaymentOut = findViewById(id.overpayment_output);
        double startAmount = Double.parseDouble(amountIn.getText().toString());
        double S = Double.parseDouble(amountIn.getText().toString());
        double days = Double.parseDouble(daysIn.getText().toString());
        double percents = Double.parseDouble(ratePrIn.getText().toString());

        for (int i = 0; i < days; i++) {
            S = (startAmount / 100 * percents) + S ;
        }
        daysOut.setText(daysIn.getText());
        amountOut.setText(amountIn.getText());
        ratePrOut.setText(ratePrIn.getText()+ "%");

        amountToReturnOut.setText(Double.toString(S));
        overpaymentOut.setText(Double.toString(S - startAmount));
    }

    public void openNewsDetails(){
        FragmentTransaction fragmentTransactionNewsDetails = getSupportFragmentManager().beginTransaction();
        FragmentNewsDetails fragmentNewsDetails = new FragmentNewsDetails();
        fragmentTransactionNewsDetails.replace(R.id.Fragment_content,fragmentNewsDetails);
        fragmentTransactionNewsDetails.addToBackStack(null);
        fragmentTransactionNewsDetails.commit();
    }


}





