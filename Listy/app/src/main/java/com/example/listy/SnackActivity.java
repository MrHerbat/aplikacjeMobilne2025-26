package com.example.listy;

import android.app.Activity;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SnackActivity extends Activity {

    public static final String EXTRA_SNACK_ID = "snackId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int snackId = (Integer)getIntent().getExtras().get(EXTRA_SNACK_ID);
        try{
            SQLiteOpenHelper kawiarniaDatabaseHelper = new KawiarniaDatabaseHelper(this);
            SQLiteDatabase db = kawiarniaDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query("SNACK",new String[]{"NAME","DESCRIPTION","IMAGE_RESOURCE_ID"},
                    "_id=?",new String[] {Integer.toString(snackId)},
                    null,null,null);
            if(cursor.moveToFirst()){
                String nameText = cursor.getString(0),
                        description = cursor.getString(1);
                int photoId = cursor.getInt(2);

                setContentView(R.layout.activity_snack);

                TextView name = findViewById(R.id.name);
                name.setText(nameText);

                TextView desc = findViewById(R.id.description);
                desc.setText(description);

                ImageView photo = findViewById(R.id.photo);
                photo.setImageResource(photoId);
                photo.setContentDescription(nameText);
            }
            cursor.close();
            db.close();
        }catch(SQLException e){
            Toast toast = Toast.makeText(this, e.toString(),
                    Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
