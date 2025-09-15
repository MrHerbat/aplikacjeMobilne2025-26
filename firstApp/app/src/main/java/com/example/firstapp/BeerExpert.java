package com.example.firstapp;

import java.util.ArrayList;
import java.util.List;

public class BeerExpert
{
    List<String> getBrands(String beerColor){
        List<String> brands = new ArrayList<String>();
        if (beerColor.equals("bursztynowe")){
            brands.add("Jack Amber");
            brands.add("Red Moose");
        } else {
            brands.add("Jail Pale Ale");
            brands.add("Gout Stout");
        }
        return brands;
    }
}
