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

public class CategoriaComidaActivity extends AppCompatActivity implements View.OnClickListener {
    SharedPreferences sharedPreferences;
    private SoundPool soundPool;
    private CardView cardView1, cardView2, cardView3, cardView4, cardView5, cardView6,
            cardView7, cardView8;

    private int song1 = 0, song2 = 0, song3, song4, song5, song6, song7, song8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences("VALUES", MODE_PRIVATE);
        int theme = sharedPreferences.getInt("THEME", 1);

        switch (theme) {
            case 1:
                setTheme(R.style.AppTheme);
                break;
            case 2:
                setTheme(R.style.AppTheme2);
                break;
            case 3:
                setTheme(R.style.AppTheme3);
                break;
        }


        setContentView(R.layout.activity_categoria_comida);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true);
        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);


        song1 = soundPool.load(this, R.raw.banana, 1);
        song2 = soundPool.load(this, R.raw.durazno, 1);
        song3 = soundPool.load(this, R.raw.piniaa, 1);
        song4 = soundPool.load(this, R.raw.uva, 1);
        song5 = soundPool.load(this, R.raw.sandia, 1);
        song6 = soundPool.load(this, R.raw.coco, 1);
        song7 = soundPool.load(this, R.raw.limon, 1);
        song8 = soundPool.load(this, R.raw.fresa, 1);


        cardView1 = (CardView) findViewById(R.id.banana);
        cardView2 = (CardView) findViewById(R.id.durazno);
        cardView3 = (CardView) findViewById(R.id.pinia);
        cardView4 = (CardView) findViewById(R.id.uvas);
        cardView5 = (CardView) findViewById(R.id.sandia);
        cardView6 = (CardView) findViewById(R.id.coco);
        cardView7 = (CardView) findViewById(R.id.limon);
        cardView8 = (CardView) findViewById(R.id.fresa);


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
        switch (v.getId()) {
            case R.id.banana:
                soundPool.play(song1, 1, 1, 1, 0, 1);
                break;
            case R.id.durazno:
                soundPool.play(song2, 1, 1, 1, 0, 1);
                break;
            case R.id.pinia:
                soundPool.play(song3, 1, 1, 1, 0, 1);
                break;
            case R.id.uvas:
                soundPool.play(song4, 1, 1, 1, 0, 1);
                break;
            case R.id.sandia:
                soundPool.play(song5, 1, 1, 1, 0, 1);
                break;
            case R.id.coco:
                soundPool.play(song6, 1, 1, 1, 0, 1);
                break;
            case R.id.limon:
                soundPool.play(song7, 1, 1, 1, 0, 1);
                break;
            case R.id.fresa:
                soundPool.play(song8, 1, 1, 1, 0, 1);
                break;
        }
    }
}