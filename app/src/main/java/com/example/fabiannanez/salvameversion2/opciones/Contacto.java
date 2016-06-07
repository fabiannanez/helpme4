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

public class Contacto extends AppCompatActivity {


    private String telefono;

    EditText num;
    Button btnguardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        num = (EditText) findViewById(R.id.num);
        btnguardar = (Button) findViewById(R.id.guardarnum);

        //mostrar los datos persistentes

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        num.setText(prefs.getString("num", "-1"));


    }

       public void guardar(View view) {

          SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
          editor.putString("num",num.getText().toString());
          editor.commit();

           Toast.makeText(Contacto.this,"Guardado",Toast.LENGTH_LONG).show();
       }

}

