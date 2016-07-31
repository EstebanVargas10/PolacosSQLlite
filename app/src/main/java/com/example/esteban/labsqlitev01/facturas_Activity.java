package com.example.esteban.labsqlitev01;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class facturas_Activity extends Activity implements View.OnClickListener {

    EditText cantidad;
    EditText cliente;
    EditText producto;
    EditText fecha;
    Button GuardaBtn;
    Button ConsultarBtn;
    ListView listaFacturas;

    private ControlDatos_Class ControlDatos_Class = new ControlDatos_Class(this);
    private Util_TextoFechas UtileStrings = new Util_TextoFechas();
    private Util_UI UtilesUI = new Util_UI();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facturas);
        incializaPantalla();
    }


    private void incializaPantalla() {

        cantidad = (EditText) findViewById(R.id.editText_Cantidad);
        cliente = (EditText) findViewById(R.id.editText_Cliente);
        producto = (EditText) findViewById(R.id.editText_producto);
        fecha = (EditText) findViewById(R.id.editText_Fecha);
        GuardaBtn = (Button) findViewById(R.id.button_Guardar);
        ConsultarBtn = (Button) findViewById(R.id.button_Consultar);
        listaFacturas = (ListView) findViewById(R.id.listView_Facturas);

        GuardaBtn.setOnClickListener(this);
        ConsultarBtn.setOnClickListener(this);

    }

    private void ListViewClick() {
        listaFacturas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int laPosicion = position + 1;
                String elementoSeleccionado = (String) listaFacturas.getItemAtPosition(position);
                String[] TextoPartido = UtileStrings.CortaTextos(elementoSeleccionado, ",");
                cliente.setText(TextoPartido[0]);
                producto.setText(TextoPartido[1]);
                cantidad.setText(TextoPartido[2]);
                fecha.setText(TextoPartido[3]);
            }
        });
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_Guardar:
                ControlDatos_Class.GuardaFacturas(cliente.getText().toString(),producto.getText().toString(),
                        cantidad.getText().toString(), fecha.getText().toString());
                cliente.setText("");
                producto.setText("");
                cantidad.setText("");
                fecha.setText("");
                break;
            case R.id.button_Consultar:
                listaFacturas.setAdapter(UtilesUI.CargaArrayAdapter(this, ControlDatos_Class.ConsultaFactura()));
                break;
        }
    }

}




