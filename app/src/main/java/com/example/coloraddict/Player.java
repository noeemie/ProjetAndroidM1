package com.example.coloraddict;

import java.util.ArrayList;
import java.util.Random;

public class Player {

    private static int nbPlayers = 0;
    private String pseudo;
    private enum State {WIN, LOOSE, PLAY, WAIT};
    private State state;
    private ArrayList hand = new ArrayList<Card>();
    private ArrayList cardStack = new ArrayList<Card>();
    private Random randomGenerator;

    // default pseudo
    public Player () {
        nbPlayers++;
        this.pseudo = "Joueur" + nbPlayers;
    }

    public Player (String pseudo){
        this.pseudo = pseudo;
        this.state = State.WAIT;
    }

    // pickup all cards the player needs to start the game
    // all decks' cards are used for each game
    public void initializeCardStack () {
        int i;
        for(i = 0; i < (game.getDeck().getSize() / nbPlayers); i++){
            cardStack.add(game.getdeck().getRandomCard());
        }
    }

    // get 3 card to start
    public void initializeHand () {
        int i;
        int index = randomGenerator.nextInt(cardStack.size());
        for(i = 0; i < 3; i++){
            hand.add(cardStack.get(index));
        }
    }

    // pickup a card from our own stack
    public void getRandomCardStack () {
        if(!cardStack.isEmpty()){
            int index = randomGenerator.nextInt(cardStack.size());
            hand.add((Card) cardStack.get(index));
        }else{
            System.out.println("Plus de carte à piocher !");
        }
    }

    public static int getNbPlayers() {
        return nbPlayers;
    }

    // pour remettre le nombre de joueurs à 0 en fin de partie
    public static void setNbPlayers(int i) {
        nbPlayers = i;
    }
}
