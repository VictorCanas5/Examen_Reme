package com.example.calculadora.Modelos;

import android.content.Intent;

public class Opcion {
    public Intent nombre;

    public Intent getNombre() {
        return nombre;
    }

    public void setNombre(Intent nombre) {
        this.nombre = nombre;
    }

    public Opcion(Intent nombre) {
        this.nombre = nombre;
    }
}
