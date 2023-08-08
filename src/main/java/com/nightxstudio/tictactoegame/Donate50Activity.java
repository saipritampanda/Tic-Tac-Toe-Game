package com.nightxstudio.tictactoegame;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;

public class Donate50Activity extends AppCompatActivity {

    Button pay50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donate50);

        pay50 = findViewById(R.id.pay50);

        pay50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                decodeAndSearchQRCode();

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

    private void decodeAndSearchQRCode() {
        // Load the QR code image from drawable resource
        Bitmap qrCodeBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.donate_rs50_qrcode_image);

        // Convert the Bitmap to a binary bitmap for QR code scanning
        RGBLuminanceSource source = new RGBLuminanceSource(qrCodeBitmap.getWidth(), qrCodeBitmap.getHeight(), getRGBIntArray(qrCodeBitmap));
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(source));

        // Initialize the QR code reader
        Reader reader = new MultiFormatReader(); // Reader (interface) is imported from com.zxing instead of java.io

        try {
            // Decode the QR code
            Result result = reader.decode(binaryBitmap);
            String extractedText = result.getText();

            // Search the extracted text on Google
            openGoogleSearch(extractedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openGoogleSearch(String query) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(query));
        startActivity(intent);
    }

    private int[] getRGBIntArray(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] pixels = new int[width * height];
        bitmap.getPixels(pixels, 0, width, 0, 0, width, height);
        return pixels;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getApplicationContext() , BuymeacoffeeActivity.class));
    }
}