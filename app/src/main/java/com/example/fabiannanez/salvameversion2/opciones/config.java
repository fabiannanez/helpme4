package com.example.fabiannanez.salvameversion2.opciones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fabiannanez.salvameversion2.R;

public class Config extends AppCompatActivity {

    Button salvador,mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        salvador = (Button) findViewById(R.id.salvador);
        mensaje = (Button) findViewById(R.id.pre_texto);

        salvador.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                Intent sal = new Intent(getApplicationContext(), Agregar.class);
                startActivities(new Intent[]{sal});
            }
         });
                mensaje.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent audio = new Intent(getApplicationContext(), Audio.class);
                        startActivities(new Intent[]{audio});
                    }
                });
}
}