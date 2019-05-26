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

public class CategoriaUtilesActivity extends AppCompatActivity implements View.OnClickListener {
    SharedPreferences sharedPreferences;
    private SoundPool soundPool;
    private CardView cardViewLapiz,cardViewBorrador,cardViewCrayola,cardViewResistol,cardViewLibro,cardViewTijeras,
            cardViewSacapuntas,cardViewRegla;

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


        setContentView(R.layout.activity_categoria_utiles);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null)
            actionBar.setDisplayHomeAsUpEnabled(true);
        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC,1);


        song1 =soundPool.load(this,R.raw.lapiz,1);
        song2 = soundPool.load(this,R.raw.goma,1);
        song3 = soundPool.load(this,R.raw.crayones,1);
        song4 =soundPool.load(this,R.raw.pegamento,1);
        song5 = soundPool.load(this,R.raw.libro,1);
        song6 = soundPool.load(this,R.raw.tijeras,1);
        song7 =soundPool.load(this,R.raw.sacapuntas,1);
        song8 = soundPool.load(this,R.raw.regla,1);


        cardViewLapiz = (CardView)findViewById(R.id.lapiz);
        cardViewBorrador = (CardView)findViewById(R.id.goma);
        cardViewCrayola = (CardView)findViewById(R.id.crayolas);
        cardViewResistol = (CardView)findViewById(R.id.resistol);
        cardViewLibro = (CardView)findViewById(R.id.libro);
        cardViewTijeras = (CardView)findViewById(R.id.tijeras);
        cardViewSacapuntas= (CardView)findViewById(R.id.sacapuntas);
        cardViewRegla = (CardView)findViewById(R.id.regla);


        cardViewLapiz.setOnClickListener(this);
        cardViewBorrador.setOnClickListener(this);
        cardViewCrayola.setOnClickListener(this);
        cardViewResistol.setOnClickListener(this);
        cardViewLibro.setOnClickListener(this);
        cardViewTijeras.setOnClickListener(this);
        cardViewSacapuntas.setOnClickListener(this);
        cardViewRegla.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.lapiz:
                soundPool.play(song1,1,1,1,0,1);
                break;
            case R.id.goma:
                soundPool.play(song2,1,1,1,0,1);
                break;
            case R.id.crayolas:
                soundPool.play(song3,1,1,1,0,1);
                break;
            case R.id.resistol:
                soundPool.play(song4,1,1,1,0,1);
                break;
            case R.id.libro:
                soundPool.play(song5,1,1,1,0,1);
                break;
            case R.id.tijeras:
                soundPool.play(song6,1,1,1,0,1);
                break;
            case R.id.sacapuntas:
                soundPool.play(song7,1,1,1,0,1);
                break;
            case R.id.regla:
                soundPool.play(song8,1,1,1,0,1);
                break;
        }
    }
}
