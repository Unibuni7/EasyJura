package com.example.slmns.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.security.auth.PrivateCredentialPermission;

public class NotesActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonNotesAdd;
    private Button buttonNotesRead;
    private Button buttonTilbage;
    private TextView textViewNotes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        buttonNotesAdd = (Button) findViewById(R.id.buttonAddNotes);
        buttonNotesRead = (Button) findViewById(R.id.buttonReadNotes);
        buttonTilbage = (Button) findViewById(R.id.buttonTilbage);
        textViewNotes = (TextView) findViewById(R.id.textViewNotes);

        buttonNotesAdd.setOnClickListener(this);
        buttonNotesRead.setOnClickListener(this);
        buttonTilbage.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        if (view == buttonNotesAdd){
            startActivity(new Intent(this,NotesAdd.class));
        }
        if (view == buttonNotesRead){
            startActivity(new Intent(this, NotesRead.class));
        }
        if (view == buttonTilbage) {
            startActivity(new Intent(this,FrontPageActivity.class ));
        }

    }
}
