package com.example.slmns.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class NotesRead extends AppCompatActivity implements View.OnClickListener {

    private TextView textViewReadName,textViewReadNote;
    private Button buttonReadBack;
    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_read);
        textViewReadName = (TextView) findViewById(R.id.textViewReadNoteName);
        textViewReadNote = (TextView) findViewById(R.id.textViewNotes);
        buttonReadBack = (Button) findViewById(R.id.ButtonReadBack);




        buttonReadBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == buttonReadBack){
            finish();
        }
    }
}
