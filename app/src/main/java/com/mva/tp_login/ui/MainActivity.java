package com.mva.tp_login.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import com.mva.tp_login.R;

public class MainActivity extends AppCompatActivity {
    private TextView tvBienvenida;
    private MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivityViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        mainActivityViewModel.getTexto().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tvBienvenida.setText(s);
            }

        });
        Inicializar();
    }

    private void Inicializar() {
        tvBienvenida = findViewById(R.id.tvBienvenida);
        mainActivityViewModel.cargarBienvenida();
    }
}