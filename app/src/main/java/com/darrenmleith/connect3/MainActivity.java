package com.darrenmleith.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean gameOver = false;
    boolean redTurn = true;
    int red = 1;
    int yellow = 2;
    int[] gameboard = {0,0,0,0,0,0,0,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playAgain(View v) {
        resetBoard();
        for (int i = 0; i < 9; i++) {
            gameboard[i] = 0;
        }
    }

    void resetBoard() {
        setContentView(R.layout.activity_main);
    }

    public void dropIn(View view) {
        if (redTurn) {
            redTurn = false;
            ImageView counter = (ImageView) view;
            counter.setClickable(false);
            System.out.println(counter.getTag());
            int counterInt = Integer.parseInt((String) counter.getTag());
            gameboard[counterInt] = red;
            counter.setTranslationY(-2000);
            counter.setImageResource(R.drawable.red);
            counter.animate().translationYBy(2000).setDuration(300);
        } else {
            redTurn = true;
            ImageView counter = (ImageView) view;
            counter.setClickable(false);
            int counterInt = Integer.parseInt((String) counter.getTag());
            gameboard[counterInt] = yellow;
            counter.setTranslationY(-2000);
            counter.setImageResource(R.drawable.yellow);
            counter.animate().translationYBy(2000).setDuration(300);
        }
        testWhoHasWon();
    }

    public void testWhoHasWon() {
        TextView gameStatusText = findViewById(R.id.textGameStatus);

        //iterate over all ImageView objects to check their tag values
        if ((gameboard[0] == red && gameboard[1] == red && gameboard[2] == red) ||
                (gameboard[3] == red && gameboard[4] == red && gameboard[5] == red) ||
                (gameboard[6] == red && gameboard[7] == red && gameboard[8] == red) ||
                (gameboard[0] == red && gameboard[3] == red && gameboard[6] == red) ||
                (gameboard[1] == red && gameboard[4] == red && gameboard[7] == red) ||
                (gameboard[2] == red && gameboard[5] == red && gameboard[8] == red) ||
                (gameboard[0] == red && gameboard[4] == red && gameboard[8] == red) ||
                (gameboard[2] == red && gameboard[4] == red && gameboard[6] == red)) {
            gameStatusText.setText("Red has won, Play again?");
        } else if ((gameboard[0] == yellow && gameboard[1] == yellow && gameboard[2] == yellow) ||
                (gameboard[3] == yellow && gameboard[4] == yellow && gameboard[5] == yellow) ||
                (gameboard[6] == yellow && gameboard[7] == yellow && gameboard[8] == yellow) ||
                (gameboard[0] == yellow && gameboard[3] == yellow && gameboard[6] == yellow) ||
                (gameboard[1] == yellow && gameboard[4] == yellow && gameboard[7] == yellow) ||
                (gameboard[2] == yellow && gameboard[5] == yellow && gameboard[8] == yellow) ||
                (gameboard[0] == yellow && gameboard[4] == yellow && gameboard[8] == yellow) ||
                (gameboard[2] == yellow && gameboard[4] == yellow && gameboard[6] == yellow)) {
            gameStatusText.setText("Yellow has won, Play again?");
        }
    }
}
