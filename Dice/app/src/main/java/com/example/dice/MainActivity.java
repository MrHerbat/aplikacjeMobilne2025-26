package com.example.dice;

import android.os.Bundle;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private int rolledNumber, sum;
    private boolean rolling = false;
    private String rolledText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        try {
            if(savedInstanceState!=null){
                rolledNumber=savedInstanceState.getInt("rolledNumber");
                rolling=savedInstanceState.getBoolean("rolling");
                rolledText=savedInstanceState.getString("rolledText");
                sum=savedInstanceState.getInt("sum");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
//        TextView rolledNumbersTextView = (TextView)findViewById(R.id.rolledNumbers);
//        rolledNumbersTextView.setMovementMethod(new ScrollingMovementMethod());
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("rolledNumber",rolledNumber);
        savedInstanceState.putBoolean("rolling",rolling);
        savedInstanceState.putString("rolledText",rolledText);
        savedInstanceState.putInt("sum",sum);
    }
    @Override
    protected void onPause(){
        super.onPause();
    }
    @Override
    protected void onResume(){
        super.onResume();
        throwDice();

    }
    private void throwDice() {
        TextView sumView = (TextView) findViewById(R.id.diceRoll);

        sumView.setText("Rolling...");

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                rolledNumber = (int) (Math.random() * 6) + 1;
                rolledText = Integer.toString(rolledNumber);
                sumView.setText(rolledText);
            }
        },3000);

//        rolledText+=(rolledNumber+"\n");


//        rolledView.setText(rolledText);

    }
}