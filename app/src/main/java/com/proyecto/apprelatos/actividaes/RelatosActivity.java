package com.proyecto.apprelatos.actividaes;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.proyecto.apprelatos.R;
import com.proyecto.apprelatos.modelo.AdaptadorRelato;
import com.proyecto.apprelatos.modelo.Relato;

import java.util.ArrayList;

public class RelatosActivity  extends AppCompatActivity {

    //Variable para revisar el log
    private static final String LOG_APP = "APP_RELATOS";

    FirebaseFirestore database = FirebaseFirestore.getInstance();

    //Variables para el uso del Adaptador

    AdaptadorRelato adaptadorRelato;

    //Variable de tipo ListView para asignar el adaptador
    ListView lstViewRelatos;
    ArrayList<Relato> listaRelatos;

    Relato relato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relatos);

        lstViewRelatos = (ListView)findViewById(R.id.lstRelatos);
        listaRelatos= new ArrayList<Relato>();
        obtenerDatosFirebaseES();

    }
    public void obtenerDatosFirebaseES(){

        database.collection("relatos").whereEqualTo("idioma","ES").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){

                    for(QueryDocumentSnapshot qds: task.getResult()) {
                        String titulo = qds.getString("titulo");
                        String descripcion = qds.getString("descripcion");
                        String imagen = qds.getString("imagen");

                        Log.i(LOG_APP, "**TITULO: " + titulo);
                        Log.i(LOG_APP, "**DESCRIPCION: " + descripcion);
                        Log.i(LOG_APP, "**IMAGEN: " + imagen);

                        relato = new Relato();
                        relato.setTitulo(titulo);
                        relato.setDescripcion(descripcion);
                        relato.setImagen(imagen);
                        listaRelatos.add(relato);

                        adaptadorRelato = new AdaptadorRelato(RelatosActivity.this, R.layout.formatorelatos, listaRelatos);
                        Log.i(LOG_APP, "**TAMAÑO LISTA: " +listaRelatos.size());
                        lstViewRelatos.setAdapter(adaptadorRelato);
                    }
                }
                else{
                    Log.i(LOG_APP, "Error getting documents: " ,task.getException());
                }
            }
        });
    }

    public void obtenerDatosFirebaseEN(){

        database.collection("relatos").whereEqualTo("idioma","EN").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){

                    for(QueryDocumentSnapshot qds: task.getResult()) {
                        String titulo = qds.getString("titulo");
                        String descripcion = qds.getString("descripcion");
                        String imagen = qds.getString("imagen");

                        Log.i(LOG_APP, "**TITULO!!!!!!!!!!: " + titulo);
                        Log.i(LOG_APP, "**DESCRIPCION!!!!!!!!!!: " + descripcion);
                        Log.i(LOG_APP, "**IMAGEN!!!!!!!!!!: " + imagen);
                        relato = new Relato();
                        relato.setTitulo(titulo);
                        relato.setDescripcion(descripcion);
                        relato.setImagen(imagen);
                        listaRelatos.add(relato);

                        adaptadorRelato = new AdaptadorRelato(RelatosActivity.this, R.layout.formatorelatos, listaRelatos);
                        Log.i(LOG_APP, "**TAMAÑO FINAL!!!!!!!!!: " +listaRelatos.size());
                        lstViewRelatos.setAdapter(adaptadorRelato);

                    }
                }
                else{
                    Log.i(LOG_APP, "Error getting documents: " ,task.getException());
                }

            }
        });

    }
}
