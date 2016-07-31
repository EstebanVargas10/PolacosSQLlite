package com.example.esteban.labsqlitev01;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity implements View.OnClickListener{

    Button buttonCliente;
    Button buttonProducto;
    Button buttonSalir;
    Button buttonFactura;
    Button Invisible;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        incializaPantalla();
    }


    private void incializaPantalla() {

        buttonCliente = (Button) findViewById(R.id.button_Cliente);
        buttonProducto = (Button) findViewById(R.id.button_Producto);
        buttonSalir = (Button) findViewById(R.id.button_Salir);
        buttonFactura  = (Button) findViewById(R.id.button_Factura);
        Invisible = (Button) findViewById(R.id.button_invisible);

        buttonCliente.setOnClickListener(this);
        buttonProducto.setOnClickListener(this);
        buttonSalir.setOnClickListener(this);
        buttonFactura.setOnClickListener(this);
        Invisible.setOnClickListener(this);
    }

    @Override
    public void onClick (View v) {
        switch (v.getId()){
        case R.id.button_Cliente:
            startActivity(new Intent(MainActivity.this, Clientes_Activity.class));
            break;


            case R.id.button_Producto:
                startActivity(new Intent(MainActivity.this, producto_Activity.class));
                break;


            case R.id.button_Factura:
                startActivity(new Intent(MainActivity.this, facturas_Activity.class));
                break;

            case R.id.button_invisible:
                startActivity(new Intent(MainActivity.this, EasterEgg_Class.class));
                break;

            case R.id.button_Salir:
                Intent elIntent = new Intent(Intent.ACTION_MAIN);
                elIntent.addCategory(Intent.CATEGORY_HOME);
                elIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(elIntent);
                break;

        }
    }


}
