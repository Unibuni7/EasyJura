package com.example.slmns.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class FakturaActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth firebaseAuth;
    private EditText editTextPrisMaterialer, editTextLønningerTotal;
    private TextView textViewUdregnet;
    private Button buttonUdregnAdd, subtract, multiply, tilbage;
    private int materialePris, lønningerTotal;
    private AdView adView;
    private AdRequest adRequest;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faktura);


        firebaseAuth = FirebaseAuth.getInstance();

        editTextLønningerTotal = (EditText) findViewById(R.id.editTextLønningerTotal);
        editTextPrisMaterialer = (EditText) findViewById(R.id.editTextPrisMaterialer);
        textViewUdregnet = (TextView) findViewById(R.id.textViewUdregnet);
        buttonUdregnAdd = (Button) findViewById(R.id.buttonUdregnAdd);
        subtract = (Button) findViewById(R.id.subtract);
        multiply = (Button) findViewById(R.id.multiply);
        tilbage = (Button) findViewById(R.id.buttonTilbage);
        adView = (AdView) findViewById(R.id.adWin);
        adRequest = new AdRequest.Builder()
                .addTestDevice(adRequest.DEVICE_ID_EMULATOR)
                .build();


        adView.loadAd(adRequest);



        materialePris = 1;
        lønningerTotal = 1;

        buttonUdregnAdd.setOnClickListener(this);
        subtract.setOnClickListener(this);
        multiply.setOnClickListener(this);
        tilbage.setOnClickListener(this);

        editTextLønningerTotal.setText("5");
        editTextPrisMaterialer.setText("7");


    }

    public int addTotalPrice(int materialePris, int lønningerTotal){

        int endPrice = materialePris + lønningerTotal;
        return endPrice;
    }

    public int subtractTotalPrice(int materialePris, int lønningerTotal){

        int endPrice = materialePris - lønningerTotal;
        return endPrice;
    }
    public int multiplyPrice (int materialePris, int lønningerTotal){
        int endPrice = materialePris * lønningerTotal;
        return endPrice;
    }

    @Override
    public void onClick(View view) {
        if(view == buttonUdregnAdd){
            materialePris = Integer.parseInt(editTextPrisMaterialer.getText().toString());
            lønningerTotal = Integer.parseInt(editTextLønningerTotal.getText().toString());
            textViewUdregnet.setText(Integer.toString(addTotalPrice(materialePris, lønningerTotal)));

        }

        if(view == subtract){
            materialePris = Integer.parseInt(editTextPrisMaterialer.getText().toString());
            lønningerTotal = Integer.parseInt(editTextLønningerTotal.getText().toString());
            textViewUdregnet.setText(Integer.toString(subtractTotalPrice(materialePris, lønningerTotal)));

        }
        if(view == multiply){
            materialePris = Integer.parseInt(editTextPrisMaterialer.getText().toString());
            lønningerTotal = Integer.parseInt(editTextLønningerTotal.getText().toString());
            textViewUdregnet.setText(Integer.toString(multiplyPrice(materialePris, lønningerTotal)));
        }
        if(view == tilbage) {
            finish();
        }

    }
}
