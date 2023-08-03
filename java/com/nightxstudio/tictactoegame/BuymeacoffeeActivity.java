package com.nightxstudio.tictactoegame;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class BuymeacoffeeActivity extends AppCompatActivity{

    Button chocolateDonate;
    Button coffeeDonate;
    Button burgerDonate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buymeacoffee);


        chocolateDonate = findViewById(R.id.chocolateDonate);
        coffeeDonate = findViewById(R.id.coffeeDonate);
        burgerDonate = findViewById(R.id.burgerDonate);

        chocolateDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuymeacoffeeActivity.this, Donate10.class);
                startActivity(intent);
            }
        });

        coffeeDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuymeacoffeeActivity.this, Donate30.class);
                startActivity(intent);
            }
        });

        burgerDonate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuymeacoffeeActivity.this, Donate50.class);
                startActivity(intent);
            }
        });


        //Change Action Bar color:
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable actionBackground = new ColorDrawable(Color.parseColor("#FBF73C"));
        assert actionBar != null;
        actionBar.setBackgroundDrawable(actionBackground);
        actionBar.setTitle(Html.fromHtml("<font color=\"black\">" + getString(R.string.app_name) + "</font>"));

        //Change Status Bar color:
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.black));
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

}