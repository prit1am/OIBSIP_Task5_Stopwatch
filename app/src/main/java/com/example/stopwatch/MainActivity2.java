package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {
    private  int sec=0;
    private boolean running;
    private boolean wasRunning;




    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        if(savedInstanceState !=null) {
            sec = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        runTimer();

    }


    @Override
    protected void onPause() {
        super.onPause();
        wasRunning=running;
        running=false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(wasRunning){
            running=true;
        }
    }
    public void onClickStart(View v){
        running=true;
        Toast.makeText(this, "START", Toast.LENGTH_SHORT).show();

    }
    public void onClickStop(View v){
        Toast.makeText(this, "STOP", Toast.LENGTH_SHORT).show();
        running=false;
    }
    public void onClickStopReset(View v){
        Toast.makeText(this, "RESET", Toast.LENGTH_SHORT).show();
        running=false;
        sec=0;
    }
    public  void runTimer(){
        final TextView textView= findViewById(R.id.textView2);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours= sec/3600;
                int min= (sec%3600)/60;
                int second= sec%60;
                String time= String.format(Locale.getDefault(),
                        "%d:%02d:%02d",hours,min,second);
                textView.setText(time);
                if(running){
                    sec++;
                }
                handler.postDelayed(this,1000);
            }

        });
    }



}