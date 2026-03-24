package com.example.listy;

import android.app.Activity;

public class DrinkActivity extends Activity {
    public static final String EXTRA_DRINKID = "drinkId";
    int drinkId = (Integer)getIntent().getExtras().get(EXTRA_DRINKID);
    Drink drink = Drink.drinks[drinkId];
}
