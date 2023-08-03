package com.nightxstudio.tictactoegame;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.Window;
import android.view.WindowManager;

public class Donate50 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate50);


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
}