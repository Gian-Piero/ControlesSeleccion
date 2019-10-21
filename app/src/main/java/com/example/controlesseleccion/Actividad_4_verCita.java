package com.example.controlesseleccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class Actividad_4_verCita extends AppCompatActivity {

    private String horaElegida = "";
    private String nombre;
    private String apellido;
    private String dni;
    private String causa;
    private String urgencia;
    private String ciudad;
    private String hospital;

    private TextView txtTitulo;
    private TextView txtNombreCompleto;
    private TextView txtInfoCita;
    private ArrayList<Cita> listaCitas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_4_ver_cita);

        //Recupero datos
        Bundle extras = getIntent().getExtras();
        nombre = extras.getString("nombre");
        apellido = extras.getString("apellido");
        dni = extras.getString("dni");
        causa = extras.getString("causa");
        urgencia = extras.getString("urgente");
        horaElegida = extras.getString("hora");
        ciudad = extras.getString("ciudad");
        hospital = extras.getString("hospital");
        listaCitas =  (ArrayList<Cita>) extras.getSerializable("lista");

        txtTitulo = findViewById(R.id.textViewHoraCiudad);
        txtNombreCompleto = findViewById(R.id.textViewNombreApellido);
        txtInfoCita = findViewById(R.id.textViewInfoCita);

        txtTitulo.setText("Cita medica en " + ciudad + " en el hospital " + hospital + " :");
        txtNombreCompleto.setText("Para el paciente " + nombre.toUpperCase() + " " + apellido.toUpperCase() + " con el dni " + dni.toUpperCase());
        txtInfoCita.setText("A las " + horaElegida + " para el tratamiento de " + causa + " " + urgencia);

    }

    public void volverInicio(View view) {
        Intent intent = new Intent(this, Actividad_4.class);
        intent.putExtra("nombre", nombre);
        intent.putExtra("apellido",apellido);
        intent.putExtra("ciudad", ciudad);
        intent.putExtra("hospital", hospital);
        intent.putExtra("hora", horaElegida);
        String strNombreImg = null;
        if (ciudad.equals("Bilbao"))
            strNombreImg = "bilbao";
        if (ciudad.equals("Vitoria-Gasteiz"))
            strNombreImg = "vitoria";
        if (ciudad.equals("San Sebastian"))
            strNombreImg = "sansebastian";

        int imagen = getResources().getIdentifier(strNombreImg, "drawable", getPackageName());

        intent.putExtra("imagen", imagen);
        intent.putExtra("lista", listaCitas);
        startActivity(intent);
    }
}
