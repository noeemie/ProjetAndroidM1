package com.example.coloraddict;

import java.util.ArrayList;
import java.util.Random;

// singleton pattern to have only one deck of cards for the game
public class Deck {

    private ArrayList cards;
    private static Deck _instance = null;
    private static int size = 110;
    private Random randomGenerator;

    public Deck () {
        int i;
        cards = new ArrayList<Card>();
        for(i = 0; i < size; i++){
            cards.add(new Card());
        }
    }

    public static Deck Instance() {
        if (_instance == null)
            _instance = new Deck();
        return _instance;
    }

    // probleme car il faut retirer les cartes après les avoir prise pour eviter doublons
    public Card getRandomCard () {
        Card card = null;
        if(!cards.isEmpty()){
            int index = randomGenerator.nextInt(cards.size());
            card = (Card) cards.get(index);
        }
        return card;
    }

    public static int getSize () {
        return size;
    }
}
