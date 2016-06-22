package com.example.fabiannanez.salvameversion2;


import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.fabiannanez.salvameversion2.opciones.Audio;
import com.example.fabiannanez.salvameversion2.opciones.Contacto;
import com.example.fabiannanez.salvameversion2.opciones.Salvador;

public class MainActivity extends AppCompatActivity {

    TextView info;
    Button grabar;
    Button enviarmsm;
    EditText txtMsg, txtPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        info = (TextView) findViewById(R.id.info);
       // grabar = (Button) findViewById(R.id.audio);
        enviarmsm = (Button) findViewById(R.id.ayuda);

        /*traigo o que esta guardado en el numero de cel*/
         txtPhone = (EditText) findViewById(R.id.num );

        /*traigo lo que tiene mensaje*/
        txtMsg = ((EditText) findViewById(R.id.text_msm));


      /*  grabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent audio = new Intent(getApplicationContext(), Audio.class);
                startActivities(new Intent[]{audio});
            }
        });
        */

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                Intent pag = new Intent(this, Contacto.class);
                startActivity(pag);
                return true;
            default:
                return super.onOptionsItemSelected(item);

            case R.id.opcion2:
                Intent pag2 = new Intent(this, Salvador.class);
                startActivity(pag2);
                return true;

            case R.id.opcion3:
                Intent pag3 = new Intent(this, Audio.class);
                startActivity(pag3);
                return true;
        }
    }

    public void enviarsms(View view) {


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
        if (txtPhone.getText().toString().length() > 0
                && txtMsg.getText().toString().length() > 0) {
            sms.sendTextMessage(txtPhone.getText().toString(), null,
                    txtMsg.getText().toString(), sentIntent, null);
        } else {
            Toast.makeText(getApplicationContext(),
                    "No se puede enviar, los datos son incorrectos",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
