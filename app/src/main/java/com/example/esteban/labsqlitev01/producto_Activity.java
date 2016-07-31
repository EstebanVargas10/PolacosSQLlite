package com.example.esteban.labsqlitev01;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class producto_Activity extends Activity implements View.OnClickListener  {

    EditText NombreTxt;
    EditText PrecioTxt;
    Button GuardaBtn;
    Button ConsultarBtn;
    ListView listaProductos;


    private ControlDatos_Class ControlDatosClass = new ControlDatos_Class(this);
    private Util_TextoFechas UtileStrings = new Util_TextoFechas();
    private Util_UI UtilesUI = new Util_UI();



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);
        incializaPantalla();
    }


    private void incializaPantalla() {

        NombreTxt = (EditText) findViewById(R.id.txt_Nombre);
        PrecioTxt = (EditText) findViewById(R.id.txt_precio);
        GuardaBtn = (Button) findViewById(R.id.button_Guardar);
        ConsultarBtn = (Button) findViewById(R.id.button_Consultar);
        listaProductos = (ListView)findViewById(R.id.listView_Productos);


        GuardaBtn.setOnClickListener(this);
        ConsultarBtn.setOnClickListener(this);

    }


    private void ListViewClick(){
        listaProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int laPosicion = position + 1;
                String elementoSeleccionado = (String) listaProductos.getItemAtPosition(position);
                String[] TextoPartido = UtileStrings.CortaTextos(elementoSeleccionado, ",");
                NombreTxt.setText(TextoPartido[1]);
                PrecioTxt.setText(TextoPartido[0]);
            }
        });//End setOnItemClickListener
    }//Fin ListViewClick


    @Override
    public void onClick (View v) {
        switch (v.getId()){
            case R.id.button_Guardar:
                ControlDatosClass.GuardaProducto(NombreTxt.getText().toString(),PrecioTxt.getText().toString());
                NombreTxt.setText(" ");
                PrecioTxt.setText(" ");
                break;

            case R.id.button_Consultar:
                listaProductos.setAdapter(UtilesUI.CargaArrayAdapter(this,ControlDatosClass.ConsultaProductos()));
                break;

        }
    }


}


