package com.example.pokemons;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Pokedex pokedex = new Pokedex();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            TextView pokemons = (TextView) findViewById(R.id.pokemonDisplay);
            pokemons.setMovementMethod(new ScrollingMovementMethod());
            return insets;
        });
    }
    public void onClickFindPokemons(View view){
        TextView pokemons = (TextView) findViewById(R.id.pokemonDisplay);
        Spinner baseType = (Spinner) findViewById(R.id.pokemonBaseType);
        Spinner addType = (Spinner) findViewById(R.id.pokemonAddType);
        List<String> pokemonList;
        pokemonList = pokedex.getPokemons(baseType.getSelectedItem().toString(),addType.getSelectedItem().toString());


        String pokemonsFormated = "";
        for (int i = 0; i < pokemonList.size(); i++) {
            pokemonsFormated+=(pokemonList.get(i)+"\n");
        }
        pokemons.setText(pokemonsFormated);
    }
}