package com.example.firstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class DoradcaPiwny extends AppCompatActivity {
    private BeerExpert expert = new BeerExpert();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_find_beer);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void onClickFindBeer(View view){
        TextView brands = (TextView) findViewById(R.id.brands);
        Spinner color = (Spinner) findViewById(R.id.beerColor);
        List<String> brandsList = expert.getBrands(color.getSelectedItem().toString());
        String brandFormated = "";
        for (int i = 0; i < brandsList.size(); i++) {
            brandFormated+=(brandsList.get(i)+"\n");
        }
        brands.setText(brandFormated);
        //StringBuilder brandsFormatted = new StringBuilder();
        //for (String brand : brandsList) {
        //  brandsFormatted.append(brand).append("\n");
        //}
        //brands.setText(brandsFormatted);
    }
}