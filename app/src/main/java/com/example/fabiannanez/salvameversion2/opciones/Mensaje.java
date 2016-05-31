package com.example.fabiannanez.salvameversion2.opciones;

import android.content.Context;
import android.content.SharedPreferences;
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

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Mensaje = "msmKey";
    SharedPreferences sharedpreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);


        txtMsm = ((EditText)findViewById(R.id.text_msm));


        btnguardar = (Button) findViewById(R.id.guardar);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);


        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msm = txtMsm.getText().toString();
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(Mensaje,msm);
                editor.commit();
                Toast.makeText(Mensaje.this,"Guardado",Toast.LENGTH_LONG).show();
            }
        });

    }
}

