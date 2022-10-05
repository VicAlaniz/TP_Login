package com.mva.tp_login.ui;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.mva.tp_login.model.Usuario;
import com.mva.tp_login.request.ApiClient;

public class MainActivityViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<String> texto;

    public MainActivityViewModel(Application application) {
        super(application);
        context = application.getApplicationContext();
    }

    public LiveData<String> getTexto(){
        if (texto == null) {
            texto = new MutableLiveData<>();
        }
        return texto;
    }

    public void cargarBienvenida(){
        Usuario user = ApiClient.leer(context);
        String bienvenida = "Bienvenido " + user.getNombre() + " " + user.getApellido();
        texto.setValue(bienvenida);
    }
}
