package com.example.esteban.labsqlitev01;

public class productos_Class {



    public String nombre;
    public String precio;

    public productos_Class() {}

    public productos_Class(String nombre, String precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
