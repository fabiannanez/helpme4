package com.example.fabiannanez.salvameversion2.opciones;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fabiannanez.salvameversion2.R;

public class Mensaje extends AppCompatActivity {

    Button enviarmsm ,btnguardar;
    EditText txtPhone;
    EditText txtMsm;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Mensaje = "emailKey";
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);

        txtPhone = ((EditText)findViewById(R.id.et_miembro_id ));
        txtMsm = ((EditText)findViewById(R.id.text_msm));
        enviarmsm = ((Button) findViewById(R.id.ayuda));

        btnguardar = ((Button) findViewById(R.id.guardar));
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


        enviarmsm.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {

                        PendingIntent sentIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, new Intent("SMS_SENT"), 0);

                        registerReceiver(new BroadcastReceiver() {

                            @Override
                            public void onReceive(Context context, Intent intent) {
                                switch (getResultCode()){
                                    case Activity.RESULT_OK:
                                        Toast.makeText(getApplicationContext(), "SMS enviado", Toast.LENGTH_SHORT).show();
                                        break;
                                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                                        Toast.makeText(getApplicationContext(), "No se pudo enviar SMS", Toast.LENGTH_SHORT).show();
                                        break;
                                    case SmsManager.RESULT_ERROR_NO_SERVICE:
                                        Toast.makeText(getApplicationContext(), "Servicio no diponible", Toast.LENGTH_SHORT).show();
                                        break;
                                    case SmsManager.RESULT_ERROR_NULL_PDU:
                                        Toast.makeText(getApplicationContext(), "PDU (Protocol Data Unit) es NULL", Toast.LENGTH_SHORT).show();
                                        break;
                                    case SmsManager.RESULT_ERROR_RADIO_OFF:
                                        Toast.makeText(getApplicationContext(), "Failed because radio was explicitly turned off", Toast.LENGTH_SHORT).show();
                                        break;
                                }
                            }
                        }, new IntentFilter("SMS_SENT"));

                        SmsManager sms = SmsManager.getDefault();
                        if( txtPhone.getText().toString().length()> 0 &&
                                txtMsm.getText().toString().length()>0 )
                        {
                            sms.sendTextMessage( txtPhone.getText().toString() , null, txtMsm.getText().toString() , sentIntent, null);
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "No se puede enviar, los datos son incorrectos", Toast.LENGTH_SHORT).show();
                        }
                    }});
    }
}

