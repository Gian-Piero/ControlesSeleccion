package com.example.controlesseleccion;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


public class AdaptadorWebs extends ArrayAdapter <Webs> {
    private Webs webs[];

    public AdaptadorWebs(@NonNull Context context, Webs[] webs)
    {
        super(context, R.layout.lista_item, webs);
        this.webs = webs;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lista_item, null);

        TextView tvTitulo = (TextView)item.findViewById(R.id.textCiudadHospital);
        tvTitulo.setText(webs[position].getID() + ". "  + webs[position].getNombre());

        TextView tvSubtitulo = (TextView)item.findViewById(R.id.textNombreCompleto);
        tvSubtitulo.setText(webs[position].getUrl());

        ImageView imagen = item.findViewById(R.id.imageWeb);
        imagen.setImageResource(webs[position].getImage());
        return (item);
    }


}
