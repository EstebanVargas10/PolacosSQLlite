package com.example.esteban.labsqlitev01;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Util_TextoFechas {

    public Util_TextoFechas(){}//Constructor de la clase

    public String[] CortaTextos(String elTexto, String elCaracter){
        String[] partes = elTexto.split(elCaracter);
        return partes;
    }//Fin CortaTextos =======================

    public String ObtieneFecha(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }//Fin ObtieneFecha =======================


}//Fin Util_TextoFechas =======================
