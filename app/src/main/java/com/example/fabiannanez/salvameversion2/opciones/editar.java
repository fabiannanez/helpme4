package com.example.fabiannanez.salvameversion2.opciones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.fabiannanez.salvameversion2.R;

import java.util.ArrayList;
import java.util.Arrays;

public class Editar extends AppCompatActivity {

    Button guardar_edit;
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;
    private EditText Nombre;
    private EditText Numero;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        ListView lista=(ListView)findViewById(R.id.listvE);
        String[] items={"Personas Agregadas"};

        arrayList=new ArrayList<>(Arrays.asList(items));
        adapter= new ArrayAdapter<>(this, R.layout.list_item, R.id.txtitem, arrayList);
        assert lista != null;
        lista.setAdapter(adapter);

        Nombre=(EditText)findViewById(R.id.edt_nombre);
        Numero=(EditText)findViewById(R.id.edt_numero);


        guardar_edit = (Button)findViewById(R.id.btn_editar);
        guardar_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newItem=Nombre.getText().toString();
                String newItem1=Numero.getText().toString();
                arrayList.add(newItem);
                arrayList.add(newItem1);
                Toast.makeText(Editar.this, "SALVADOR EDITADO", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
