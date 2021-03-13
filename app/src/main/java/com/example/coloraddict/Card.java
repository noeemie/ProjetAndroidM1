/**
 * @author Noémie Farizon
 * @date 13.03.2021
 */
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

    /**
     * default constructor
     */
    public Card (){
        this.color = randomElement(allColors);
        this.nameColor = randomElement(allColors);
    }

    /**
     * method to get the color of the card
     * @return color the color of the card
     */
    public Color getColor(){
        return color;
    }

    /**
     * method to get the text on the card
     * @return nameColor the text on the card
     */
    public Color getNameColor() {
        return nameColor;
    }
}