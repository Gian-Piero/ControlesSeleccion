package com.example.controlesseleccion;

import android.widget.TextView;

import java.io.Serializable;

public class Cita  implements Serializable {

    private String horaElegida;
    private String nombre;
    private String apellido;
    private String ciudad;
    private String hospital;
    private int imagen;

    public Cita(String nombre, String apellido, String ciudad, String hospital, String horaElegida, int imagen)  {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
        this.hospital = hospital;
        this.horaElegida = horaElegida;
        this.imagen=imagen;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }



    public String getCiudad(){
        return ciudad;
    }

    public void setCiudad(String ciudad){
        this.ciudad = ciudad;
    }

    public String getHospital(){
        return hospital;
    }

    public void setHospital(String hospital){
        this.ciudad = hospital;
    }



    public String getHoraElegida(){
        return horaElegida;
    }

    public void setHoraElegida(String horaElegida){
        this.horaElegida = horaElegida;
    }

    public void setImagen(int imagen){
        this.imagen = imagen;
    }

    public int getImagen(){
        return  imagen;
    }

}
