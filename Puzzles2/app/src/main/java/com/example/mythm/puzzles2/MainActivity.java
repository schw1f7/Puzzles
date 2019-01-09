package com.example.mythm.puzzles2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startFarmer(View view){
        Intent intent = new Intent(this, FWGC_intro.class);
        startActivity(intent);
    }

    public void startPuzzle(View view){
        Intent intent = new Intent(this, Puzzle_intro.class);
        startActivity(intent);
    }


}
