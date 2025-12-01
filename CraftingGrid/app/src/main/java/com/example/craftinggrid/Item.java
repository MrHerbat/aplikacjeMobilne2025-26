package com.example.craftinggrid;

public class Item {
    public String checkCrafting(char[][] crafting){
        String toReturn = "", craftingString = null;
        for (char[] i:crafting) {
            for (char j:i) {
                craftingString+=j;
            }
            craftingString+=":";
        }


        return toReturn;
    }
}
