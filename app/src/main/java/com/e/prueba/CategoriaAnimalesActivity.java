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
import android.widget.Toast;

public class CategoriaAnimalesActivity extends AppCompatActivity implements View.OnClickListener {
    SharedPreferences sharedPreferences;
    private SoundPool soundPool;
    private CardView cardViewGato,cardViewPerro,cardViewAbeja,cardViewConejo,cardViewAve,cardViewPerico,
            cardViewPinguino,cardViewTortuga;
    private int song1=0,song2=0,song3,song4,song5,song6,song7,song8;
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


        setContentView(R.layout.activity_categoria_animales);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null)
            actionBar.setDisplayHomeAsUpEnabled(true);

        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC,1);


        song1 =soundPool.load(this,R.raw.gato,1);
        song2 = soundPool.load(this,R.raw.perro,1);
        song3 = soundPool.load(this,R.raw.abeja,1);
        song4 =soundPool.load(this,R.raw.conejo,1);
        song5 = soundPool.load(this,R.raw.ave,1);
        song6 = soundPool.load(this,R.raw.perico,1);
        song7 =soundPool.load(this,R.raw.pinguino,1);
        song8 = soundPool.load(this,R.raw.tortuga,1);


        cardViewGato = (CardView)findViewById(R.id.gato);
        cardViewPerro = (CardView)findViewById(R.id.perro);
        cardViewAbeja = (CardView)findViewById(R.id.abeja);
        cardViewConejo = (CardView)findViewById(R.id.conejo);
        cardViewAve = (CardView)findViewById(R.id.ave);
        cardViewPerico = (CardView)findViewById(R.id.perico);
        cardViewPinguino = (CardView)findViewById(R.id.pinguino);
        cardViewTortuga = (CardView)findViewById(R.id.tortuga);


        cardViewGato.setOnClickListener(this);
        cardViewPerro.setOnClickListener(this);
        cardViewAbeja.setOnClickListener(this);
        cardViewConejo.setOnClickListener(this);
        cardViewAve.setOnClickListener(this);
        cardViewPerico.setOnClickListener(this);
        cardViewPinguino.setOnClickListener(this);
        cardViewTortuga.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.gato:
                soundPool.play(song1,1,1,1,0,1);
                break;
            case R.id.perro:
                soundPool.play(song2,1,1,1,0,1);
                break;
            case R.id.abeja:
                soundPool.play(song3,1,1,1,0,1);
                break;
            case R.id.conejo:
                soundPool.play(song4,1,1,1,0,1);
                break;
            case R.id.ave:
                soundPool.play(song5,1,1,1,0,1);
                break;
            case R.id.perico:
                soundPool.play(song6,1,1,1,0,1);
                break;
            case R.id.pinguino:
                soundPool.play(song7,1,1,1,0,1);
                break;
            case R.id.tortuga:
                soundPool.play(song8,1,1,1,0,1);
                break;
        }
    }
}
