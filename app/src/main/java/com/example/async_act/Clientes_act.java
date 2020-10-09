package com.example.async_act;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import Clases.Planes;

public class Clientes_act extends AppCompatActivity {

    private Spinner spin1, spin2;
    private EditText edit;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes_act);

        spin1 = (Spinner)findViewById(R.id.spnClientes);
        spin2 = (Spinner)findViewById(R.id.spnPlanes);
        edit = (EditText)findViewById(R.id.et1);
        text = (TextView)findViewById(R.id.tv);


        ArrayList<String> listaClientes = (ArrayList<String>) getIntent().getSerializableExtra("listaClientes");
        ArrayList<String> listaPlanes = (ArrayList<String>) getIntent().getSerializableExtra("listaPlanes");


        ArrayAdapter<String> adapt = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaClientes);
        ArrayAdapter<String> adapts = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaPlanes);

        spin1.setAdapter(adapt);
        spin2.setAdapter(adapts);
    }

    public void Calcular(View v)
    {
        Planes pl = new Planes(); //Construir mi objeto
        pl.setXtreme(80000);

        String cliente = spin1.getSelectedItem().toString();  //Almaceno seleccion del spinner
        String planes = spin2.getSelectedItem().toString();

        int saldo = Integer.parseInt(edit.getText().toString());  // Obtengo dato de entrada

        int resultXtreme = pl.getXtreme() - saldo;  // Realizo operacion

        //Inteligencia Roberto
        if (cliente.equals("Roberto") && planes.equals("Xtreme"))
        {
            //Mostrar precio plan
            text.setText("El precio del plan es: " + resultXtreme);
        }

        if (cliente.equals("Ivan") && planes.equals("MindFullness"))
        {
            text.setText("El precio del plan es: " + pl.getMindfullness());
        }

        //Inteligencia Ivan
        if (cliente.equals("Roberto") && planes.equals("Xtreme"))
        {
            //Mostrar precio plan
            text.setText("El precio del plan es: " + resultXtreme);
        }

        if (cliente.equals("Ivan") && planes.equals("MindFullness"))
        {
            text.setText("El precio del plan es: " + pl.getMindfullness());
        }
    }
}