package com.e.prueba;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;


import java.util.ArrayList;

import petrov.kristiyan.colorpicker.ColorPicker;


public class AjustesActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private Button buttonColor;
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

        setContentView(R.layout.activity_ajustes);


        navigationBarStatusBar();
        setMyTheme();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null)
            actionBar.setDisplayHomeAsUpEnabled(true);

    }

    public void navigationBarStatusBar() {

        // Fix portrait issues
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            // Fix issues for KitKat setting Status Bar color primary
            if (Build.VERSION.SDK_INT >= 19) {
                TypedValue typedValue19 = new TypedValue();
                AjustesActivity.this.getTheme().resolveAttribute(R.attr.colorPrimary, typedValue19, true);
                final int color = typedValue19.data;
                FrameLayout statusBar = (FrameLayout) findViewById(R.id.statusBar);
                statusBar.setBackgroundColor(color);
            }

            // Fix issues for Lollipop, setting Status Bar color primary dark
            if (Build.VERSION.SDK_INT >= 21) {
                TypedValue typedValue21 = new TypedValue();
                AjustesActivity.this.getTheme().resolveAttribute(R.attr.colorPrimaryDark, typedValue21, true);
                final int color = typedValue21.data;
                FrameLayout statusBar = (FrameLayout) findViewById(R.id.statusBar);
                statusBar.setBackgroundColor(color);
            }
        }

        // Fix landscape issues (only Lollipop)
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            if (Build.VERSION.SDK_INT >= 19) {
                TypedValue typedValue19 = new TypedValue();
                AjustesActivity.this.getTheme().resolveAttribute(R.attr.colorPrimary, typedValue19, true);
                final int color = typedValue19.data;
                FrameLayout statusBar = (FrameLayout) findViewById(R.id.statusBar);
                statusBar.setBackgroundColor(color);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                TypedValue typedValue = new TypedValue();
                AjustesActivity.this.getTheme().resolveAttribute(R.attr.colorPrimaryDark, typedValue, true);
                final int color = typedValue.data;
                FrameLayout statusBar = (FrameLayout) findViewById(R.id.statusBar);
                statusBar.setBackgroundColor(color);
            }
        }
    }

    private void setMyTheme() {
        buttonColor = (Button) findViewById(R.id.buttonColor);
        buttonColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openColorPickker();
            }
        });
    }

    private void openColorPickker() {
        ColorPicker colorPicker = new ColorPicker(AjustesActivity.this);

        ArrayList<String> colors = new ArrayList<>();
        colors.add("#ff4040");
        colors.add("#2196f3");
        colors.add("#00b35f");

        colorPicker.setRoundColorButton(true);
        colorPicker.setColors(colors);
        colorPicker.setColumns(3);
        colorPicker.setTitle("Elija el color    ");

        colorPicker.setOnChooseColorListener(new ColorPicker.OnChooseColorListener() {
            @Override
            public void onChooseColor(int position,int color) {
                switch (position){
                    case 0:
                        sharedPreferences.edit().putInt("THEME",1).apply();
                        break;
                    case 1:
                        sharedPreferences.edit().putInt("THEME",2).apply();
                        break;
                    case 2:
                        sharedPreferences.edit().putInt("THEME",3).apply();
                        break;
                }


                Intent intent = new Intent(AjustesActivity.this, AjustesActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onCancel(){
                // put code
            }
        }).show();
    }

    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent(AjustesActivity.this, PictogramITOActivity.class);
        startActivity(intent);
    }
}
