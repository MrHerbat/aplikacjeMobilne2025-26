package com.example.listy;

public class Drink {
    private String name;
    private String desc;
    private int imgResId;


    public static final Drink[] drinks = {
            new Drink("Latte","Czarne espresso z gorącym mlekiem i mleczną pianą",R.drawable.latte),
            new Drink("Cappuccino","Czarne espresso z dużą ilością spienionego mleka",R.drawable.cappuccino),
            new Drink("Espresso","Czarna kawa z świeżo zmielonych ziaren najwyższej jakości",R.drawable.espresso)
    };

    public Drink(String name, String desc, int imgResId) {
        this.name = name;
        this.desc = desc;
        this.imgResId = imgResId;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public int getImgResId() {
        return imgResId;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
