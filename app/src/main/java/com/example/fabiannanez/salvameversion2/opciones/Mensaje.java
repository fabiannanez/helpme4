package com.example.fabiannanez.salvameversion2.opciones;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.fabiannanez.salvameversion2.R;

public class Mensaje extends AppCompatActivity {

    Button btnguardar;
    EditText txtMsm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);


        txtMsm = (EditText) findViewById(R.id.text_msm);
        btnguardar = (Button) findViewById(R.id.guardar);

        //mostrar los datos persistentes
        SharedPreferences prefs=getPreferences(MODE_PRIVATE);
        txtMsm.setText(prefs.getString("mensaje","No encontrado"));

    }

    public void guardar (View view){
        SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
         editor.putString("mensaje",txtMsm.getText().toString());
         editor.commit();
         Toast.makeText(Mensaje.this,"Guardado",Toast.LENGTH_LONG).show();
    }

}

