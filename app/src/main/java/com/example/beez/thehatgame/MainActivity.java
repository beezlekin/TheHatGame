package com.example.beez.thehatgame;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends Activity implements View.OnClickListener {
    Button button_play, button_rules;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActionBar().hide();

        button_play = findViewById(R.id.button_play);
        button_play.setOnClickListener(this);
        button_rules = findViewById(R.id.button_rules);
        button_rules.setOnClickListener(this);

    }
    public void onClick(View v){
        Intent intent = new Intent();
        switch(v.getId()) {
            case R.id.button_play:
                startActivity(new Intent(MainActivity.this,PlayActivity.class));
                break;
            case R.id.button_rules:
                startActivity(new Intent(MainActivity.this,RulesActivity.class));
                break;
        }
    }
}
