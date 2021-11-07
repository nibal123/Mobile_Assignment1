package edu.birzeit.assignemnt1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class StopWatchActivity extends AppCompatActivity {

    private int seconds = 0;
    private boolean running = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);
        checkInstance(savedInstanceState);
        runTimer();
    }

    private void checkInstance(Bundle savedInstanceState) {
        if(savedInstanceState != null){
            seconds = savedInstanceState.getInt("SECONDS");
            running = savedInstanceState.getBoolean("RUNNING");
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("SECONDS", seconds);
        outState.putBoolean("RUNNING", running);


    }

    private void runTimer(){
        final TextView txtTime = findViewById(R.id.txtTime);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600) / 60;
                int secs = seconds%60;
                String time = hours +" : " + minutes + " : " + secs;
                txtTime.setText(time);
                if(running){
                    seconds++;
                }
                handler.postDelayed(this, 1000);

            }
        });
    }


    public void btnStartOnClick(View view) {
        running = true;
    }

    public void btnStopOnClick(View view) {
        running = false;
    }

    public void btnResetOnClick(View view) {
        running = false;
        seconds = 0;
    }


}