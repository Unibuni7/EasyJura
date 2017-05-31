package com.example.slmns.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{


    private FirebaseAuth firebaseAuth; //for at får Authication med Firebase
    private EditText editTextFirmaNavn, editTextBranche, editTextCVR,editTextForNavn
            ,editTextEfterNavn,editTextEmail,editTextAdress,editTextPostNr,editTextBy;
    private Button buttonGem;
    private Button buttonTilbage;
    private DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        firebaseAuth = FirebaseAuth.getInstance();


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
        databaseReference = FirebaseDatabase.getInstance().getReference();


        buttonGem.setOnClickListener(this);// Fortal programmet man kan klik på den.
        buttonTilbage.setOnClickListener(this);



        


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
            databaseReference.child("Profile").child(user.getUid()).setValue(profileUser);
        } catch (NullPointerException e){
            System.out.println(e);
        }

        /*databaseReference.child("Profile").child(user.getUid()).child("Test").setValue(profileUser);*/
        Toast.makeText(this,"profile Saved....", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        if(view == buttonGem) {
        Gem();
        }
        if (view == buttonTilbage) {
        startActivity(new Intent(this,FrontPageActivity.class));
        }

    }
}
