package com.example.taulaperiodicafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Informacion_Elementos extends AppCompatActivity {

    TextView Nombre;
    TextView Simbolo;
    TextView Numero;
    TextView Peso;
    TextView Link;
    TextView Atomic;

    String[] ArrayExtra = new String[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion__elementos);

        Nombre = (TextView) findViewById(R.id.Nombre);
        Simbolo = (TextView) findViewById(R.id.Simb);
        Numero = (TextView) findViewById(R.id.Num);
        Peso = (TextView) findViewById(R.id.Pes);
        Atomic = (TextView)findViewById(R.id.atomic);
        Link = (TextView) findViewById(R.id.Enlla);

        //Creem un bundle y ponemos la clave anteriormente creada en la classse taula.
        Bundle bundle = getIntent().getExtras();
        ArrayExtra = bundle.getStringArray("Elementos");

        Nombre.setText(ArrayExtra[0]);
        Simbolo.setText(ArrayExtra[1]);
        Numero.setText(ArrayExtra[2]);
        Peso.setText(ArrayExtra[3]);
        Atomic.setText(ArrayExtra[4]);
        Link.setText(ArrayExtra[5]);

        //Para cunado clique el link enviar-lo al gogel con el link.
        Link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(ArrayExtra[5]));
                startActivity(intent);

            }
        });
    }

}