package com.example.slmns.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Rasmus laptop on 29/05/2017.
 */

public class TilbudSideActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    private Button buttonLavTilbud;
    private Button buttonSeTidligereTilbud;
    private Button buttonTilbage;


    //Opretter siden til tilbud, med tre knapper (nyt tilbud, tilbuds oversigt og tilbage).
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tilbud);
        firebaseAuth = FirebaseAuth.getInstance();



        buttonLavTilbud = (Button) findViewById(R.id.buttonLavTilbud);
        buttonSeTidligereTilbud = (Button) findViewById(R.id.buttonSeTidligereTilbud);
        buttonTilbage = (Button) findViewById(R.id.buttonTilbage);

        buttonTilbage.setOnClickListener(this);
        buttonSeTidligereTilbud.setOnClickListener(this);
        buttonLavTilbud.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == buttonLavTilbud){
            startActivity(new Intent(this, NytTilbudActivity.class));
        }

        if(view == buttonTilbage) {
            startActivity(new Intent(this, FrontPageActivity.class));
        }

        if(view == buttonSeTidligereTilbud) {
            startActivity(new Intent(this, TilbudOversigtActivity.class));
        }
    }
}
