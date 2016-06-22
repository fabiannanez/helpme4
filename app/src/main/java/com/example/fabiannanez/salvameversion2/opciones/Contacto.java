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
import android.widget.EditText;
import android.widget.Toast;

import com.example.fabiannanez.salvameversion2.R;

public class Contacto extends AppCompatActivity {

    EditText num;
    EditText txtMsm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        num = (EditText) findViewById(R.id.num);
        txtMsm = (EditText) findViewById(R.id.text_msm);

        //mostrar los datos persistentes numero

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        num.setText(prefs.getString("num", "-1"));

        //mostrar los datos persistentes mensaje
        SharedPreferences prefes=getPreferences(MODE_PRIVATE);
        txtMsm.setText(prefes.getString("mensaje","No encontrado"));



    }
///guardar num
       public void guardar(View view) {

          SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
          editor.putString("num",num.getText().toString());
          editor.apply();

           Toast.makeText(Contacto.this,"Guardado",Toast.LENGTH_LONG).show();
       }
/// guardar mensaje
    public void guardarm (View view){
        SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
        editor.putString("mensaje",txtMsm.getText().toString());
        editor.commit();
        Toast.makeText(Contacto.this,"Guardado",Toast.LENGTH_LONG).show();
    }


    public void enviarmsm(View view) {
        PendingIntent sentIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, new Intent("SMS_SENT"), 0);

        registerReceiver(new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {
                switch (getResultCode()) {

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
        if (num.getText().toString().length() > 0
                && txtMsm.getText().toString().length() > 0) {
            sms.sendTextMessage(num.getText().toString(), null,
                    txtMsm.getText().toString(), sentIntent, null);
        } else {
            Toast.makeText(getApplicationContext(),
                    "No se puede enviar, los datos son incorrectos",
                    Toast.LENGTH_SHORT).show();
        }


    }
}

