package com.example.listy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SnackCategoryActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_category);
        ArrayAdapter<Snack> listAdapter = new ArrayAdapter<Snack>(
                this, android.R.layout.simple_list_item_1,
                Snack.snacks
        );
        ListView listView = (ListView) findViewById(R.id.list_snacks);
        listView.setAdapter(listAdapter);
        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> listView, View itemView, int position, long id) {
                        Intent intent = new Intent(SnackCategoryActivity.this, SnackActivity.class);
                        intent.putExtra(SnackActivity.EXTRA_SNACK_ID, (int)id);
                        startActivity(intent);
                    }
                };
        listView.setOnItemClickListener(itemClickListener);
    }
}

