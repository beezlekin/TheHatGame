package com.example.beez.thehatgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlayActivity extends AppCompatActivity implements View.OnClickListener {
    Button single, multi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        single = findViewById(R.id.button4);
        single.setOnClickListener(this);
        multi = findViewById(R.id.button3);
        multi.setOnClickListener(this);
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.button3:

                break;
            case R.id.button4:

                break;
        }
    }
}
