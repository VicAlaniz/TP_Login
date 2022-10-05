package com.mva.tp_login.request;

import android.content.Context;
import android.content.SharedPreferences;

import com.mva.tp_login.model.Usuario;

public class ApiClient {
    private static SharedPreferences sharedP;

    private static SharedPreferences conectar(Context context) {
        if(sharedP == null) {
            sharedP = context.getSharedPreferences("datos", 0);
        }
        return sharedP;
    }

    public static void guardar(Context context, Usuario usuario) {
        SharedPreferences sp = conectar(context);

        SharedPreferences.Editor editor = sp.edit();
        editor.putLong("dni", usuario.getDni());
        editor.putString("apellido", usuario.getApellido());
        editor.putString("nombre", usuario.getNombre());
        editor.putString("mail", usuario.getMail());
        editor.putString("pass", usuario.getPassword());
        editor.commit();
    }

    public static Usuario leer(Context context) {
        SharedPreferences sp = conectar(context);
        Long dni = sp.getLong("dni", -1);
        String apellido = sp.getString("apellido", "-1");
        String nombre = sp.getString("nombre", "-1");
        String mail = sp.getString("mail", "-1");
        String pass = sp.getString("pass", "-1");

        Usuario usuario = new Usuario(dni, apellido, nombre, mail, pass);
        return usuario;
    }

    public static Usuario login(Context context, String mail, String pass) {
        Usuario usuario = null;
        SharedPreferences sp = conectar(context);

        Long dniL = sp.getLong("dni", -1);
        String apellidoL = sp.getString("apellido", "-1");
        String nombreL = sp.getString("nombre", "-1");
        String mailL = sp.getString("mail", "-1");
        String passL = sp.getString("pass", "-1");

        if(mail.equals(mailL) && pass.equals(passL)) {
            usuario = new Usuario(dniL, apellidoL, nombreL, mailL, passL);
        }

        return usuario;
    }
}
