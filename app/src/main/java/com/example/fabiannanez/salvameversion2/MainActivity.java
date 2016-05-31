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
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.example.fabiannanez.salvameversion2.opciones.Audio;
import com.example.fabiannanez.salvameversion2.opciones.Config;

public class MainActivity extends AppCompatActivity {

    TextView info;
    Button grabar;
    Button enviarmsm;
    EditText txtPhone;
    EditText txtMsm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        info = (TextView) findViewById(R.id.info);
        grabar = (Button) findViewById(R.id.audio);
        enviarmsm = (Button) findViewById(R.id.ayuda);

        grabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent audio = new Intent(getApplicationContext(), Audio.class);
                startActivities(new Intent[]{audio});
            }
        });

       enviarmsm.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
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
