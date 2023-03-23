package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread thread = new Thread(){
            public void run(){

                try{
                    sleep(5000);
                }
                catch (Exception e){
                    e.printStackTrace();
                    finish();
                }
                finally {
                    Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(intent);

                }
            }
        };thread.start();
    }
}