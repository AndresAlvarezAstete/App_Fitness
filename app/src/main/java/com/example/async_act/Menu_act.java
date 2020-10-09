package com.example.async_act;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class Menu_act extends AppCompatActivity {

    private ViewFlipper vf;
    private int[] images = {R.drawable.a, R.drawable.b, R.drawable.c};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_act);

        vf = (ViewFlipper)findViewById(R.id.slider);

        for (int i = 0; i < images.length; i++)
        {
            flip_image(images[i]);
        }
    }

    public void flip_image(int i)
    {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);

        //Configuracion del view flipper
        vf.addView(view);    // Le añadimos las imagenes
        vf.setAutoStart(true);  // Iniciar de forma automatica
        vf.setFlipInterval(2500);  // La transicion es de 2500 seg

        //Sentido al slider
        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);

    }

    public void Info(View v)
    {
        Intent i = new Intent(this, Info_act.class);
        startActivity(i);
    }

    public void Maps(View v)
    {
        Intent i = new Intent(this, Maps_act.class);
        startActivity(i);
    }

    public void Clientes(View v)
    {
        ArrayList<String> clientes = new ArrayList<String>();
        ArrayList<String> planes = new ArrayList<String>();

        clientes.add("Roberto");
        clientes.add("Ivan");

        planes.add("Xtreme");
        planes.add("MindFullness");

        Intent i = new Intent(this, Clientes_act.class);
        i.putExtra("listaClientes", clientes); // Preparo el dato que quiero enviar
        i.putExtra("listaPlanes", planes);
        startActivity(i);

    }
}