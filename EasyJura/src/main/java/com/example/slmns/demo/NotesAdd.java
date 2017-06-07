package com.example.slmns.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NotesAdd extends AppCompatActivity  implements View.OnClickListener{

    private EditText editTextNoteName,editTextNotes;
    private Button buttonSaveNote,buttonBackNotesAdd;
    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_add);

        editTextNoteName = (EditText) findViewById(R.id.editTextNameNote);
        editTextNotes = (EditText) findViewById(R.id.editTextNote);
        buttonSaveNote = (Button) findViewById(R.id.buttonSaveNote);
        buttonBackNotesAdd = (Button) findViewById(R.id.buttonBackNoteAdd);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();


        // SetonclickListener allows us to use them as clickable buttons
        buttonSaveNote.setOnClickListener(this);
        buttonBackNotesAdd.setOnClickListener(this);

    }


    // SaveNote method will allow us to save our notes in the database.
    protected void SaveNote(

    ){

        // we assign the viarables that we are going to use.
        String NoteName = editTextNoteName.getText().toString().trim();
        String Note = editTextNotes.getText().toString().trim();

        // Create a new object of the UserNotes class.
        UserNotes userNotes = new UserNotes(Note);

        // The current users id will be used when you use this activity.
        FirebaseUser user = firebaseAuth.getCurrentUser();

        // We create children, and after that we assign a value by using setValue (There are probably better way to do it, but this works too.)
        databaseReference.child("Notes").child(user.getUid()).child(NoteName).setValue(userNotes);

        Toast.makeText(this,"Note Saved....", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {

        if (view == buttonBackNotesAdd){
            startActivity(new Intent(this,NotesActivity.class));
        }

        if (view == buttonSaveNote){
            SaveNote();
        }
    }
}
