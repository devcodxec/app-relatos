package com.proyecto.apprelatos.modelo;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.proyecto.apprelatos.R;

import java.util.ArrayList;

public class AdaptadorRelato extends ArrayAdapter<Relato> {

    private static final String LOG_APP="APP_RELATOS";
    private static LayoutInflater inflater=null;
    private int resourcelayout;
    Activity activity;
    ArrayList<Relato> listaRelatos;


    public AdaptadorRelato(Activity activity, int resourcelayout, ArrayList<Relato> listaRelatos){
        super(activity,resourcelayout, listaRelatos);
        this.activity = activity;
        this.resourcelayout= resourcelayout;
        this.listaRelatos= listaRelatos;
        inflater=(LayoutInflater)activity.getSystemService(activity.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final View vista = inflater.inflate(R.layout.formatorelatos, null);

        final TextView titulo = (TextView) vista.findViewById(R.id.txtTituloRelato);

        final Relato relato = (Relato) getItem(position);

        titulo.setText(relato.getTitulo());

        Log.i(LOG_APP, "**IMAGEN FINAL: " +relato.getImagen());

        return vista;

    }

}
