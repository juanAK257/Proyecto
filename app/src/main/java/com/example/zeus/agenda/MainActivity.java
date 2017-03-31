package com.example.zeus.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    static  final int LISTA=1;
    Button botonContac,botonLista;
    String contac;
    ArrayList <Contactos> contacto = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botonContac =(Button)findViewById(R.id.btnContac);
        botonLista=(Button)findViewById(R.id.btnLista);
        botonContac.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
    switch (v.getId()){
        case  R.id.btnLista:
            //Lanzo la activity lista y le paso el arraylist para que pueda mostrarlos
            startActivity(new Intent(getApplicationContext(), ActivityLista.class).putExtra("OBJETO", contacto));
            break;

        case R.id.btnContac:
            startActivityForResult(new Intent(getApplicationContext(), ActivityCreaContacto.class)
                    .putExtra("OBJETO",contacto), 0);
            break;
    }
    }


    public void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        //Obtengo el arraylist que he recibido del crear
        ArrayList<Contactos> objeto = ((ArrayList<Contactos>)data.getExtras().get("OBJETO"));
        //Asigno ese arraylista al de la clase this
        Toast.makeText(MainActivity.this, objeto.get(0).getNombre(), Toast.LENGTH_SHORT).show();
        contacto = objeto;

    }



}
