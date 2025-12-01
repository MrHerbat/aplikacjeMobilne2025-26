package com.example.learningframelayout;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView[] imageViewCards = new ImageView[4];
    public Bitmap bitmap;
    Bitmap[][] cards = new Bitmap[4][13];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        spriteSheetToArray();
        getAllImageView();
        //randomizeCards();
    }

    void spriteSheetToArray(){
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.playing_cards);
        cards[0][0] = Bitmap.createBitmap(bitmap,0,0,741,1157);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                cards[i][j] = Bitmap.createBitmap(bitmap,j*741,i*1157,741,1157);
            }
        }
    }
    void getAllImageView(){
        for (int i = 1; i <= 5; i++) {
            int id = getResources().getIdentifier(("card"+i), "id", getPackageName());
            imageViewCards[(i-1)] = findViewById(id);
        }
    }
    void randomizeCards(){
        Random rand = new Random();
        for (ImageView temp:
             imageViewCards) {
            temp.setImageBitmap(cards[rand.nextInt(4)][rand.nextInt(13)]);
        }
    }
}