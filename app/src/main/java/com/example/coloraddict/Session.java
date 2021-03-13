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
    private Stack middleStack;

    // pas fini

    /**
     * default constructor
     */
    public Session () {
        deck = new Deck();
        middleStack = new Stack();
        players = new LinkedList<Player>();
    }

    /**
     * default method to add a player to the actual session
     */
    public void addPlayer () {
        if( Player.getNbPlayers() < nbPlayerMax){
            players.add(new Player());
        }
    }

    /**
     * method with parameter to add a player to the actual session
     * @param pseudo the name of the player
     */
    public void addPlayer (String pseudo) {
        players.add(new Player(pseudo));
    }

    /**
     * method to get the deck for the session
     * @return deck a copy of the initial deck
     */
    public Deck getDeck () {
        return this.deck;
    }

    /**
     * initialize stacks and hands for all players
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

    // permettre de rejoueur avec les memes joeurs ?
    public void replay(){

    }
}
