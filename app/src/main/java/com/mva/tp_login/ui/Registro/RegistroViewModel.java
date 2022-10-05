package com.mva.tp_login.ui.Registro;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.mva.tp_login.model.Usuario;
import com.mva.tp_login.request.ApiClient;

public class RegistroViewModel extends AndroidViewModel {

    private Context context;

    public RegistroViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public void guardarDatos(Usuario usuario)
    {
        try
        {
            ApiClient.guardar(context,usuario);
            Toast.makeText(context,"Usuario Guardado correctamente.",Toast.LENGTH_LONG).show();

            System.exit(0);
        }
        catch (Exception e)
        {
            Toast.makeText(context,"Usuario no se pudo guardar.",Toast.LENGTH_LONG).show();
        }

    }
}
