package com.example.taulaperiodicafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Joc extends AppCompatActivity {

    Button btnAnarJoc;
    Button btnTaula;
    Button btnAnarPirncipi;
    TextView  Pun;
    int PuntuacioFinal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joc);

        btnAnarJoc = (Button)findViewById(R.id.BotonAnarJoc);
        btnAnarPirncipi = (Button)findViewById(R.id.botonAnarPrincipi);
        btnTaula = (Button)findViewById(R.id.botonAnarTaula);
        Pun = (TextView)findViewById(R.id.Puntuacio);


       Bundle b = getIntent().getExtras();
       if(b != null){
           PuntuacioFinal = b.getInt("PO" );
           Pun.setText(String.valueOf(PuntuacioFinal));
       }

        btnAnarJoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), JocNivell1.class);
                startActivityForResult(intent, 0);
            }
        });

        btnAnarPirncipi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), MainActivity.class);
                startActivityForResult(intent, 0);
            }
        });


        btnTaula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Taula.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}