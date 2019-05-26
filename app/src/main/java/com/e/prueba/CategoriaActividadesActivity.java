package com.e.prueba;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class CategoriaActividadesActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private Toolbar toolbar;
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




        setContentView(R.layout.activity_categoria_actividades);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupActionBar();

        action();
    }

    public void setupActionBar(){
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
    public void action(){
        CardView actividadLavarse =  findViewById(R.id.actividadLavarse);
        actividadLavarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoriaActividadesActivity.this, ActividadLavarseActivity.class);
                startActivity(intent);

            }
        });

        CardView actividadDientes = findViewById(R.id.actividadLavarseDientes);
        actividadDientes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(CategoriaActividadesActivity.this,Actividad_dientes.class);
                startActivity(intent);
            }
        });

        CardView avtididadCara = findViewById(R.id.actividadCara);
        avtididadCara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(CategoriaActividadesActivity.this, ActividadLavarseCara.class);
                startActivity(intent);
            }
        });

        CardView actividadBa = findViewById(R.id.actividadBShower);
        actividadBa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(CategoriaActividadesActivity.this, ActividadShower.class);
                startActivity(intent);
            }
        });
    }
}
