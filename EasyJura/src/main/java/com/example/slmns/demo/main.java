package com.example.slmns.demo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class main extends AppCompatActivity implements View.OnClickListener {

    private Button buttonRegister;
    private EditText editTextEmail,editTextpassword;
    private TextView textViewSignin;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() != null){
            //start profile activity here
            finish();
            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
        }
        progressDialog = new ProgressDialog(this);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextpassword = (EditText) findViewById(R.id.editTextPassword);
        textViewSignin = (TextView) findViewById(R.id.textViewSigning);

        buttonRegister.setOnClickListener(this);
        textViewSignin.setOnClickListener(this);

    }

    private void registerUser(){
        String email = editTextEmail.getText().toString().trim();
        String password = editTextpassword.getText().toString().trim();
        // checking if email and password are empty
        if (TextUtils.isEmpty(email)){
            //email is empty
            Toast.makeText(this, "Please enter Email", Toast.LENGTH_SHORT).show();
            // return will stop the funtion
            return;
        }
        if (TextUtils.isEmpty(password)){
            //password is empty
            Toast.makeText(this, "Please enter Password", Toast.LENGTH_SHORT).show();
            return;
        }
        // if validations are ok
        // we will show a progressdialog

        progressDialog.setMessage("Registering user...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    // user if successfully registered and logged in
                    // we will start the profile activity here
                    // right now we will only display a toast

                        //start profile activity here
                        finish();
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));

                    Toast.makeText(main.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(main.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onClick(View view) {

        if(view == buttonRegister) {
            registerUser();
        }

        if(view == textViewSignin){
            //will open login activity here
            startActivity(new Intent(this,LoginActivity.class));
        }

    }
}
