package com.example.fabiannanez.salvameversion2.opciones;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.example.fabiannanez.salvameversion2.MainActivity;
import com.example.fabiannanez.salvameversion2.R;

public class SplashScreem extends AppCompatActivity {

    public static final int segundos=2;
    public static final int milisegundos=segundos*1000;
    private ProgressBar progressBar;
    public static final int delay=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screem);
        progressBar= (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setMax(maximoprogreso());
        empezaranimacion();

    }

    private void empezaranimacion() {
        new CountDownTimer(milisegundos, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
               progressBar.setProgress(establecer_progreso(millisUntilFinished));
            }

            @Override
            public void onFinish() {
                Intent nuevofrom=new Intent(SplashScreem.this,MainActivity.class);
                startActivity(nuevofrom);
                finish();
            }
        }.start();
    }

    public int establecer_progreso(long miliseconds){

        return (int)((milisegundos-miliseconds)/1000);
    }

    public int maximoprogreso() {
        return segundos-delay;
    }
}
