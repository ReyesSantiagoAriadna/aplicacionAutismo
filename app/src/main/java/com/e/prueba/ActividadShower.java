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

public class ActividadShower extends AppCompatActivity implements View.OnClickListener{
    SharedPreferences sharedPreferences;
    private SoundPool soundPool;
    private CardView cardView1,cardView2,cardView3,cardView4,cardView5,cardView6,
            cardView7,cardView8,cardView9;
    private int song1=0,song2=0,song3,song4,song5,song6,song7,song8,song9;


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


        setContentView(R.layout.activity_actividad_shower);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null)
            actionBar.setDisplayHomeAsUpEnabled(true);
        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC,1);


        song1 =soundPool.load(this,R.raw.quitarropashower,1);
        song2 = soundPool.load(this,R.raw.colocarbajoshower,1);
        song3 = soundPool.load(this,R.raw.tomarshamshower,1);
        song4 =soundPool.load(this,R.raw.frotarshamshower,1);
        song5 = soundPool.load(this,R.raw.frotarjabonshower,1);
        song6 = soundPool.load(this,R.raw.enjuagarsebajoshower,1);
        song7 =soundPool.load(this,R.raw.shower,1);
        song8 = soundPool.load(this,R.raw.vestirseshower,1);
        song9 = soundPool.load(this,R.raw.peinarse,1);

        cardView1 = (CardView)findViewById(R.id.desnudarse);
        cardView2 = (CardView)findViewById(R.id.caerAgua);
        cardView3= (CardView)findViewById(R.id.tomarChan);
        cardView4 = (CardView)findViewById(R.id.lavarCabello);
        cardView5 = (CardView)findViewById(R.id.enjabonar);
        cardView6 = (CardView)findViewById(R.id.enjuagarCuerpo);
        cardView7= (CardView)findViewById(R.id.secarse);
        cardView8 = (CardView)findViewById(R.id.vestirse);
        cardView9 = (CardView)findViewById(R.id.peinarse);

        cardView1.setOnClickListener(this);
        cardView2.setOnClickListener(this);
        cardView3.setOnClickListener(this);
        cardView4.setOnClickListener(this);
        cardView5.setOnClickListener(this);
        cardView6.setOnClickListener(this);
        cardView7.setOnClickListener(this);
        cardView8.setOnClickListener(this);
        cardView9.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.desnudarse:
                soundPool.play(song1,1,1,1,0,1);
                break;
            case R.id.caerAgua:
                soundPool.play(song2,1,1,1,0,1);
                break;
            case R.id.tomarChan:
                soundPool.play(song3,1,1,1,0,1);
                break;
            case R.id.lavarCabello:
                soundPool.play(song4,1,1,1,0,1);
                break;
            case R.id.enjabonar:
                soundPool.play(song5,1,1,1,0,1);
                break;
            case R.id.enjuagarCuerpo:
                soundPool.play(song6,1,1,1,0,1);
                break;
            case R.id.secarse:
                soundPool.play(song7,1,1,1,0,1);
                break;
            case R.id.vestirse:
                soundPool.play(song8,1,1,1,0,1);
                break;
            case R.id.peinarse:
                soundPool.play(song9,1,1,1,0,1);
                break;
        }
    }
}
