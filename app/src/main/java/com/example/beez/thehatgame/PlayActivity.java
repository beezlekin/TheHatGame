package com.example.beez.thehatgame;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlayActivity extends Activity implements View.OnClickListener {
    Button button_single, button_multi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        button_single = findViewById(R.id.button_single);
        button_single.setOnClickListener(this);
        button_multi = findViewById(R.id.button_multi);
        button_multi.setOnClickListener(this);
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.button_single:

                break;
            case R.id.button_multi:

                break;
        }
    }
}
