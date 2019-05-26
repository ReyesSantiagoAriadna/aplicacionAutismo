package com.e.prueba;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class PictogramITOActivity extends AppCompatActivity {
    Toolbar toolbar;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        sharedPreferences = getSharedPreferences("VALUES", MODE_PRIVATE);
        int theme = sharedPreferences.getInt("THEME", 1);

        switch (theme){
            case 1: setTheme(R.style.AppTheme);
                break;
            case 2: setTheme(R.style.AppTheme2);
                break;
            case 3: setTheme(R.style.AppTheme3);
                break;
        }

        setContentView(R.layout.activity_pictogram_ito);
        toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        action();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.accion_ajustes) {
            Intent intent = new Intent(PictogramITOActivity.this, AjustesActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void action(){
        CardView categoriaComida =  findViewById(R.id.categoriaComida2);
        categoriaComida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PictogramITOActivity.this, CategoriaComidaActivity.class);
                startActivity(intent);

            }
        });

        CardView categoriaActiv = findViewById(R.id.categoriaActividades);
        categoriaActiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PictogramITOActivity.this, CategoriaActividadesActivity.class);
                startActivity(intent);

            }
        });

        CardView categoriaAnimales = findViewById(R.id.categoriaAnimales);
        categoriaAnimales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PictogramITOActivity.this, CategoriaAnimalesActivity.class);
                startActivity(intent);

            }
        });

        CardView categoriaUtiles = findViewById(R.id.categoriaUtiles);
        categoriaUtiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PictogramITOActivity.this, CategoriaUtilesActivity.class);
                startActivity(intent);

            }
        });

        CardView categoriaRopa = findViewById(R.id.categoriaRopa);
        categoriaRopa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PictogramITOActivity.this, CategoriaRopaActivity.class);
                startActivity(intent);

            }
        });

        CardView categoriaJuguetes = findViewById(R.id.categoriaJuguetes);
        categoriaJuguetes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PictogramITOActivity.this, CategoriaToysActivity.class);
                startActivity(intent);

            }
        });

        CardView categoriaDeportes = findViewById(R.id.categoriaDeportes);
        categoriaDeportes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PictogramITOActivity.this, CategoriaDeportesActivity.class);
                startActivity(intent);

            }
        });

        CardView categoriaEmociones = findViewById(R.id.categoriaEmociones);
        categoriaEmociones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PictogramITOActivity.this, CategoriaEmocionesActivity.class);
                startActivity(intent);

            }
        });
    }
}
