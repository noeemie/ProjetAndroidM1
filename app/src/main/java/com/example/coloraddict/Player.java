/**
 * @author Noémie Farizon
 * @date 13.03.2021
 */
package com.example.coloraddict;

import java.util.ArrayList;
import java.util.Random;

public class Player {

    private static int nbPlayers = 0;

    private enum State {WIN, LOOSE, PLAY, WAIT};
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
        for (i = 0; i < (session.getDeck().getSize() / nbPlayers); i++) {
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
     * pickup a card from our own stack
     */
    public void getRandomCardStack() {
        if (!cardStack.isEmpty()) {
            int index = randomGenerator.nextInt(cardStack.size());
            hand.add((Card) cardStack.get(index));
            cardStack.remove(index); // si on la met dans la main on doit la retirer de la pile
        } else {
            System.out.println("Plus de carte à piocher !");
        }
    }

    /**
     * pickup a card from our own stack
     *
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
    // finir / revoir
    // tester la carte avant de la poser pour savoir si correct renvoie un message d'erreur sinon

    // juste prendre une carte dans la main, c'est la session qui verrifie et qui fait repiocher automotiquement si ok
    public Card getCardHand(int index) {
        Card card = (Card) hand.get(index);
        return card;
    }

    // retire la carte de la main du joueur
    public void removeCardHand(int index){
        hand.remove(index);
    }
}
