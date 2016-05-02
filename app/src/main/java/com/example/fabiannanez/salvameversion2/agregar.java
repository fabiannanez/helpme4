package com.example.fabiannanez.salvameversion2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class agregar extends AppCompatActivity {

    ImageButton agregado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        agregado = (ImageButton)findViewById(R.id.btn_guadar_agregar);
        agregado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(agregar.this, "SALVADOR AGREGADO", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
