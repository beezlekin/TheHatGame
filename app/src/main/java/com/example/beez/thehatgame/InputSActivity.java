package com.example.beez.thehatgame;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InputSActivity extends Activity implements View.OnClickListener {
    String names[];
    int players,inputs,count;
    Button selection,next_play,finish;
    EditText name_in;
    TextView title,playnum;
    boolean gametype; //false = single player, true = multiplayer
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        getActionBar().setDisplayHomeAsUpEnabled(false);
        getActionBar().setHomeButtonEnabled(false);
        getActionBar().hide();


        gametype = getIntent().getBooleanExtra("gametype",false);


        players = getIntent().getIntExtra("num_play",4);
        inputs = getIntent().getIntExtra("num_input",3);
        count = 1;

        names = new String[(players*inputs)];

        selection = findViewById(R.id.button_select);
        selection.setOnClickListener(this);
        next_play = findViewById(R.id.button_next);
        next_play.setOnClickListener(this);
        finish = findViewById(R.id.button_finish);
        finish.setOnClickListener(this);

        name_in = findViewById(R.id.t_names);
        title = findViewById(R.id.text_inTitle);
        playnum = findViewById(R.id.text_playnum);

        if(gametype){
            title.setText("Multiplayer");
            finish.setVisibility(View.VISIBLE);
            playnum.setVisibility(View.GONE);
        }
        else{
            title.setText("Single Player");
            finish.setVisibility(View.GONE);
        }

    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.button_select:
                String s = name_in.getText().toString();
                int temp = count;
                if (!s.equals("Name")&&s.length()>1) {
                    name_in.setText("");
                    if (gametype){
                        //send name to server
                    }
                    else {
                        names[count-1] = s;
                    }
                    count++;
                    if (count==(players*inputs+1)) {
                        name_in.setText("Name");
                        Intent intent = new Intent(getApplicationContext(),GameActivity.class);
                        intent.putExtra("names",names);
                        startActivity(intent);
                        finish();
                        //intent some shit and stuff
                    }
                    else if (temp%inputs==0&&!gametype){
                        next_play.setVisibility(View.VISIBLE);
                        selection.setVisibility(View.GONE);
                        name_in.setVisibility(View.GONE);
                    }
                }
                else{
                        Animation shake = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.shake);
                        name_in.startAnimation(shake);
                    }

                if(gametype&&count==8){
                    //automatically end their turn
                }

                break;
            case R.id.button_next:
                next_play.setVisibility(View.GONE);
                selection.setVisibility(View.VISIBLE);
                name_in.setVisibility(View.VISIBLE);
                name_in.setText("Name");
                int a = count/inputs +1;
                playnum.setText("Player "+a);

                break;
            case R.id.t_names:
                String st = name_in.getText().toString();
                if (st.equals("Name")||st.length()<2){
                    name_in.setText("");
                }
            case R.id.button_finish:
                //end multiplayer phase thing
                break;
        }
    }
}
