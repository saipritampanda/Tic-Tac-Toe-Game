package com.nightxstudio.tictactoegame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView buymeacoffee;

    boolean gameActive = true;
    int activePlayer = 0;
    //Player Notations:
    //0 - O (Capital Letter)
    //1 - X (Capital Letter)

    int  [] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    //State Notations:
    //0 - O (Capital Letter)
    //1 - X (Capital Letter)
    //2 - Null (Empty)

    int [][] winPositions = {{0,1,2} , {3,4,5} , {6,7,8},
            {0,3,6} , {1,4,7} , {2,5,8},
            {0,4,8} , {2,4,6}};

    public void playerTap (View view){

        ImageView retry = findViewById(R.id.retry);

        if(gameActive){
            retry.setVisibility(View.VISIBLE);
        }

        MediaPlayer tap = MediaPlayer.create(this , R.raw.sample);
        MediaPlayer gameOver = MediaPlayer.create(this , R.raw.gameover);

        TextView playerTurn = findViewById(R.id.playerTurnText);
        try {
            playerTurn.setText("Tap To Play!");
        }
        catch(Exception e) {
            Toast.makeText(this , e.getMessage() , Toast.LENGTH_SHORT).show();
        }

        ImageView img = (ImageView) view;
        int tappedImg = Integer.parseInt(img.getTag().toString());

        if(gameState[tappedImg] == 2 && gameActive){
            gameState[tappedImg] = activePlayer;

            if(activePlayer == 0){
                activePlayer = 1;
                img.setImageResource(R.drawable.o);
                playerTurn.setText("X's turn - Tap to play!");
                tap.start();
            }
            else{
                activePlayer = 0;
                img.setImageResource(R.drawable.x);
                playerTurn.setText("O's turn - Tap to play!");
                tap.start();
            }
        }


        //DIALOUGE BOX IF O WINS
        AlertDialog.Builder resO = new AlertDialog.Builder(this);
        resO.setIcon(R.drawable.tic_tac_toe_iconc);
        resO.setTitle("Game Over");
        resO.setMessage("Congratulations! O Has Won");

        resO.setPositiveButton("RETRY", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                reset(view);
            }
        });

        resO.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        final AlertDialog resultDialouge0 = resO.create();

        //DIALOUGE BOX IF X WINS
        AlertDialog.Builder resX = new AlertDialog.Builder(this);
        resX.setIcon(R.drawable.tic_tac_toe_iconc);
        resX.setTitle("Game Over");
        resX.setMessage("Congratulations! X Has Won");

        resX.setPositiveButton("RETRY", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                reset(view);
            }
        });

        resX.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        final AlertDialog resultDialougeX = resX.create();

        //DIALOUGE BOX IF DRAWS
        AlertDialog.Builder draw = new AlertDialog.Builder(this);
        draw.setIcon(R.drawable.tic_tac_toe_iconc);
        draw.setTitle("Game Over");
        draw.setMessage("Congratulations! X Has Won");

        draw.setPositiveButton("RETRY", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                reset(view);
            }
        });

        draw.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        final AlertDialog drawDialouge = draw.create();


        //Check if any wining position is achieved or not & Winner announcement:
        for(int[] winpositions: winPositions){
            if(gameState[winpositions[0]] == gameState[winpositions[1]] &&
                    gameState[winpositions[1]] == gameState[winpositions[2]] &&
                    gameState[winpositions[0]] != 2)
            {
                if(gameState[winpositions[0]] ==  0){
                    gameOver.start();
                    gameActive = false;
                    retry.setVisibility(View.GONE);
                    resultDialouge0.show();
                    playerTurn.setText("Game Over - Click retry to play again!");

                }
                else{
                    gameOver.start();
                    gameActive = false;
                    retry.setVisibility(View.GONE);
                    resultDialougeX.show();
                    playerTurn.setText("Game Over - Click retry to play again!");

                }
            }
            /*
            else{
                gameOver.start();
                gameActive = false;
                drawDialouge.show();
                playerTurn.setText("It's Draw - Click retry to play again!");
            }
             */
        }

    }

    public void reset(View view){

        TextView playerTurn = findViewById(R.id.playerTurnText);
        try {
            playerTurn.setText("Tap To Play!");
        }
        catch(Exception e) {
            Toast.makeText(this , e.getMessage() , Toast.LENGTH_SHORT).show();
        }

        gameActive = true;
        activePlayer = 0;
        for(int i = 0 ; i < 9 ; i++) {
            gameState[i] = 2;
        }
        playerTurn.setText("Tap to play!");
        ((ImageView) findViewById(R.id.image0)).setImageResource(0);
        ((ImageView) findViewById(R.id.image1)).setImageResource(0);
        ((ImageView) findViewById(R.id.image2)).setImageResource(0);
        ((ImageView) findViewById(R.id.image3)).setImageResource(0);
        ((ImageView) findViewById(R.id.image4)).setImageResource(0);
        ((ImageView) findViewById(R.id.image5)).setImageResource(0);
        ((ImageView) findViewById(R.id.image6)).setImageResource(0);
        ((ImageView) findViewById(R.id.image7)).setImageResource(0);
        ((ImageView) findViewById(R.id.image8)).setImageResource(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buymeacoffee = findViewById(R.id.buymeacoffee);

        buymeacoffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BuymeacoffeeActivity.class);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu , menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if (item.getItemId() == R.id.about) {
            Intent ConnectWithUsIntent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(ConnectWithUsIntent);
        }
        return super.onOptionsItemSelected(item);
    }


}