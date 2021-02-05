package com.proyecto.apprelatos.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;

import com.proyecto.apprelatos.R;
import com.proyecto.apprelatos.actividades.RelatosActivity;

public class IdiomaDialogFragment extends DialogFragment {

    //Variable para revisar el log
    private static final String LOG_APP = "APP_RELATOS";

    RelatosActivity relatosActivity;
    String [] idiomas= {"Español","English"};
    public static int itemSelecionado;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        relatosActivity=(RelatosActivity)getActivity();
        // Uso de la clase Builder para la construcción del diálogo
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Anadir los componentes del diálogo
        builder.setTitle(R.string.tituloDialogoIdioma);
        builder.setSingleChoiceItems(idiomas, itemSelecionado, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                itemSelecionado = item;
                Log.i(LOG_APP, "**IDIOMA SELECCIONADO: " + item);
            }
        })
        .setPositiveButton(R.string.opcionAceptarDialogoIdioma, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                if(itemSelecionado==0){
                    Log.i(LOG_APP, "**IDIOMA SELECCIONADO: ES ");
                    relatosActivity.cambiarIdiomaES();
                    relatosActivity.limpiarDatosFirebase();
                    relatosActivity.obtenerDatosFirebaseES();
                }else{
                    Log.i(LOG_APP, "**IDIOMA SELECCIONADO: EN" );
                    relatosActivity.cambiarIdiomaEN();
                    relatosActivity.limpiarDatosFirebase();
                    relatosActivity.obtenerDatosFirebaseEN();
                }
            }
        })
        .setNegativeButton(R.string.opcionCancelarDialogoIdioma, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();

            }
        });
        // Crear el objeto AlertDialog
        return builder.create();
    }
}
