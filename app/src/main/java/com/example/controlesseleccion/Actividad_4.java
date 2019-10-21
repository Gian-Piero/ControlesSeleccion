package com.example.controlesseleccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class Actividad_4 extends AppCompatActivity {

    private EditText txtNombre;
    private EditText txtApellido;
    private EditText txtdni;
    private RadioGroup btnGroupCausa;
    private String causa;
    private CheckBox chckUrgente;
    private String tipoUrgencia = "";
    private ArrayList<Cita> listaCitas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_4);
        listaCitas = new ArrayList<Cita>();
        chckUrgente = findViewById(R.id.checkBoxUrgencia);
        txtNombre = findViewById(R.id.editTextNombre);
        txtApellido = findViewById(R.id.editTextApellido);
        txtdni = findViewById(R.id.editDni);
        Log.d("ajia", "el tamaño del arraylist es de :" + listaCitas.size());
    }

    public void finalizar(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void inciarCitaMedica(View view) {
        Intent intent = new Intent(this, Actividad_4_ElegirCiudad.class);


        //Causa marcada
        btnGroupCausa = findViewById(R.id.btnGroup);
        int radioButtonID = btnGroupCausa.getCheckedRadioButtonId();
        View radioButton = btnGroupCausa.findViewById(radioButtonID);
        int idx = btnGroupCausa.indexOfChild(radioButton);
        RadioButton r = (RadioButton) btnGroupCausa.getChildAt(idx);
        causa = r.getText().toString();

        if (chckUrgente.isChecked())
            tipoUrgencia = "con urgencia";

        intent.putExtra("nombre", txtNombre.getText().toString());
        intent.putExtra("apellido", txtApellido.getText().toString());
        intent.putExtra("dni", txtdni.getText().toString());
        intent.putExtra("causa", causa);
        intent.putExtra("urgente", tipoUrgencia);
        intent.putExtra("lista", listaCitas);

        startActivity(intent);
    }

    public void verCitas(View view) {

        Bundle extras = getIntent().getExtras();
        String nombre = extras.getString("nombre");
        String apellido = extras.getString("apellido");
        String ciudad = extras.getString("ciudad");
        String hospital = extras.getString("hospital");
        String horaElegida = extras.getString("hora");
        int imagen = extras.getInt("imagen");

        ArrayList <Cita> citasActuales =  (ArrayList<Cita>) extras.getSerializable("lista");
        listaCitas = citasActuales;

        Intent intent = new Intent(this, CitasLista.class);
        Cita citaActual = new Cita(nombre, apellido, ciudad, hospital, horaElegida, imagen);
        listaCitas.add(citaActual);
        intent.putExtra("listaCitas", listaCitas);
        startActivity(intent);
    }


}
