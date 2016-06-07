package com.example.fabiannanez.salvameversion2;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.fabiannanez.salvameversion2.opciones.Audio;
import com.example.fabiannanez.salvameversion2.opciones.Config;

public class MainActivity extends AppCompatActivity {

    TextView info , txtPh;
    Button grabar;
    Button enviarmsm;
    EditText txtMsm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        info = (TextView) findViewById(R.id.info);
        grabar = (Button) findViewById(R.id.audio);
        enviarmsm = (Button) findViewById(R.id.ayuda);

        /*traigo o que esta guardado en el numero de cel*/
         txtPh = (TextView)findViewById(R.id.num );

        /*traigo lo que tiene mensaje*/
        txtMsm = ((EditText)findViewById(R.id.text_msm));


        grabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent audio = new Intent(getApplicationContext(), Audio.class);
                startActivities(new Intent[]{audio});
            }
        });

      enviarmsm.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

              /* PendingIntent sentIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, new Intent("SMS_SENT"), 0);

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
               if( txtPh.getText().toString().length()> 0 &&
                       txtMsm.getText().toString().length()>0 )
               {
                   sms.sendTextMessage( txtPh.getText().toString() , null, txtMsm.getText().toString() , sentIntent, null);
               }
               else
               {
                   Toast.makeText(getApplicationContext(), "No se puede enviar, los datos son incorrectos", Toast.LENGTH_SHORT).show();
               }
               /*/

               Toast.makeText(MainActivity.this, "MENSAJE ENVIADO...", Toast.LENGTH_SHORT).show();

           }
       });

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
                Intent pag = new Intent(this, Config.class);
                startActivity(pag);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
