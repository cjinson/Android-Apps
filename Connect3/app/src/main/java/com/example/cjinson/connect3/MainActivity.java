package com.example.cjinson.connect3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int player = 0;
    int[] gameState={2,2,2,2,2,2,2,2,2};
    int [][] winningPos={{0,1,2}, {3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean gameActive=true;
    int score=0;
    boolean draw=false;

    public void drop(View view) {
        ImageView counter = (ImageView) view;
        int tappedPos = Integer.parseInt(counter.getTag().toString());

        if (gameState[tappedPos] == 2 && gameActive) {
            counter.setTranslationY(-1500);
            gameState[tappedPos] = player;
            if (player == 0) {
                player = 1;
                counter.setImageResource(R.drawable.yellow);


            } else {

                player = 0;
                counter.setImageResource(R.drawable.red);
            }

            counter.animate().translationYBy(1500).rotation(1800).setDuration(300);

            for (int[] winningPos : winningPos) {

                if ((gameState[winningPos[0]] == gameState[winningPos[1]]) && (gameState[winningPos[1]] == gameState[winningPos[2]]) && (gameState[winningPos[0]] != 2)) {
                    String winner = "";
                    gameActive = false;
                    if (player == 1) {
                        winner = "Yellow";

                    } else {
                        winner = "Red";
                    }
                    Toast.makeText(this, winner + " has won!", Toast.LENGTH_LONG).show();
                    Button button = (Button) findViewById(R.id.resetBtn);
                    button.setVisibility(View.VISIBLE);

                    Toast.makeText(this, winner + " has won!", Toast.LENGTH_LONG).show();


                }


            }

                if (gameState[tappedPos] != 2) {
                    score++;
                }
                if (score == 9) {
                    Toast.makeText(this, "The match is a draw!", Toast.LENGTH_SHORT).show();
                    Button button = (Button) findViewById(R.id.resetBtn);
                    button.setVisibility(View.VISIBLE);
                }



        }
    }
    public void resetGame(View view){


        Button button= (Button) findViewById(R.id.resetBtn);
        button.setVisibility(View.INVISIBLE);

        GridLayout gridLayout= (GridLayout) findViewById(R.id.gridLayout);
        for(int i=0; i<gridLayout.getChildCount(); i++)
        {
            ImageView counter = (ImageView) gridLayout.getChildAt(i);
            counter.setImageDrawable(null);
        }
        for (int i=0;i<gameState.length;i++){
            gameState[i]=2;
        }
        gameActive=true;
        player=0;
        score=0;

    }
        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }
    }

