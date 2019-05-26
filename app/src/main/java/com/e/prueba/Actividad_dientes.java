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

public class Actividad_dientes extends AppCompatActivity implements View.OnClickListener{
    SharedPreferences sharedPreferences;
    private SoundPool soundPool;
    private CardView cardView1,cardView2,cardView3,cardView4,cardView5,cardView6,
            cardView7,cardView8;
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


        setContentView(R.layout.activity_actividad_dientes);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null)
            actionBar.setDisplayHomeAsUpEnabled(true);
        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC,1);


        song1 =soundPool.load(this,R.raw.sacarpastadientes,1);
        song2 = soundPool.load(this,R.raw.tomarcepillodientes,1);
        song3 = soundPool.load(this,R.raw.ponerpastadientes,1);
        song4 =soundPool.load(this,R.raw.colocarcepillodientes,1);
        song5 = soundPool.load(this,R.raw.llenarvasodientes,1);
        song6 = soundPool.load(this,R.raw.beberaguadientes,1);
        song7 =soundPool.load(this,R.raw.enjuagaraguadientes,1);
        song8 = soundPool.load(this,R.raw.escupirdientes,1);

        cardView1 = (CardView)findViewById(R.id.pastaDientes);
        cardView2 = (CardView)findViewById(R.id.tomarCepillo);
        cardView3= (CardView)findViewById(R.id.ponerPastaDientes);
        cardView4 = (CardView)findViewById(R.id.colocarCepillo);
        cardView5 = (CardView)findViewById(R.id.llenarVaso);
        cardView6 = (CardView)findViewById(R.id.beberAgua);
        cardView7= (CardView)findViewById(R.id.enjuagarDientes);
        cardView8 = (CardView)findViewById(R.id.escupirAgua);

        cardView1.setOnClickListener(this);
        cardView2.setOnClickListener(this);
        cardView3.setOnClickListener(this);
        cardView4.setOnClickListener(this);
        cardView5.setOnClickListener(this);
        cardView6.setOnClickListener(this);
        cardView7.setOnClickListener(this);
        cardView8.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.pastaDientes:
                soundPool.play(song1,1,1,1,0,1);
                break;
            case R.id.tomarCepillo:
                soundPool.play(song2,1,1,1,0,1);
                break;
            case R.id.ponerPastaDientes:
                soundPool.play(song3,1,1,1,0,1);
                break;
            case R.id.colocarCepillo:
                soundPool.play(song4,1,1,1,0,1);
                break;
            case R.id.llenarVaso:
                soundPool.play(song5,1,1,1,0,1);
                break;
            case R.id.beberAgua:
                soundPool.play(song6,1,1,1,0,1);
                break;
            case R.id.enjuagarDientes:
                soundPool.play(song7,1,1,1,0,1);
                break;
            case R.id.escupirAgua:
                soundPool.play(song8,1,1,1,0,1);
                break;
        }
    }
}
