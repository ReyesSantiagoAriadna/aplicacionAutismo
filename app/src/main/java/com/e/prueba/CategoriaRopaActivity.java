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

public class CategoriaRopaActivity extends AppCompatActivity  implements View.OnClickListener {
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


        setContentView(R.layout.activity_categoria_ropa);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null)
            actionBar.setDisplayHomeAsUpEnabled(true);
        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC,1);


        song1 =soundPool.load(this,R.raw.tenis,1);
        song2 = soundPool.load(this,R.raw.pantalon,1);
        song3 = soundPool.load(this,R.raw.playera,1);
        song4 =soundPool.load(this,R.raw.sudadera,1);
        song5 = soundPool.load(this,R.raw.ropashorts,1);
        song6 = soundPool.load(this,R.raw.sandalias,1);
        song7 =soundPool.load(this,R.raw.zapatos,1);
        song8 = soundPool.load(this,R.raw.gorro,1);


        cardView1 = (CardView)findViewById(R.id.tenis);
        cardView2 = (CardView)findViewById(R.id.pantalon);
        cardView3= (CardView)findViewById(R.id.playera);
        cardView4 = (CardView)findViewById(R.id.sudadera);
        cardView5 = (CardView)findViewById(R.id.prendaShort);
        cardView6 = (CardView)findViewById(R.id.sandalias);
        cardView7= (CardView)findViewById(R.id.zapatos);
        cardView8 = (CardView)findViewById(R.id.gorro);


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
            case R.id.tenis:
                soundPool.play(song1,1,1,1,0,1);
                break;
            case R.id.pantalon:
                soundPool.play(song2,1,1,1,0,1);
                break;
            case R.id.playera:
                soundPool.play(song3,1,1,1,0,1);
                break;
            case R.id.sudadera:
                soundPool.play(song4,1,1,1,0,1);
                break;
            case R.id.prendaShort:
                soundPool.play(song5,1,1,1,0,1);
                break;
            case R.id.sandalias:
                soundPool.play(song6,1,1,1,0,1);
                break;
            case R.id.zapatos:
                soundPool.play(song7,1,1,1,0,1);
                break;
            case R.id.gorro:
                soundPool.play(song8,1,1,1,0,1);
                break;
        }
    }
}
