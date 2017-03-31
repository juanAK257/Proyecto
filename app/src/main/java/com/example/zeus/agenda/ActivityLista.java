package com.example.zeus.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;


public class ActivityLista extends AppCompatActivity {
    ArrayList<Contactos> objeto;
    int posicionlista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_lista);

        Bundle extras = getIntent().getExtras();
        objeto = (ArrayList<Contactos>)extras.get("OBJETO");


        final ListView lista = (ListView) findViewById(R.id.listView);

        registerForContextMenu(lista);

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                return false;
            }
        });

        lista.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return objeto.size();
            }

            @Override
            public Object getItem(int position) {
                return objeto.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                LayoutInflater inflater = getLayoutInflater();
                View item = inflater.inflate(R.layout.itemlista, null);

                TextView nombre = (TextView) item.findViewById(R.id.nombrelista);
                nombre.setText("Nombre: "+objeto.get(position).getNombre());
                TextView apellido = (TextView) item.findViewById(R.id.apellidolista);
                apellido.setText("Apellidos: "+objeto.get(position).getApellidos());
                TextView telefono = (TextView) item.findViewById(R.id.telefonolista);
                telefono.setText("Telefono: "+objeto.get(position).getTlfn());
                TextView email = (TextView) item.findViewById(R.id.emaillista);
                email.setText("Email: " + objeto.get(position).getEmail());

                // registerForContextMenu(item);

                return item;

            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Nose porque no funciona el evento
                Toast.makeText(ActivityLista.this, "Pulsado", Toast.LENGTH_SHORT).show();
                objeto.remove(position);
                BaseAdapter adapter = (BaseAdapter) parent.getAdapter();
                adapter.notifyDataSetChanged();

            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        getMenuInflater().inflate(R.menu.menucontext, menu);
        super.onCreateContextMenu(menu, v, menuInfo);

    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menucontext1:
                Toast.makeText(ActivityLista.this, "No se acceder desde el menu context al numero del item de la lista" +
                        "El codigo para eliminar esta en el evento de la lista", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menucontext2:
                startActivity(new Intent(getApplicationContext(), ActivityCreaContacto.class).putExtra("OBJETO", objeto));
                //No se en que linea estoy y no puedo pasarle el contacto
                finish();
                return true;
            case R.id.menucontext3:
                //Pasarle el telefono de la lista
                startActivity(new Intent(Intent.ACTION_DIAL));
                return true;
            case R.id.menucontext4:
                startActivity(Intent.createChooser(new Intent(android.content.Intent.ACTION_SEND)
                        , "Elija Gestor de correo electronico"));

                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }


}
