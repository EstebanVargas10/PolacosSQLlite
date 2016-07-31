package com.example.esteban.labsqlitev01;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Clientes_Activity extends Activity implements View.OnClickListener {

    EditText NombreTxt;
    EditText TelefonoTxt;
    Button GuardaBtn;
    Button ConsultarBtn;
    ListView ListaClientes;


    private ControlDatos_Class ControlDatosClass = new ControlDatos_Class(this);
    private Util_TextoFechas UtileStrings = new Util_TextoFechas();
    private Util_UI UtilesUI = new Util_UI();



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);
        incializaPantalla();
    }


    private void incializaPantalla() {

        NombreTxt = (EditText) findViewById(R.id.txt_Nombre);
        TelefonoTxt = (EditText) findViewById(R.id.txt_precio);
        GuardaBtn = (Button) findViewById(R.id.button_Guardar);
        ConsultarBtn = (Button) findViewById(R.id.button_Consultar);
        ListaClientes = (ListView)findViewById(R.id.listView_Clientes);


        GuardaBtn.setOnClickListener(this);
        ConsultarBtn.setOnClickListener(this);

    }


    private void ListViewClick(){
        ListaClientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int laPosicion = position + 1;
                String elementoSeleccionado = (String) ListaClientes.getItemAtPosition(position);
                String[] TextoPartido = UtileStrings.CortaTextos(elementoSeleccionado, ",");
                NombreTxt.setText(TextoPartido[1]);
                TelefonoTxt.setText(TextoPartido[0]);
            }
        });//End setOnItemClickListener
    }//Fin ListViewClick


    @Override
    public void onClick (View v) {
        switch (v.getId()){
            case R.id.button_Guardar:
                ControlDatosClass.GuardaCliente(NombreTxt.getText().toString(),TelefonoTxt.getText().toString());
                NombreTxt.setText(" ");
                TelefonoTxt.setText(" ");
                break;

            case R.id.button_Consultar:
                ListaClientes.setAdapter(UtilesUI.CargaArrayAdapter(this,ControlDatosClass.ConsultaClientes()));
                break;
        }
    }


}


