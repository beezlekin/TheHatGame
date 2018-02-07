package com.example.beez.thehatgame;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends Activity implements View.OnClickListener {
    Button play, rules;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = findViewById(R.id.button);
        play.setOnClickListener(this);
        rules = findViewById(R.id.button2);
        rules.setOnClickListener(this);

    }
    public void onClick(View v){
        switch(v.getId()){
            case R.id.button:
                Intent intent_play = new Intent(MainActivity.this,PlayActivity.class);
                startActivity(intent_play);
                break;
            case R.id.button2:
                Intent intent_rules = new Intent(MainActivity.this,RulesActivity.class);
                startActivity(intent_rules);
                break;
        }
    }
}
