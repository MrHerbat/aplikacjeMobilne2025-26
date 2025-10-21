package com.example.stoper;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private boolean running = false;
    private int seconds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runTimer();
    }

    public void onClickStart(View view) {
        running=true;

    }

    private void runTimer() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                final TextView timeView = (TextView)findViewById(R.id.time_view);
                int hours = seconds/216000, minutes = seconds/3600, secs = (seconds%3600)/60, mil=seconds%60;
                String time = String.format("%d:%02d:%02d:%02d",
                        hours,minutes,secs,mil);
                timeView.setText(time);
                if (running){
                    seconds++;
                }
                handler.postDelayed(this,10);
            }
        });
    }

    public void onClickStop(View view) {
        running = false;
    }

    public void onClickReset(View view) {
        running = false;
        seconds=0;
    }
}