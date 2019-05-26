package com.e.prueba;

import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class ActividadLavarseCara extends AppCompatActivity implements View.OnClickListener{
    SharedPreferences sharedPreferences;
    private SoundPool soundPool;
    private CardView cardView1,cardView2,cardView3,cardView4;
    private int song1=0,song2=0,song3,song4;

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


        setContentView(R.layout.activity_actividad_lavarse_cara);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null)
            actionBar.setDisplayHomeAsUpEnabled(true);
        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC,1);


        song1 =soundPool.load(this,R.raw.abrir,1);
        song2 = soundPool.load(this,R.raw.enjuagarcara,1);
        song3 = soundPool.load(this,R.raw.cerrar,1);
        song4 =soundPool.load(this,R.raw.secarcara,1);


        cardView1 = (CardView)findViewById(R.id.abrirGrifoCara);
        cardView2 = (CardView)findViewById(R.id.enjuagarCara);
        cardView3= (CardView)findViewById(R.id.cerrarGrifoCara);
        cardView4 = (CardView)findViewById(R.id.secarCara);

        cardView1.setOnClickListener(this);
        cardView2.setOnClickListener(this);
        cardView3.setOnClickListener(this);
        cardView4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.abrirGrifoCara:
                soundPool.play(song1,1,1,1,0,1);
                break;
            case R.id.enjuagarCara:
                soundPool.play(song2,1,1,1,0,1);
                break;
            case R.id.cerrarGrifoCara:
                soundPool.play(song3,1,1,1,0,1);
                break;
            case R.id.secarCara:
                soundPool.play(song4,1,1,1,0,1);
                break;
        }
    }

}
