package com.example.listy;

import android.app.Activity;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DrinkActivity extends Activity {
    public static final String EXTRA_DRINK_ID = "drinkId";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int drinkId = (Integer)getIntent().getExtras().get(EXTRA_DRINK_ID);
        try{
            SQLiteOpenHelper kawiarniaDatabaseHelper = new KawiarniaDatabaseHelper(this);
            SQLiteDatabase db = kawiarniaDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query("DRINK",new String[]{"NAME","DESC","IMAGE_RESOURCE_ID"},
                    "_id=?",new String[] {Integer.toString(drinkId)},
                    null,null,null);
            if(cursor.moveToFirst()){
                String nameText = cursor.getString(0),
                        description = cursor.getString(1);
                int photoId = cursor.getInt(2);

                setContentView(R.layout.activity_drink);

                TextView name = findViewById(R.id.name);
                name.setText(nameText);

                TextView desc = findViewById(R.id.description);
                desc.setText(description);

                ImageView photo = findViewById(R.id.photo);
                photo.setImageResource(photoId);
                photo.setContentDescription(nameText);
            }
            db.close();
            cursor.close();

        }catch(SQLException e){
            Toast toast = Toast.makeText(this, "baza danych niedostępna", Toast.LENGTH_SHORT);

            toast.show();
        }



    }
}
