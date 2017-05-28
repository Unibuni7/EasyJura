package com.example.slmns.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Rasmus laptop on 28/05/2017.
 */

public class FrontPageActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;
    private Button buttonTilbud;
    private Button buttonSoeg;
    private Button buttonRegnskab;
    private Button buttonMedarbejder;
    private Button buttonNotater;
    private Button buttonProfil;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frontpage);
        firebaseAuth = FirebaseAuth.getInstance();

        buttonProfil = (Button) findViewById(R.id.buttonProfil);
        buttonMedarbejder = (Button) findViewById(R.id.buttonMedarbejdere);
        buttonRegnskab = (Button) findViewById(R.id.buttonRegnskab);
        buttonSoeg = (Button) findViewById(R.id.buttonSoeg);
        buttonTilbud = (Button) findViewById(R.id.buttonTilbud);
        buttonNotater = (Button) findViewById(R.id.buttonNotater);

        if (firebaseAuth == null){
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();



        buttonProfil.setOnClickListener(this);
        buttonMedarbejder.setOnClickListener(this);
        buttonNotater.setOnClickListener(this);
        buttonRegnskab.setOnClickListener(this);
        buttonSoeg.setOnClickListener(this);
        buttonTilbud.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == buttonProfil){
            startActivity(new Intent(this, ProfileActivity.class));
        }
        if(view == buttonNotater){
            startActivity(new Intent(this,NotesActivity.class ));
        }/*else if( view == buttonMedarbejder) {
            startActivity(new Intent(this, MedarbejdereActivity.class));
        }else if( view == buttonRegnskab) {
            startActivity(new Intent(this, RegnskabActivity.class));
        }else if ( view == buttonSoeg) {
            startActivity(new Intent(this, SoegActivity.class));
        }else if ( view == buttonTilbud) {
            startActivity(new Intent(this, TilbudActivity.class));
        }*/
    }
}

