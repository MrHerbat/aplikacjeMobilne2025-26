package com.example.listy;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkActivity extends Activity {
    public static final String EXTRA_DRINK_ID = "drinkId";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        int drinkId = (Integer)getIntent().getExtras().get(EXTRA_DRINK_ID);
        Drink drink = Drink.drinks[drinkId];

        TextView name = findViewById(R.id.name);
        name.setText(drink.getName());

        TextView desc = findViewById(R.id.description);
        desc.setText(drink.getDesc());

        ImageView photo = findViewById(R.id.photo);
        photo.setImageResource(drink.getImgResId());
        photo.setContentDescription(drink.getName());
    }
}
