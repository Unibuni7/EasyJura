package com.example.slmns.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Rasmus laptop on 29/05/2017.
 */

public class NytTilbudActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonRedigerProfil;
    private FirebaseAuth firebaseAuth;
    private EditText editTextFirmaNavn, editTextCVR, editTextFnavn, editTextEnavn, editTextTlf,
            editTextEmail, editTextAdresse, editTextPostNr, editTextBy;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nyttilbud);
        firebaseAuth.getInstance();

        editTextFirmaNavn = (EditText) findViewById(R.id.editTextFirmaNavn);
        editTextAdresse = (EditText) findViewById(R.id.editTextAdresse);

    }


    @Override
    public void onClick(View v) {

    }
}
