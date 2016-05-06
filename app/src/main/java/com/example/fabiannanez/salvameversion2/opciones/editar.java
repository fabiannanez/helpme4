package com.example.fabiannanez.salvameversion2.opciones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.fabiannanez.salvameversion2.R;

public class Editar extends AppCompatActivity {

    Button guardar_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        guardar_edit = (Button)findViewById(R.id.btn_editar);
        guardar_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Editar.this, "SALVADOR EDITADO", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
