package com.proyecto.apprelatos.actividaes;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.proyecto.apprelatos.R;

public class RelatosActivity  extends AppCompatActivity {

    //Variable para revisar el log
    private static final String LOG_APP = "APP_RELATOS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relatos);
    }


}
