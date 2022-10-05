package com.mva.tp_login.ui.Login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.mva.tp_login.model.Usuario;
import com.mva.tp_login.request.ApiClient;
import com.mva.tp_login.ui.MainActivity;
import com.mva.tp_login.ui.Registro.RegistroActivity;

public class LoginViewModel extends AndroidViewModel {

    private Context context;

    public LoginViewModel(@NonNull Application application)
    {
        super(application);
        context = application.getApplicationContext();
    }

    public void iniciarSesion(String correo,String password)
    {
        Usuario usuario = ApiClient.login(context,correo,password);
        if ( usuario != null)
        {
            Intent i = new Intent(context, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
        else
        {
            Toast.makeText(context,"Correo o contraseña Invalida!",Toast.LENGTH_LONG).show();
        }

    }

    public void registrarse()
    {
        Intent i = new Intent(context, RegistroActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}
