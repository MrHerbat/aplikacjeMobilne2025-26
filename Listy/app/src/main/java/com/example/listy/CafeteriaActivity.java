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

import org.w3c.dom.Text;

public class CafeteriaActivity extends Activity {
    public static final String EXTRA_CAFETERIA_ID = "cafeteriaId";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafeteria);

        int cafeteriaId = (Integer)getIntent().getExtras().get(EXTRA_CAFETERIA_ID);
        try{
            SQLiteOpenHelper kawiarniaDatabaseHelper = new KawiarniaDatabaseHelper(this);
            SQLiteDatabase db = kawiarniaDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query("LOCATION",new String[]{"NAME","ADDRESS","DESCRIPTION","IMAGE_RESOURCE_ID"},
                    "_id=?",new String[] {Integer.toString(cafeteriaId)},
                    null,null,null);
            if(cursor.moveToFirst()){
                String nameText = cursor.getString(0),
                        addressText = cursor.getString(1),
                        description = cursor.getString(2);
                int photoId = cursor.getInt(3);

                setContentView(R.layout.activity_cafeteria);

                TextView name = findViewById(R.id.name);
                name.setText(nameText);

                TextView address = findViewById(R.id.address);
                address.setText(addressText);

                TextView desc = findViewById(R.id.description);
                desc.setText(description);

                ImageView photo = findViewById(R.id.photo);
                photo.setImageResource(photoId);
                photo.setContentDescription(nameText);
            }
            cursor.close();
            db.close();
        }catch(SQLException e){
            Toast toast = Toast.makeText(this, "Problem połączenia z bazą danych",
                    Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
