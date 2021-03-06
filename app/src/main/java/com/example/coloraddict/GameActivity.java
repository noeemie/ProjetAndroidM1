/**
 * @author Noémie Farizon
 * @date 13.03.2021
 */
package com.example.coloraddict;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.LinkedList;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.LTGRAY;
import static android.graphics.Color.RED;
import static android.graphics.Color.WHITE;



public class GameActivity extends AppCompatActivity {

    private Button mCardStack;
    private HorizontalScrollView mHand;
    private Button mDrawACard;
    private LinearLayout mLayoutHand;

    private Session session;
    int j = 0;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mCardStack = (Button) findViewById(R.id.cardStack);
        mHand = (HorizontalScrollView) findViewById(R.id.hand);
        mDrawACard = (Button) findViewById(R.id.drawACard);
        mLayoutHand = (LinearLayout) findViewById(R.id.layoutHand);

        mCardStack.setEnabled(true);

        session = new Session(); // faire ca au moment ou on creer une salle
        session.reset(); // pour remettre a 0 le nombre de joueurs (variable de classe)
        //recuperer le nombre de joueurs pour la partir grace a la page en question --> faire ca quand on appuye sur le bouton pour ajouter des joueurs
        int a;
        for(a = 0; a < 2; a++){
            session.addPlayer(); // modifier car certain joueurs on des pseudo
        }
        session.initializeMiddleStack();
        //session.initializeSession(); // initialisation des pioches perso de tout les joueurs et inistialisation des cartes --> faire ca quand on appuye sur le bouton pour lancer la partie


        //for (; j < 2; j++) {
            ////////////////////////////////////////// initialiser l'ecran de jeu avec les cartes du joueur ////////////////////////////////
            // ajout dynamic de boutons dans la main
            //for (; i < session.getPlayer(j).getHandSize(); i++) {
            for(; i < 5; i++){

                final Button card = new Button(this);
                //card.setText(session.getPlayer(j).getCardHand(i).getNameColor().toString()); // aller chercher la carte dans la liste du joueur en train de jouer
                card.setText("carte");
                card.setId(i + 1);
                card.setBackgroundColor(LTGRAY);
                //card.setTextColor(/*session.getPlayer(j).getCardHand(i).getColor()*/ RED); // couleur du texte de la carte du joueur

                LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);

                mLayoutHand.addView(card, buttonParams);

                //////////////////retirer le listener


            }
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //}

        /*mDrawACard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The user just clicked
                // pick a card in you own stack of cards
                session.getPlayer(j).getRandomCardStack();
                Button newCard = new Button(this);
                // reference pour faire le onClick de manière récursive
                final View.OnClickListener ref2 = this;
                newCard.setText(session.getPlayer(j).getLastCardHand().getNameColor().toString()); // aller chercher la carte dans la liste du joueur en train de jouer
                newCard.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {// action de jouer la carte
                        //prendre la carte de la liste
                        //Card cardPlay1 = session.getPlayer(j).getCardHand();
                        // tester si la carte est bonne
                        if(newCard.isOK(session.getStack())){
                            // la partie ne s'arrete que quand les n-1 joueurs ont le statut WIN
                            if(session.isFinished()){
                                // aller a l'écran des scores
                            }
                            // mettre son texte dans le bouton du centre
                            mCardStack.setText(session.getPlayer(j).getCardHand().getNameColor().toString());
                            // retirer la carte de la main apres l'avoir jouée
                            mLayoutHand.removeView(newCard);
                            // picher automatiquement une carte
                            session.getPlayer(j).getRandomCardStack();
                            Button newCardPlay2 = new Button(v.getContext());
                            newCardPlay2.setText(session.getPlayer(j).getLastCardHand().getNameColor().toString()); // aller chercher la carte dans la liste du joueur en train de jouer
                            newCardPlay2.setTextColor(session.getPlayer(j).getCardHand().getColor()); // couleur du texte de la carte du joueur

                            newCardPlay2.setOnClickListener(ref2);

                            newCardPlay2.setBackgroundColor(LTGRAY);

                            LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(
                                    LinearLayout.LayoutParams.MATCH_PARENT,
                                    LinearLayout.LayoutParams.MATCH_PARENT);

                            mLayoutHand.addView(newCardPlay2, buttonParams);

                            // apres avoir joué on regarde si il reste encore des cartes et si non on a gagné
                            if(session.getPlayer(j).isEmptyHand()){
                                session.getPlayer(j).win();
                            }
                        }
                    }
                });

                newCard.setBackgroundColor(LTGRAY);
                newCard.setTextColor(session.getPlayer(j).getCardHand().getColor()); // couleur du texte de la carte du joueur

                LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);

                mLayoutHand.addView(newCard, buttonParams);
                // desactiver le bouton de pioche quand la pioche est vide
                if(session.getPlayer(j).isEmptyStack()){
                    mDrawACard.setEnabled(true);
                }
            }
        });*/
    }
}