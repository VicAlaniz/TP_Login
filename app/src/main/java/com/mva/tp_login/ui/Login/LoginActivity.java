package com.mva.tp_login.ui.Login;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.mva.tp_login.R;
import com.mva.tp_login.request.ApiClient;

public class LoginActivity extends AppCompatActivity {

    private EditText etCorreoLogin,etPasswordLogin;
    private Button btnLogin,btnRegistrarseLogin;
    private LoginViewModel login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(LoginViewModel.class);

        Inicializar();
    }

    private void Inicializar()
    {
        etCorreoLogin = findViewById(R.id.etCorreoLogin);
        etPasswordLogin = findViewById(R.id.etContraseñaLogin);
        btnLogin = findViewById(R.id.btnIniciarSesion);
        btnRegistrarseLogin = findViewById(R.id.btnRegistrarseLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login.iniciarSesion(etCorreoLogin.getText().toString(),etPasswordLogin.getText().toString());
            }
        });

        btnRegistrarseLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                login.registrarse();
            }
        });
    }
}
