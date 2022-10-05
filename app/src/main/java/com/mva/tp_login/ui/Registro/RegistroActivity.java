package com.mva.tp_login.ui.Registro;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.mva.tp_login.R;
import com.mva.tp_login.model.Usuario;

public class RegistroActivity extends AppCompatActivity {

    private RegistroViewModel registro;
    private EditText etDniRegistro,etApellidoRegistro,etNombreRegistro,etCorreoRegistro,etPasswordRegistro;
    private Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        registro = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(RegistroViewModel.class);

        Inicializar();
    }

    private void Inicializar()
    {
        etDniRegistro = findViewById(R.id.etDniRegistro);
        etApellidoRegistro = findViewById(R.id.etApellidoRegistro);
        etNombreRegistro = findViewById(R.id.etNombreRegistro);
        etCorreoRegistro = findViewById(R.id.etCorreoRegistro);
        etPasswordRegistro = findViewById(R.id.etPasswordRegistro);
        btnGuardar = findViewById(R.id.btnGuardarRegistro);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario user = new Usuario();

                user.setDni(Long.parseLong(etDniRegistro.getText().toString()));
                user.setApellido(etApellidoRegistro.getText().toString());
                user.setNombre(etNombreRegistro.getText().toString());
                user.setMail(etCorreoRegistro.getText().toString());
                user.setPassword(etPasswordRegistro.getText().toString());

                registro.guardarDatos(user);
            }
        });
    }
}
