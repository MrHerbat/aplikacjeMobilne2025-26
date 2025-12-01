package com.example.learningframelayout;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
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

    ImageView[] imageViewCards = new ImageView[5];
    public Bitmap bitmap;
    Bitmap[][] cards = new Bitmap[4][13];
    Bitmap[] playedCards = new Bitmap[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        spriteSheetToArray();
        getAllImageView();
        randomizeCards();
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
        for (int i = 0; i < 5; i++) {
            int id = getResources().getIdentifier(("card"+(i+1)), "id", getPackageName());
            imageViewCards[i] = findViewById(id);
        }
    }
    void randomizeCards(){
        int z = 0;
        Random rand = new Random();
        for (ImageView temp:
             imageViewCards) {
            int x = rand.nextInt(4), y = rand.nextInt(13);
            playedCards[z] = cards[x][y];
            temp.setImageBitmap(cards[x][y]);
            z++;
        }
    }
    public void moveCard(View view){
        int idTop = getResources().getIdentifier(("card"+5), "id", getPackageName());
        ImageView newTopImage = findViewById(view.getId()), oldTopImage = findViewById(idTop);
        Bitmap temp = ((BitmapDrawable)oldTopImage.getDrawable()).getBitmap();
        oldTopImage.setImageBitmap(((BitmapDrawable)newTopImage.getDrawable()).getBitmap());
        newTopImage.setImageBitmap(temp);
    }

    public void changeHand(View view){
        randomizeCards();
    }
}