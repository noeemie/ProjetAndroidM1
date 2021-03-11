package com.example.coloraddict;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.LinkedList;
// ne pas oublier de remettre le nombre de joueurs à 0 en fin de partie
public class Game extends AppCompatActivity {

    private ImageView mCardStack;
    private ImageView mHand;
    private Button mDrawACard;
    private LinearLayout mZoneDrag;

    private Deck deck;
    private int nbPlayerMax = 6;
    private LinkedList players;

    // pas fini
    public Game () {
        deck = new Deck();
        players = new LinkedList<Player>();
    }

    public void addPlayer () {
        if( Player.getNbPlayers() < nbPlayerMax){
            players.add(new Player());
        }
    }

    public void addPlayer (String pseudo) {
        players.add(new Player(pseudo));
    }

    public Deck getDeck () {
        return this.deck;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mCardStack = (ImageView) findViewById(R.id.cardStack);
        mHand = (ImageView) findViewById(R.id.hand);
        mDrawACard = (Button) findViewById(R.id.drawACard);
        mZoneDrag = (LinearLayout) findViewById(R.id.zoneDrag);

        mDrawACard.setEnabled(true);

        mDrawACard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The user just clicked
                // pick a card in you own stack of cards
            }
        });

        mHand.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                ClipData.Item item = new ClipData.Item((CharSequence)v.getTag());
                String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};

                ClipData dragData = new ClipData(v.getTag().toString(),mimeTypes, item);
                View.DragShadowBuilder myShadow = new View.DragShadowBuilder(mHand);

                v.startDrag(dragData,myShadow,null,0);
                return true;
            }
        });

        mHand.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                switch(event.getAction()) {
                    case DragEvent.ACTION_DRAG_STARTED:
                        mZoneDrag = (RelativeLayout.LayoutParams)v.getLayoutParams();
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_STARTED");

                        // Do nothing
                        break;

                    case DragEvent.ACTION_DRAG_ENTERED:
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_ENTERED");
                        int x_cord = (int) event.getX();
                        int y_cord = (int) event.getY();
                        break;

                    case DragEvent.ACTION_DRAG_EXITED :
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_EXITED");
                        x_cord = (int) event.getX();
                        y_cord = (int) event.getY();
                        layoutParams.leftMargin = x_cord;
                        layoutParams.topMargin = y_cord;
                        v.setLayoutParams(layoutParams);
                        break;

                    case DragEvent.ACTION_DRAG_LOCATION  :
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_LOCATION");
                        x_cord = (int) event.getX();
                        y_cord = (int) event.getY();
                        break;

                    case DragEvent.ACTION_DRAG_ENDED   :
                        Log.d(msg, "Action is DragEvent.ACTION_DRAG_ENDED");

                        // Do nothing
                        break;

                    case DragEvent.ACTION_DROP:
                        Log.d(msg, "ACTION_DROP event");

                        // Do nothing
                        break;
                    default: break;
                }
                return true;
            }
        });

        mHand.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ClipData data = ClipData.newPlainText("", "");
                    View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(mHand);

                    mHand.startDrag(data, shadowBuilder, mHand, 0);
                    mHand.setVisibility(View.INVISIBLE);
                    return true;
                } else {
                    return false;
                }
            }
        });
    }
}