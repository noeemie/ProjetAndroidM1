/**
 * @author Noémie Farizon
 * @date 13.03.2021
 */
package com.example.coloraddict;

import java.util.Collection;
import java.util.LinkedList;

// vider la liste de joueur en fin de session et mettre le nombre de joueur à 0
public class Session {

    private Deck deck;
    private int nbPlayerMax = 6;
    private LinkedList<Player> players;
    private Card middleStack;

    // pas fini

    /**
     * default constructor
     */
    public Session () {
        deck = new Deck();
        middleStack = new Card();
        players = new LinkedList<Player>();
    }

    /**
     * default method to add a player to the actual session
     */
    public void addPlayer () {
        if( Player.getNbPlayers() < nbPlayerMax){
            players.add(new Player());
        }else{
            System.out.println("nombre de joueurs max atteint");
        }
    }

    /**
     * method with parameter to add a player to the actual session
     * @param pseudo the name of the player
     */
    public void addPlayer (String pseudo) {
        players.add(new Player(pseudo));
    }

    public int getNbPlayers() {
        return players.size();
    }

    /**
     * method to get a player of the list
     * @param index the place of the player in the list
     * @return a player
     */
    public Player getPlayer(int index){
        return players.get(index);
    }

    /**
     * method to get the deck for the session
     * @return deck a copy of the initial deck
     */
    public Deck getDeck () {
        return this.deck;
    }

    /**
     * method to initialize the middle stack with a card of the deck before starting the game
     */
    public void initializeMiddleStack() {
        middleStack = deck.getRandomCard();
    }

    /**
     * initialize stacks and hands for all players (use after initializeMiddleStack)
     */
    public void initializeSession(){
        int i;
        for(i = 0; i < players.size(); i++){
            players.get(i).initializeCardStack(this);
            players.get(i).initializeHand();
        }
    }

    /**
     * method to use at the end of the session to reset
     */
    public void finish() {
        Player.resetNbPlayers();
        players.clear();
    }

    /**
     * method to know if the session is over
     * @return true if the session is over
     */
    public boolean isFinished(){
        return ;
    }
}
