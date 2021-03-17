/**
 * @author Noémie Farizon
 * @date 13.03.2021
 */
package com.example.coloraddict;

import java.util.Random;

public class Card<elements> {

    public enum Color { RED, BLUE, GREEN, YELLOW, VIOLET, BROWN, ORANGE, ROSE, GRAY, BLACK };
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

    public String toString() {
        return "" + this.nameColor;
    }

    public boolean isOK(Card card) {
        return ((this.color == card.getColor())||(this.nameColor == card.getNameColor()))||((this.color == card.getColor())&&(this.nameColor == card.getNameColor()))||((this.color == card.getNameColor())||(this.nameColor == card.getColor()));
    }
}