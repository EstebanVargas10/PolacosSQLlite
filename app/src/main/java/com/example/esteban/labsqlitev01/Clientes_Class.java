package com.example.esteban.labsqlitev01;

public class Clientes_Class {


    public String nombre;
    public String telefono;

    public Clientes_Class() { }

    public Clientes_Class(String nombre_Cliente, String numero_Cliente) {
        this.nombre = nombre_Cliente;
        this.telefono = numero_Cliente;
    }

    public String getNombre_Cliente() {
        return nombre;
    }

    public void setNombre_Cliente(String nombre_Cliente) {
        this.nombre = nombre_Cliente;
    }

    public String getNumero_Cliente() {
        return telefono;
    }

    public void setNumero_Cliente(String numero_Cliente) {
        this.telefono = numero_Cliente;
    }



}
