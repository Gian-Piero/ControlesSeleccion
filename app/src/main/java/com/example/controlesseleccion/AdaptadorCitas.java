package com.example.controlesseleccion;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class AdaptadorCitas extends ArrayAdapter <Cita> {

    private Cita citas[];

    public AdaptadorCitas(@NonNull Context context, Cita[] citas)
    {
        super(context, R.layout.cita_item, citas);
        this.citas = citas;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.cita_item, null);

        TextView tvHospitalCiudad = (TextView)item.findViewById(R.id.textCiudadHospital);
        tvHospitalCiudad.setText(citas[position].getHospital() + ", "  + citas[position].getCiudad());

        TextView tvNombreApellido = (TextView)item.findViewById(R.id.textNombreCompleto);
        tvNombreApellido.setText(citas[position].getNombre() + " " + citas[position].getApellido());

        ImageView imagen = item.findViewById(R.id.imageWebCita);
        imagen.setImageResource(citas[position].getImagen());

        TextView tvHora = (TextView)item.findViewById(R.id.textHora);
        tvHora.setText("Hora: " + citas[position].getHoraElegida());

        return (item);
    }
}
