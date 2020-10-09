package com.example.async_act;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progress;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progress = (ProgressBar)findViewById(R.id.pb);
        button = (Button)findViewById(R.id.bt);

        progress.setVisibility(View.INVISIBLE); // Hacemos invisible el progress bar

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                new Task().execute();  // Ejecutar mi tarea asincrona
            }
        });
    }

    //Tarea Asincrona
    class Task extends AsyncTask<String, Void, String> {

        @Override // Configuracion inicial de mi tarea
        protected void onPreExecute()
        {
            progress.setVisibility(View.VISIBLE); // La barra aparece
        }

        @Override // Procesa mi tarea pesada
        protected String doInBackground(String... strings)
        {
            for (int i = 1; i <= 10; i++)
            {
                try
                {
                  Thread.sleep(1000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override // Al finalizar mi tarea pesada
        protected void onPostExecute(String s)
        {
            progress.setVisibility(View.INVISIBLE);
            Intent i = new Intent(getBaseContext(), Menu_act.class);
            startActivity(i);
        }

    }

}