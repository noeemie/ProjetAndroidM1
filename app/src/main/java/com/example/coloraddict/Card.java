package com.example.coloraddict;

import java.util.Random;

public class Card<elements> {
    public enum Color { ROUGE, BLEU, VERT, JAUNE, VIOLET, MARRON, ORANGE, ROSE, GRIS, NOIR };
    private Color color;
    private Color nameColor;
    private Color[] allColors = Color.values();

    private static Random numberGenerator = new Random();

    public <T> T randomElement(T[] elements){
        return elements[numberGenerator.nextInt(elements.length)];
    }

    public Card (){
        this.color = randomElement(allColors);
        this.nameColor = randomElement(allColors);
    }

    public Color getColor(){
        return color;
    }

    public Color getNameColor() {
        return nameColor;
    }
}