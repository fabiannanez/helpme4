package com.example.fabiannanez.salvameversion2.opciones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.example.fabiannanez.salvameversion2.R;
import java.util.ArrayList;
import java.util.Arrays;

public class Agregar extends AppCompatActivity {

    ImageButton agregado;
    private ArrayList<String> arrayList;
    private ArrayAdapter<String> adapter;
    private EditText etx_Nombre;
    private EditText etx_Numero;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        ListView listView=(ListView)findViewById(R.id.listv);
        String[] items={"Personas Agregadas"};

        arrayList=new ArrayList<>(Arrays.asList(items));
        adapter= new ArrayAdapter<>(this, R.layout.list_item, R.id.txtitem, arrayList);
        assert listView != null;
        listView.setAdapter(adapter);


        etx_Nombre=(EditText)findViewById(R.id.etx_nombre);
        etx_Numero=(EditText)findViewById(R.id.etx_numero);

        agregado = (ImageButton)findViewById(R.id.btn_agregar);
        agregado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newItem=etx_Nombre.getText().toString();
                String newItem1=etx_Numero.getText().toString();
                arrayList.add(newItem);
                arrayList.add(newItem1);
                adapter.notifyDataSetChanged();
                Toast.makeText(Agregar.this, "SALVADOR AGREGADO", Toast.LENGTH_SHORT).show();

                }
        });
    }
}
