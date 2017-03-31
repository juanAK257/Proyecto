package com.example.zeus.agenda;

import android.app.NotificationManager;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;
import java.util.ArrayList;

public class ActivityCreaContacto extends AppCompatActivity {
    Button botonAceptar,botonCancelar;
    final Contactos contacto = new Contactos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_crea_contacto);
        botonAceptar = (Button) findViewById(R.id.btnAceptar);
        botonCancelar = (Button) findViewById(R.id.btnCancelar);


        Bundle extras = getIntent().getExtras();
        final ArrayList<Contactos> objeto = (ArrayList<Contactos>) extras.get("OBJETO");


        ///Aceptar

        //Boton Aceptar
        findViewById(R.id.btnAceptar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creo el contacto

                contacto.setNombre(((EditText) findViewById(R.id.editTextNm)).getText().toString());
                contacto.setApellidos(((EditText) findViewById(R.id.editTextApellid)).getText().toString());
                contacto.setTlfn(((EditText) findViewById(R.id.editTextTlfn)).getText().toString());
                contacto.setEmail(((EditText) findViewById(R.id.editTextEmail)).getText().toString());
                objeto.add(contacto);

                setResult(RESULT_OK, getIntent().putExtra("OBJETO", objeto));

                finish();
                //ME voy de la actividad y se borran los datos

            }
        });

    }
}

