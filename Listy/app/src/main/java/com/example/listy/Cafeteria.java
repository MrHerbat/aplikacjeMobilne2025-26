package com.example.listy;

public class Cafeteria {
    private String name;
    private String adres;
    private String desc;
    private int imgResId;
    public static final Cafeteria[] cafeterias = {
            new Cafeteria("Tociekawa","Kraków, Długa 37","Kawiarnia o swobodnej atmosferze oferująca szeroki wybór napojów zimnych i gorących oraz ciast i przekąsek.",R.drawable.tociekawka),
            new Cafeteria("Czyżyk","Kraków, Bolesława Orlińskiego","Fantastycka sąsiedzka kawiarnia na Avii, ze świetne śniadania, pyszną kawę i świeże wypieki.",R.drawable.czyzyk),
            new Cafeteria("COFEE GARDEN ","Kraków, Józefa 11","Kawiarnia z fajnym klimatem i przede wszystkim serwująca różne alternatywne kawy.",R.drawable.cofee_garden)
    };

    public Cafeteria(String name, String adres, String desc, int imgResId) {
        this.name = name;
        this.adres = adres;
        this.desc = desc;
        this.imgResId = imgResId;
    }

    public String getName() {
        return name;
    }

    public String getAdres() {
        return adres;
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
