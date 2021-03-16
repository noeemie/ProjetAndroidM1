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
    private static int size = 110;

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

    // probleme car il faut retirer les cartes après les avoir prise pour eviter doublons -> regarder si ca ne trouche pas au deck mais plutot a l'instance
    /**
     * method to take a card in the deck randomly
     * @return card a card of the deck
     */
    public Card getRandomCard () {
        Card card = null;
        if(!cards.isEmpty()){
            int index = randomGenerator.nextInt(cards.size());
            card = (Card) cards.get(index);
            cards.remove(index);
        }
        return card;
    }

    /**
     * @return size the number of cards in the deck
     */
    public static int getSize () {
        return size;
    }
}
