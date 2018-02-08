package com.example.beez.thehatgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.EditText;

public class PlayActivity extends Activity implements View.OnClickListener,SeekBar.OnSeekBarChangeListener {
    Button button_single, button_multi;
    SeekBar seek_play,seek_input;
    TextView t_play,t_input;
    Intent intent;
    EditText pcode;
    String extra_pcode;
    int extra_play,extra_input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        extra_play = 4;
        extra_input = 3;
        extra_pcode = null;

        pcode = findViewById(R.id.pcode);

        t_play = findViewById(R.id.t_play);
        t_input = findViewById(R.id.t_input);

        button_single = findViewById(R.id.button_single);
        button_single.setOnClickListener(this);
        button_multi = findViewById(R.id.button_multi);
        button_multi.setOnClickListener(this);

        seek_play = findViewById(R.id.seek_play);
        seek_play.setOnSeekBarChangeListener(this);
        seek_input =findViewById(R.id.seek_input);
        seek_input.setOnSeekBarChangeListener(this);

        intent = new Intent();

    }

    public void onProgressChanged(SeekBar seekbar,int progress,boolean fromUser){
        switch (seekbar.getId()){
            case R.id.seek_play:
                t_play.setText(""+(progress+4));
                extra_play=progress+4;
                break;
            case R.id.seek_input:
                t_input.setText(""+(progress+3));
                extra_input=progress+3;
                break;
        }
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.button_single:
                intent.putExtra("play_num",extra_play);
                intent.putExtra("input_num",extra_input);
                intent.putExtra("gametype",false);
                intent.setClass(getApplicationContext(),InputSActivity.class);
                startActivity(intent);
                //startActivity(new Intent(PlayActivity.this,InputActivity.class));
                break;
            case R.id.button_multi:
                String code = pcode.getText().toString();
                if(!code.equals("Enter a passcode")&&code.length()>=4){
                    intent.putExtra("pcode",code);
                    //intent.putExtra("gametype",true); //possibly only intent after lobby screen, no idea how long these last for
                    //intent.setClass(getApplicationContext(),LobbyActivity.class);
                    //startActivity(intent);
                }
                else{
                    Animation shake = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.shake);
                    pcode.startAnimation(shake);
                }
                break;
            case R.id.pcode:
                String s = pcode.getText().toString();
                if (s.equals("Enter a passcode")){
                    pcode.setText("");
                }
                break;
        }
    }
    public void onStopTrackingTouch(SeekBar seekbar){

    }
    public void onStartTrackingTouch(SeekBar seekbar){

    }
}
