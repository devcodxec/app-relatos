package com.proyecto.apprelatos.actividades;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import com.proyecto.apprelatos.R;

public class PortadaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.portada);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(PortadaActivity.this, RelatosActivity.class);
                startActivity(intent);
                finish();

            }
        },3000);
    }
}