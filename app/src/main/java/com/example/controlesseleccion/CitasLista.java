package com.example.controlesseleccion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;


public class CitasLista extends AppCompatActivity {

    private String nombre;
    private String apellido;
    private String ciudad;
    private String hospital;
    private String horaElegida;
    private ArrayList<Cita> listaCitas2;
    private int imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas_lista);

        Bundle extras = getIntent().getExtras();
        listaCitas2 =  (ArrayList<Cita>) extras.getSerializable("listaCitas");
        cargarLista();
    }

    private void cargarLista()
    {

        int tamaño = listaCitas2.size();
        //Log.d("pruebaTamaño", tamaño + "");
        Cita citasActuales[]=new Cita[tamaño];

        int indice = 0;
        for ( ; indice<listaCitas2.size(); indice++ )
        {
            citasActuales[indice] = listaCitas2.get(indice);
        }
        //Log.d("pruebaTamaño", "el tamaño actual del arraylis es de " + listaCitas2.size() + " y el tamaño del array es de " + citasActuales.length);

        AdaptadorCitas adapter = new AdaptadorCitas(this, citasActuales);
        ListView lv = (ListView) findViewById(R.id.listaWebs);
        lv.setAdapter(adapter);

    }
}
