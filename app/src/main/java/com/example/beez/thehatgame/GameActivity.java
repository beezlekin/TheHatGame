package com.example.beez.thehatgame;

import android.app.Activity;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;

import java.util.Random;
import java.util.Timer;

public class GameActivity extends Activity implements View.OnClickListener {
    Button button;
    CountDownTimer timer;
    Random ran;
    String names[];
    String b_opt[];
    int score [];
    int nlen, time, points, round;
    boolean gametype, team; //maybe
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Bundle extras = getIntent().getExtras();

        time = 120000;
        points = 0;
        round = 1;
        score = new int [2];
        score[0] =0;
        score[1]=0;
        names = extras.getStringArray("names");
        b_opt = new String[]{"Team A Go", "Team B Go", "Next Player", "Time Up", "Round "+round, "temp"};
        gametype = extras.getBoolean("gametype");
        team = false;
        ran = new Random();

        nlen = names.length-1;


        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        int temp = ran.nextInt(2);
        if(temp==1){
            team=true;
        }
        else{
            team=false;
        }

    }

    public void startTimer() {
        timer = new CountDownTimer(time, 10) {
            public void onTick(long tick) {
                time = (int) (long) tick;
            }

            public void onFinish() {
                if (!team) {
                    score[0] += points;
                } else if (team) {
                    score[1] += points;
                }
                button.setText(b_opt[3]);
                points = 0;
            }
        }.start();

    }
    public void pickName() {
        /*System.out.println(nlen);
        if (nlen==-1) {
            round++;
            //System.out.println("WAAAAAAAAAA");
            b_opt[4]="Round "+round;
            button.setText(b_opt[4]);
            *//*if(round==4){
                intent.putExtra("scores",score);
                intent.setClass(getApplicationContext(),ScoreActivity.class);
                startActivity(intent);
            }
            else{
                button.setText(b_opt[4]);
            }*//*
        }
        else{*/
            if(nlen==0) {
                b_opt[5]=names[0];
            }
            else{
                int num = ran.nextInt(nlen);
                b_opt[5] = names[num];
                names[num] = names[nlen];
                names[nlen] = b_opt[5];
            }
            nlen--;
            button.setText(b_opt[5]);
        //}
    }
    public void onClick(View v){
        //System.out.println("better fucking come out somewhere");
        switch (v.getId()){
            case R.id.button:
                String temp = button.getText().toString();
                if (temp.equals(b_opt[0])||temp.equals(b_opt[1])) {
                    pickName();
                    //button.setText(b_opt[5]);
                    startTimer();
                }
                else if (temp.equals(b_opt[2])) {
                    pickName();

                }
                else if (temp.equals(b_opt[3])) {
                    time=120000;
                    if (!team) {
                        button.setText(b_opt[1]);
                        team = true;
                    }
                    else if(team){
                        button.setText(b_opt[0]);
                        team=false;
                        }

                }
                else if (temp.equals(b_opt[4])) {
                    nlen=names.length-1;
                    System.out.println("Round");
                    if (team){
                        button.setText(b_opt[1]);
                        team=true;
                        System.out.println("team B");
                    }
                    else if (!team){
                        button.setText(b_opt[0]);
                        team=false;
                        System.out.println("team A");
                    }
                }
                else if (temp.equals(b_opt[5])) {
                    points++;
                    //System.out.println("------------------POINTS: "+points+"------------------");
                    //System.out.println("------------------Score A: "+score[0]+"------------------");
                    //System.out.println("------------------Score B: "+score[1]+"------------------");

                    if(nlen<0){
                        round++;
                        if (round==4){
                            if (!team) {
                                score[0] += points;
                            } else if (team) {
                                score[1] += points;
                            }
                            Intent intent= new Intent(getApplicationContext(),ScoreActivity.class);
                            intent.putExtra("scoreA",score[0]);
                            intent.putExtra("scoreB",score[1]);
                            //System.out.println("end------------------Score A: "+score[0]+"------------------");
                            //System.out.println("------------------Score B: "+score[1]+"------------------");
                            startActivity(intent);
                        }
                        else {
                            if (round==3){
                                b_opt[4]="Round 3";
                            }
                            else{
                                b_opt[4]="Round 2";
                            }
                        button.setText(b_opt[4]);
                        System.out.println("Go to Next Round");
                        }
                    }
                    else {
                        button.setText(b_opt[2]);
                    }
                }
                break;
        }
    }
}
