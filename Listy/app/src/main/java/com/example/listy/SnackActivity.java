package com.example.listy;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SnackActivity extends Activity {

    public static final String EXTRA_SNACK_ID = "snackId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack);

        int snackId = (Integer)getIntent().getExtras().get(EXTRA_SNACK_ID);
        Snack snack = Snack.snacks[snackId];

        TextView name = findViewById(R.id.name);
        name.setText(snack.getName());

        TextView desc = findViewById(R.id.description);
        desc.setText(snack.getDesc());

        ImageView photo = findViewById(R.id.photo);
        photo.setImageResource(snack.getImgResId());
        photo.setContentDescription(snack.getName());
    }
}
