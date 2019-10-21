package com.example.controlesseleccion;


public class Webs {
    private int ID;
    private String url;
    private String nombre;
    private int imagen;

    public Webs(int ID, String nombre, String url, int imagen) {
        this.ID = ID;
        this.url = url;
        this.imagen = imagen;
        this.nombre = nombre;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public int getImage() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getID(){
        return ID;
    }
}
