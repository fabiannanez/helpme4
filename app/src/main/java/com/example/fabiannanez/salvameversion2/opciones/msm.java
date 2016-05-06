package com.example.fabiannanez.salvameversion2.opciones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.fabiannanez.salvameversion2.R;

public class Msm extends AppCompatActivity {

    Button enviarmsm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msm);

       enviarmsm = (Button) findViewById(R.id.enviar);

        enviarmsm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Msm.this, "MENSAJE ENVIADO", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
