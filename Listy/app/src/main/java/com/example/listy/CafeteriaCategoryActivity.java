package com.example.listy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CafeteriaCategoryActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafeteria_category);
        ArrayAdapter<Cafeteria> listAdapter = new ArrayAdapter<Cafeteria>(
                this, android.R.layout.simple_list_item_1,
                Cafeteria.cafeterias
        );
        ListView listView = (ListView) findViewById(R.id.list_cafeterias);
        listView.setAdapter(listAdapter);
        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> listView, View itemView, int position, long id) {
                        Intent intent = new Intent(CafeteriaCategoryActivity.this, CafeteriaActivity.class);
                        intent.putExtra(CafeteriaActivity.EXTRA_CAFETERIA_ID, (int)id);
                        startActivity(intent);
                    }
                };
        listView.setOnItemClickListener(itemClickListener);
    }
}
