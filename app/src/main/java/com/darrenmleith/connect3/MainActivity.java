package com.darrenmleith.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean redTurn = true;
    boolean gameStateActive = true;
    int red = 1;
    int yellow = 2;
    int[] gameState = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void dropIn(View view) {
        ImageView counter = (ImageView) view;
        int tappedCounter = Integer.parseInt(counter.getTag().toString());

        if (gameState[tappedCounter] == 0 && gameStateActive) {
            counter.setTranslationY(-2000);
            if (redTurn) {
                redTurn = false;
                gameState[tappedCounter] = red;
                counter.setImageResource(R.drawable.red);
            } else {
                redTurn = true;
                gameState[tappedCounter] = yellow;
                counter.setImageResource(R.drawable.yellow);
            }
            counter.animate().translationYBy(2000).setDuration(200);
            checkIfWon();
        }
    }


    void checkIfWon() {
        TextView gameStatusText = findViewById(R.id.textGameStatus);
        for (int[] winPositions : winningPositions) {
            if (gameState[winPositions[0]] == gameState[winPositions[1]] && gameState[winPositions[0]] == gameState[winPositions[2]] && gameState[winPositions[0]] != 0) {
                if (redTurn) {
                    gameStatusText.setText("Yellow Wins. Play again?");
                } else {
                    gameStatusText.setText("Red Wins. Play again?");
                }
                gameStateActive = false;
            }
        }
    }

    public void playAgain(View v) {
        setContentView(R.layout.activity_main);
        gameStateActive = true;
        redTurn = true;

        for (int i = 0; i < 9; i++) {
            gameState[i] = 0;
        }
    }
}
