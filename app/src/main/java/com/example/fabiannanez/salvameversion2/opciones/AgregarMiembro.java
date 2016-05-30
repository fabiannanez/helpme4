package com.example.fabiannanez.salvameversion2.opciones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fabiannanez.salvameversion2.R;

public class AgregarMiembro extends AppCompatActivity {

    EditText et;
    Button btnAgregar, read_bt;
    SQLControlador dbconeccion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregar_miembro);
        et = (EditText) findViewById(R.id.et_miembro_id);
        btnAgregar = (Button) findViewById(R.id.btnAgregarId);

        dbconeccion = new SQLControlador(this);
        dbconeccion.abrirBaseDeDatos();
        //btnAgregar.setOnClickListener((View.OnClickListener) this);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btnAgregarId:
                        String name = et.getText().toString();
                        dbconeccion.insertarDatos(name);
                        Intent main = new Intent(AgregarMiembro.this,Salvador.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(main);
                        break;

                    default:
                        break;
                }
            }
        });
    }
}