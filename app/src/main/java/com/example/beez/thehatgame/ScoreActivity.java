package com.example.beez.thehatgame;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends Activity implements View.OnClickListener {
TextView t_score;
int score[];
Button again, quit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().hide();
        setContentView(R.layout.activity_score);
        again = findViewById(R.id.button_again);
        again.setOnClickListener(this);
        quit = findViewById(R.id.button_quit);
        quit.setOnClickListener(this);

        score = new int[2];
        t_score = findViewById(R.id.text_score);
        Bundle extras = getIntent().getExtras();
        score[0] = extras.getInt("scoreA");
        score[1] = extras.getInt("scoreB");
        if(score[0]>score[1]){
            t_score.setText("Team A beat Team B with a score of "+score[0]+" to "+score[1]);
        }
        else if(score[1]>score[0]){
            t_score.setText("Team B beat Team A with a score of "+score[1]+" to "+score[0]);
        }
        else{
            t_score.setText("Tied with a score of "+score[0]+" to "+score[1]);
        }
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.button_again:
                Intent intent = new Intent(getApplicationContext(),PlayActivity.class);
                startActivity(intent);
                break;
            case R.id.button_quit:
                finish();
                //System.exit(0);
                break;
        }
    }
}
