package com.example.taulaperiodicafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button Jocbtn;
    Button Taulabtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Jocbtn = (Button)findViewById(R.id.Joc);
        Taulabtn = (Button)findViewById(R.id.Taula);

        Jocbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Joc.class);
                startActivityForResult(intent, 0);
            }
        });

        Taulabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), Taula.class);
                startActivityForResult(intent, 0);
            }
        });

    }

}