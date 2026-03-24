package com.example.listy;

public class Snack {
    private String name;
    private String desc;
    private int imgResId;


    public static final Snack[] snacks = {
            new Snack("Brownie","Ciasto z ciemnej czekolady i kakao.",R.drawable.brownie),
            new Snack("Sernik na zimno", "Zimne, kremowe ciasto z słodkiego twarogu z biszkoptowym spodem i owocową galaretką.", R.drawable.sernik),
            new Snack("Biszkopt z jabłkami", "Lekkie, puszyste ciasto na bazie kurzych białek z słodkimi jabłkami na wierzchu.", R.drawable.biszkopt)
    };

    public Snack(String name, String desc, int imgResId) {
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
