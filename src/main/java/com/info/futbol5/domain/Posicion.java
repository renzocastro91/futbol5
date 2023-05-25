package com.info.futbol5.domain;

public class Posicion {
    private String nombre;


    public Posicion() {
    }

    @Override
    public String toString() {
        return  getNombre();
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
