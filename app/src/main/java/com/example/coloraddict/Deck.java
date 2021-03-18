/**
 * @author Noémie Farizon
 * @date 13.03.2021
 */
package com.example.coloraddict;

import java.util.ArrayList;
import java.util.Random;

// singleton pattern to have only one deck of cards for the game
public class Deck {

    private static Deck _instance = null;
    private static int size = 20;

    private ArrayList cards;

    private Random randomGenerator;

    /**
     * default constructor for the deck
     */
    public Deck () {
        int i;
        cards = new ArrayList<Card>();
        for(i = 0; i < size; i++){
            cards.add(new Card());
        }
    }

    /**
     * @return an instance of the deck
     */
    public static Deck Instance() {
        if (_instance == null)
            _instance = new Deck();
        return _instance;
    }

    /**
     * method to take a card in the deck randomly
     * @return card a card of the deck
     */
    public Card getRandomCard () {
        //if(!cards.isEmpty()){
           // int index = randomGenerator.nextInt(cards.size());
            //Card card = (Card) cards.get(index);
            //cards.remove(index);
        //}
        Card card = (Card) cards.get(1);
        cards.remove(1);
        return card;
    }

    /**
     * @return size the number of cards in the deck
     */
    public static int getSize () {
        return size;
    }
}
