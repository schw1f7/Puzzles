package com.example.mythm.puzzles2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FWGC_intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fwgc_intro);
    }

    public void begin(View view){
        Intent intent = new Intent(this, Farmer_problem.class);
        startActivity(intent);
    }
}
