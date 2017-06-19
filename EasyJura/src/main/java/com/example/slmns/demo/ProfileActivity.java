package com.example.slmns.demo;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{


    private EditText editTextFirmaNavn, editTextBranche, editTextCVR,editTextForNavn
            ,editTextEfterNavn,editTextEmail,editTextAdress,editTextPostNr,editTextBy;
    private Button buttonGem;
    private Button buttonTilbage;
    private Button buttonPassword;
    private FirebaseAuth firebaseAuth; //for at får Authication med Firebase
    private DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //Firebase information Auth and user
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getInstance().getCurrentUser();

        editTextBranche = (EditText) findViewById(R.id.Branche_EditText);
        editTextCVR = (EditText) findViewById(R.id.CvrNr_EditText);
        editTextFirmaNavn = (EditText) findViewById(R.id.FirmaNavn_EditText);
        editTextForNavn = (EditText) findViewById(R.id.Fornavn_EditText);
        editTextEfterNavn = (EditText) findViewById(R.id.EfterNavn__EditText);
        editTextEmail = (EditText) findViewById(R.id.Email_EditText);
        editTextAdress = (EditText) findViewById(R.id.Adresse_EditText);
        editTextPostNr = (EditText) findViewById(R.id.PostNr_EditText);
        editTextBy = (EditText) findViewById(R.id.By_EditText);
        buttonGem = (Button) findViewById(R.id.buttonGem);
        buttonTilbage= (Button) findViewById(R.id.buttonTilbage);
        buttonPassword = (Button) findViewById(R.id.buttonChangePassword);
        databaseReference = FirebaseDatabase.getInstance().getReference("Profile").child(user.getUid());


        buttonGem.setOnClickListener(this);// Fortæl programmet man kan klikke på den.
        buttonTilbage.setOnClickListener(this);
        buttonPassword.setOnClickListener(this);

    }


    public void onStart() {
        super.onStart();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                    ProfileUser profileUser = dataSnapshot.getValue(ProfileUser.class);

                try {
                    System.out.println(profileUser);
                    if (profileUser.fornavn != null) {
                        editTextForNavn.setText(profileUser.fornavn);
                    }
                    if (profileUser.adress != null) {
                        editTextAdress.setText(profileUser.adress);
                    }
                    if (profileUser.branche != null) {
                        editTextBranche.setText(profileUser.branche);
                    }
                    if (profileUser.by != null) {
                        editTextBy.setText(profileUser.by);
                    }
                    if (profileUser.cvr != null) {
                        editTextCVR.setText(profileUser.cvr);
                    }
                    if (profileUser.efterNavn != null) {
                        editTextEfterNavn.setText(profileUser.efterNavn);
                    }
                    if (profileUser.email != null) {
                        editTextEmail.setText(profileUser.email);
                    }
                    if (profileUser.firmaNavn != null) {
                        editTextFirmaNavn.setText(profileUser.firmaNavn);
                    }
                    if (profileUser.postNr != null) {
                        editTextPostNr.setText(profileUser.postNr);
                    }
                } catch (NullPointerException e){
                    System.out.println(e);
                }



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void Gem(){

        // we assign the viarables that we are going to use.
        String firmaNavn = editTextFirmaNavn.getText().toString().trim();
        String branche = editTextBranche.getText().toString().trim();
        String cvr = editTextCVR.getText().toString().trim();
        String forNavn = editTextForNavn.getText().toString().trim();
        String efterNavn  = editTextEfterNavn.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String  adress= editTextAdress.getText().toString().trim();
        String  postNr= editTextPostNr.getText().toString().trim();
        String by = editTextBy.getText().toString().trim();

        // Create a new object of the ProfileUser class.
        ProfileUser profileUser = new ProfileUser(firmaNavn,branche,forNavn,efterNavn,adress,email,by,cvr,postNr);


        // The current users id will be used when you use this activity.
        FirebaseUser user = firebaseAuth.getCurrentUser();


        // We create children, and after that we assign a value by using setValue (There are probably better way to do it, but this works too.)
        try{
            databaseReference.setValue(profileUser);
        } catch (NullPointerException e){
            System.out.println(e);
        }
    }

    /**
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        if(view == buttonGem) {
        Gem();
        }
        if (view == buttonTilbage) {
            finish();
        }
        if (view == buttonPassword){
            finish();
            startActivity(new Intent(this, PasswordActivity.class));
        }

    }
}
