package com.example.esteban.labsqlitev01;

import android.content.Context;

import java.util.ArrayList;

public class ControlDatos_Class {

        Context miContexto;
        private SQLite_Class controlDB;

        public ControlDatos_Class(Context elContexto){
            miContexto = elContexto;
            controlDB = new SQLite_Class(miContexto);
        }//Fin Constructor  =======================

        public void InsertaCliente(Clientes_Class Persona){
            controlDB.InsertaCliente(Persona);
        }//Fin InsertaCliente  =======================

        public void GuardaCliente(String elnombre, String eltelefono){
            Clientes_Class Persona = new Clientes_Class();
            Persona.telefono= eltelefono;
            Persona.nombre=elnombre;
            controlDB.InsertaCliente(Persona);
        }//Fin GuardaCliente  =======================


        public ArrayList<String> ConsultaClientes(){
            if (controlDB.CuentaFilas("Clientes") <= 0){
                GuardaCliente("Cliente Contado", "0000-0000");
            }
            return controlDB.ConsultaClientes();
        }//ConsultaClientes =======================

        public Clientes_Class BuscaClientes(int id){
            Clientes_Class elCliente = controlDB.BuscaClientes(id);
            return elCliente;
        }//ConsultaClientes =======================


    /*
    Precios
     */


    public void InsertaProducto(productos_Class Producto){
        controlDB.InsertaProducto(Producto);
    }

    public void GuardaProducto(String elnombre, String elprecio){
        productos_Class Producto = new productos_Class();
        Producto.precio= elprecio;
        Producto.nombre=elnombre;
        controlDB.InsertaProducto(Producto);
    }

    public ArrayList<String> ConsultaProductos(){
        if (controlDB.CuentaFilas("Productos") <= 0){
            GuardaProducto("Producto", "0000");
        }
        return controlDB.ConsultaProducto();
    }

    public productos_Class BuscaProducto(int id){
        productos_Class elProducto = controlDB.BuscaProducto(id);
        return elProducto;
    }


      /*
    Factura
     */


    public void InsertaFactura(facturas_Class Factura){ controlDB.InsertaFactura(Factura); }

    public void GuardaFacturas(String elcliente, String elproducto,String lacantidad, String lafecha ){
        facturas_Class Factura = new facturas_Class();
        Factura.cliente=elcliente;
        Factura.producto=elproducto;
        Factura.cantidad=lacantidad;
        Factura.fecha=lafecha;
        controlDB.InsertaFactura(Factura);

    }

    public ArrayList<String> ConsultaFactura(){
        if (controlDB.CuentaFilas("Facturas") <= 0){
            GuardaFacturas("Cliente Contado", "Producto Contado", "0", "1/1/2016");
        }
        return controlDB.ConsultaFacturas();
    }
}
