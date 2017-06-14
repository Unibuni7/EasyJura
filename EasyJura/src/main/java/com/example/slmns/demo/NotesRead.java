package com.example.slmns.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotesRead extends AppCompatActivity implements View.OnClickListener {


    private Button buttonReadBack;
    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;


    ListView listViewNotes;
    List<UserNotes> usernotesList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_read);
        listViewNotes = (ListView) findViewById(R.id.ListViewNotes);
        buttonReadBack = (Button) findViewById(R.id.ButtonReadBack);

        FirebaseUser user = firebaseAuth.getInstance().getCurrentUser();
        // We tell the program where the values are.
        databaseReference = FirebaseDatabase.getInstance().getReference("Notes").child(user.getUid());


        usernotesList = new ArrayList<>();




        buttonReadBack.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                usernotesList.clear();
                for (DataSnapshot notesSnapshot : dataSnapshot.getChildren()){

                    UserNotes userNotes = notesSnapshot.getValue(UserNotes.class);
                    // we add the usernotes objects to the usernotesList arraylist.
                    usernotesList.add(userNotes);
                }
                // You can use this adapter to provide views for an AdapterView,
                // Returns a view for each object in a collection of data objects you provide,
                // and can be used with list-based user interface widgets such as ListView
                NoteList arrayAdapter = new NoteList(NotesRead.this, usernotesList);
                listViewNotes.setAdapter(arrayAdapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view == buttonReadBack){
            finish();
        }
    }
}
