package com.example.listy;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CafeteriaActivity extends Activity {
    public static final String EXTRA_CAFETERIA_ID = "cafeteriaId";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafeteria);

        int cafeteriaId = (Integer)getIntent().getExtras().get(EXTRA_CAFETERIA_ID);
        Cafeteria cafeteria = Cafeteria.cafeterias[cafeteriaId];

        TextView name = findViewById(R.id.name);
        name.setText(cafeteria.getName());

        TextView adres = findViewById(R.id.adres);
        adres.setText(cafeteria.getAdres());

        TextView desc = findViewById(R.id.description);
        desc.setText(cafeteria.getDesc());

        ImageView photo = findViewById(R.id.photo);
        photo.setImageResource(cafeteria.getImgResId());
        photo.setContentDescription(cafeteria.getName());
    }
}
