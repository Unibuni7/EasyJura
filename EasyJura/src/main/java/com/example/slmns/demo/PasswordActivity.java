package com.example.slmns.demo;

import android.app.ProgressDialog;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class PasswordActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonUpdate;
    private EditText editTextOldPassword, editTextNewPassword, editTextPhone;
    private TextView textViewChangePassword;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        firebaseAuth = FirebaseAuth.getInstance();
        editTextOldPassword = (EditText) findViewById(R.id.editTextOldPassword);
        editTextNewPassword = (EditText) findViewById(R.id.editTextNewPassword);
        buttonUpdate = (Button) findViewById(R.id.buttonUpdate);
        textViewChangePassword = (TextView) findViewById(R.id.textViewChangePassword);
        editTextPhone = (EditText) findViewById(R.id.editTextPhoneChange);
        progressDialog = new ProgressDialog(this);


        buttonUpdate.setOnClickListener(this);

    }

    public void UpdatePassword() {
        String OldPassword = editTextOldPassword.getText().toString().trim();
        final String NewPassword = editTextNewPassword.getText().toString().trim();
        String Phone = editTextPhone.getText().toString().trim();

        // checking if OldPassword and NewPassword are empty
        if (TextUtils.isEmpty(OldPassword)) {
            //OldPassword is empty
            Toast.makeText(this, "Please enter Password", Toast.LENGTH_SHORT).show();
            // return will stop the funtion
            return;
        }
        if (TextUtils.isEmpty(NewPassword)) {
            //NewPassword is empty
            Toast.makeText(this, "Please enter New Password", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(Phone)) {
            //Phone is empty
            Toast.makeText(this, "Please enter Phone", Toast.LENGTH_SHORT).show();
            return;
        }
        // if validations are ok
        // we will first show a progressdialog

        AuthCredential credential = EmailAuthProvider.getCredential(Phone + "@phone.no", OldPassword);

        user.reauthenticate(credential).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    user.updatePassword(NewPassword).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(PasswordActivity.this, "Password Updated", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(PasswordActivity.this, "Error Password not updated", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(PasswordActivity.this, "Sum ting is Wong", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onClick(View view) {
        if (view == buttonUpdate) {
            UpdatePassword();
        }
    }
}