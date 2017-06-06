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

public class RegistreringActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonRegister;
    private EditText editTextPhone,editTextpassword, EditTextpasswordbekraft;
    private TextView textViewSignin;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() != null){
            //start activity here
            finish();
            startActivity(new Intent(getApplicationContext(), FrontPageActivity.class));
        }
        progressDialog = new ProgressDialog(this);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        editTextpassword = (EditText) findViewById(R.id.editTextPassword);
        textViewSignin = (TextView) findViewById(R.id.textViewSigning);
        EditTextpasswordbekraft = (EditText) findViewById(R.id.editTextPasswordbekraft);

        buttonRegister.setOnClickListener(this);
        textViewSignin.setOnClickListener(this);

    }

    private void registerUser(){
        String Phone = editTextPhone.getText().toString().trim();
        String password = editTextpassword.getText().toString().trim();
        String passwordb = EditTextpasswordbekraft.getText().toString().trim();
        // checking if email and password are empty
        if (TextUtils.isEmpty(Phone)){
            //email is empty
            Toast.makeText(this, "Please enter Phone", Toast.LENGTH_SHORT).show();
            // return will stop the funtion
            return;
        }
        if (TextUtils.isEmpty(password)){
            //password is empty
            Toast.makeText(this, "Please enter Password", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(passwordb)){
            // Confirm password is empty
            Toast.makeText(this, "Please enter Password again", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!password.equals(passwordb)) {
            Toast.makeText(this, "The password does not match", Toast.LENGTH_SHORT).show();
            return;
        }
        // if validations are ok
        // we will show a progressdialog

        progressDialog.setMessage("Registering user...");
        progressDialog.show();



        if (password.equals(passwordb)){
        firebaseAuth.createUserWithEmailAndPassword(Phone+"@phone.no",password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    // user if successfully registered and logged in
                    // we will start the profile activity here
                    // right now we will only display a toast

                        //start profile activity here
                        finish();
                        startActivity(new Intent(getApplicationContext(), FrontPageActivity.class));

                    Toast.makeText(RegistreringActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegistreringActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });}
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
