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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonSignIn;
    private EditText editTextPhone, editTextPassword;
    private TextView textViewSignup;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() != null){
            //start profile activity here
            finish();
            startActivity(new Intent(getApplicationContext(), PasswordActivity.class));
        }
        editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonSignIn = (Button) findViewById(R.id.buttonSignin);
        textViewSignup = (TextView) findViewById(R.id.textViewSignup);
        progressDialog = new ProgressDialog(this);


        buttonSignIn.setOnClickListener(this);
        textViewSignup.setOnClickListener(this);
    }

    private void userLogin(){
        String phone = editTextPhone.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        // checking if email and password are empty
        if (TextUtils.isEmpty(phone)){
            //email is empty
            Toast.makeText(this, "Please enter phone-number", Toast.LENGTH_SHORT).show();
            // return will stop the funtion
            return;
        }
        if (TextUtils.isEmpty(password)){
            //password is empty
            Toast.makeText(this, "Please enter Password", Toast.LENGTH_SHORT).show();
            return;
        }
        // if validations are ok
        // we will first show a progressdialog

        progressDialog.setMessage("Signing in ....");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(phone+"@phone.no",password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();

                if (task.isSuccessful()){
                    // Start the profile activity
                    finish();
                    startActivity(new Intent(getApplicationContext(), PasswordActivity.class));
                } else {
                    Toast.makeText(LoginActivity.this, "Access denied, please try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
    if (view == buttonSignIn){
        userLogin();
    }
    if (view == textViewSignup){
        finish();
        startActivity(new Intent(this,main.class));
    }
    }
}
