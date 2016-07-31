package com.example.esteban.labsqlitev01;

public class facturas_Class {

    public String cliente;
    public String producto;
    public String cantidad;
    public String fecha;

    public facturas_Class() {
    }

    public facturas_Class(String cliente, String producto, String cantidad, String fecha) {
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
