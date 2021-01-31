package com.proyecto.apprelatos.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import com.proyecto.apprelatos.R;
import com.proyecto.apprelatos.actividades.RelatosActivity;

public class SalirDialogFragment extends DialogFragment {

    //Variable para revisar el log
    private static final String LOG_APP = "APP_RELATOS";
    RelatosActivity relatosActivity;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        relatosActivity=(RelatosActivity)getActivity();
        // Uso de la clase Builder para la construcción del diálogo
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        // Anadir los componentes del diálogo
        builder.setTitle(R.string.tituloDialogoSalir)
                .setMessage(R.string.mensajeDialogoSalir)
                .setPositiveButton(R.string.opcionAceptarDialogoSalir, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        relatosActivity.salir();
                    }
                })
                .setNegativeButton(R.string.opcionCancelarDialogoSalir, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        // Crear el objeto AlertDialog
        return builder.create();
    }
}
