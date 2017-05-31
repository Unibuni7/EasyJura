package com.example.slmns.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Rasmus laptop on 31/05/2017.
 */

public class MedarbejderActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        firebaseAuth = FirebaseAuth.getInstance();
        // If the firebaseAuth variable is null the user should be directed back to the login screen.
        if(firebaseAuth == null){
            finish();
            startActivity(new Intent(getApplicationContext(), PasswordActivity.class));
        }

    }

    @Override
    public void onClick(View view) {

    }
}
