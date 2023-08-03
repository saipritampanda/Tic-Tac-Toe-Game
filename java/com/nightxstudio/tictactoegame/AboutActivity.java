package com.nightxstudio.tictactoegame;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

public class AboutActivity extends AppCompatActivity {

    ImageButton instagramButton;
    ImageButton twitterButton;
    ImageButton linkedinButton;
    ImageButton githubButton;
    ImageView buymeacoffee;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


        instagramButton = findViewById(R.id.instagramButton);
        twitterButton = findViewById(R.id.twitterButton);
        linkedinButton = findViewById(R.id.linkedinButton);
        githubButton = findViewById(R.id.githubButton);
        buymeacoffee = findViewById(R.id.buymeacoffee);

        instagramButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("https://www.instagram.com/saipritampanda/");
            }
        });

        twitterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("https://twitter.com/SaiPritamPanda1");
            }
        });

        linkedinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("https://www.linkedin.com/in/sai-pritam-panda-4bb115231/");
            }
        });

        githubButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("https://github.com/saipritampanda");
            }
        });

        buymeacoffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutActivity.this, BuymeacoffeeActivity.class);
                startActivity(intent);
            }
        });


        //Change Action Bar color:
        ActionBar actionBar;
        actionBar = getSupportActionBar();
        ColorDrawable actionBackground = new ColorDrawable(Color.parseColor("#096ced"));
        assert actionBar != null;
        actionBar.setBackgroundDrawable(actionBackground);

        //Change Status Bar color:
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimary));
    }

    public void goToUrl(String url) {
        Uri uri = Uri.parse(url);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}