package com.example.fabiannanez.salvameversion2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class editar extends AppCompatActivity {

    Button guardar_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msm);

        guardar_edit = (Button) findViewById(R.id.enviar);

        guardar_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(editar.this, "SALVADOR EDITADO", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
