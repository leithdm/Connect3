package com.darrenmleith.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dropIn(View view) {
        Log.i("button", "imagePressed");
        ImageView counter = (ImageView) view;
        counter.setTranslationY(-2000);
        counter.setImageResource(R.drawable.red);
        counter.animate().translationYBy(2000).setDuration(300);
    }
}
