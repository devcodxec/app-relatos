package com.proyecto.apprelatos.actividades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import com.bumptech.glide.Glide;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.proyecto.apprelatos.R;
import com.proyecto.apprelatos.dialogos.IdiomaDialogFragment;

public class DescripcionActivity extends Activity {

    //Variable para revisar el log
    private static final String LOG_APP = "APP_RELATOS";

    IdiomaDialogFragment idiomaDialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.descripcion);

        TextView titulo= (TextView)findViewById(R.id.DesTituloRelato);
        TextView descripcion= (TextView)findViewById(R.id.DesRelato);
        ImageView fotoRelato= (ImageView)findViewById(R.id.DesImgRelato);

        descripcion.setMovementMethod(new ScrollingMovementMethod());

        Intent intent = getIntent();
        Bundle bundleDatosRest= intent.getExtras();

        if(bundleDatosRest!=null){
            titulo.setText(bundleDatosRest.getString("tituloRelato"));
            descripcion.setText(bundleDatosRest.getString("descripcionRelato"));
            FirebaseStorage firebaseStorage =  FirebaseStorage.getInstance();
            StorageReference storageReference = firebaseStorage.getReferenceFromUrl(bundleDatosRest.getString("imagenRelato"));
            Glide.with(DescripcionActivity.this).load(storageReference).into(fotoRelato);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Idioma:
                idiomaDialogFragment = new IdiomaDialogFragment();
                idiomaDialogFragment.show(getFragmentManager(),"Idioma");
                return true;
            case R.id.Salir:
                super.onBackPressed(); finishAffinity(); System.exit(0);
                return true;
            case R.id.About:
                //startActivity(new Intent(this, AboutActivity.class));
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
