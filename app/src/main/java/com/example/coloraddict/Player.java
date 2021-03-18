/**
 * @author Noémie Farizon
 * @date 13.03.2021
 */
package com.example.coloraddict;

import java.util.ArrayList;
import java.util.Random;

public class Player {

    private static int nbPlayers = 0;

    private enum State {WIN, PLAY, WAIT};
    private State state;

    private String pseudo;
    private ArrayList hand;
    private ArrayList cardStack;

    private Random randomGenerator;

    /**
     * default constructor with default pseudo
     */
    public Player() {
        nbPlayers++;
        this.pseudo = "Joueur" + nbPlayers;
        this.state = State.WAIT;
        hand = new ArrayList<Card>();
        cardStack = new ArrayList<Card>();
    }

    /**
     * constructor with choose pseudo
     * @param pseudo name of the player
     */
    public Player(String pseudo) {
        super();
        this.pseudo = pseudo;
    }

    /**
     * pickup all cards the player needs to start the game
     * all decks' cards are used for each game
     */
    public void initializeCardStack(Session session) {
        int i;
        for (i = 0; i < (session.getDeck().getSize() / nbPlayers); i++) { // faire attention quand il y a un chiffre impaire de carte/ nombre pair de joueur et inversement
            cardStack.add(session.getDeck().getRandomCard());
        }
    }

    /**
     * method to get 3 card to start
     */
    public void initializeHand() {
        int i;
        int index = randomGenerator.nextInt(cardStack.size());
        for (i = 0; i < 3; i++) {
            hand.add(cardStack.get(index));
        }
    }

    /**
     * pickup a card from our own stack and set it in our own hand
     */
    public void getRandomCardStack() {
        if (!cardStack.isEmpty()) {
            int index = randomGenerator.nextInt(cardStack.size());
            hand.add((Card) cardStack.get(index));
            cardStack.remove(index); // si on la met dans la main on doit la retirer de la pile
        }
    }

    /**
     * pickup a card from our own stack
     * @return nbPlayers the number of player for the actual session
     */
    public static int getNbPlayers() {
        return nbPlayers;
    }

    // pour remettre le nombre de joueurs à 0 en fin de partie
    public static void resetNbPlayers() {
        nbPlayers = 0;
    }

    /**
     * method to take a card to play
     */
    public Card getCardHand(int index) {
        // juste prendre une carte dans la main, c'est la session qui verrifie et qui fait repiocher automotiquement si ok
        return (Card) hand.get(index);
    }

    /**
     * method to get the last card of the hand (use after pick up a card)
     * @return return the last card of the list
     */
    public Card getLastCardHand() {
        return (Card) hand.get(hand.size() - 1);
    }

    /**
     * method to remove a card from the hand of the player
     * @param index the place of the card in the hand
     */
    public void removeCardHand(int index){
        hand.remove(index);
    }

    /**
     * method to get the size of the hand of the player
     * @return the size of the hand
     */
    public int getHandSize() {
        return hand.size();
    }

    /**
     * method to know if the player win
     * @return true if the hand is empty
     */
    public boolean isEmptyHand(){
        return hand.isEmpty();
    }

    /**
     * method to know if the player can pick up a card in the stack
     * @return true if the stack is empty
     */
    public boolean isEmptyStack(){
        return cardStack.isEmpty();
    }

    /**
     * method to set the state WIN for a player
     */
    public void win() {
        state = State.WIN;
    }

    /**
     * method to know if the player is steel playing
     * @return true if the state is WIN
     */
    public boolean isStateWin() {
        return state == State.WIN;
    }
}
