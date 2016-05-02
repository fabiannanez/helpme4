package com.example.fabiannanez.salvameversion2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class msm extends AppCompatActivity {

    Button enviarmsm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msm);

       enviarmsm = (Button) findViewById(R.id.enviar);

        enviarmsm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(msm.this, "MENSAJE ENVIADO", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
