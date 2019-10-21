package com.example.controlesseleccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private HashMap<String, String> mapaPaises;
    private Spinner spinerPaises;
    private TextView txtInformacionPais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_1);
        txtInformacionPais = findViewById(R.id.textInformacionPais);
        cargarMapa();
        cargarSpinner();

    }

    private void cargarMapa(){
        mapaPaises = new HashMap<String, String>();
        mapaPaises.put("Rusia","17 100 000 km²,146 823 000" );
        mapaPaises.put("China","9 600 000 km²,1 380 996 000");
        mapaPaises.put("India","3 290 000 km²,1 331 793 000");
        mapaPaises.put("Estados Unidos","9 160 000 km²,325 318 000");
        mapaPaises.put("Brasil","8 515 000 km²,207 012 000");
        mapaPaises.put("Pakistán","799 400 km²,201 576 000");
    }


    private void cargarSpinner() {
        spinerPaises = findViewById(R.id.spinnerPaises);

        final String[] ciudades = new String[] {"Rusia","China","India","Estados Unidos","Brasil","Pakistán"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ciudades);
        spinerPaises.setAdapter(adapter);
        spinerPaises.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView tvMensaje = (TextView) view;
                cargarInformacionPais(tvMensaje.getText().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void cargarInformacionPais(String pais){
        String [] informacion = mapaPaises.get(pais).split(",");
        txtInformacionPais.setText("Habitantes : " + informacion[1] + "\nsuperficie : " + informacion[0]);
    }

    public void actividad2(View view) {
        Intent intent = new Intent(this, actividad_2.class);
        startActivity(intent);
    }
}
