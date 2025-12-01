package com.example.craftinggrid;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Item item = new Item();
    private String pickedItem = " ";
    private char[][] craftingGrid = new char[3][3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setClickedButtonItem(View view) {
        if(!pickedItem.equals(" ")){
            Button clickedButton = (Button) findViewById(view.getId());
            System.out.println(view.getId());
            if(pickedItem.equals(clickedButton.getText().toString())){
                clickedButton.setText(" ");
            }else {
                clickedButton.setText(pickedItem);
            }
        }
    }

    public void pickItem(View view) {
        Button clickedButton = (Button) findViewById(view.getId());
        pickedItem=clickedButton.getText().toString();
    }
}