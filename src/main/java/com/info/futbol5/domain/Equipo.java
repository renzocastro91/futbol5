package com.info.futbol5.domain;
import java.time.LocalDate;
import java.util.List;

public class Equipo {
    private String nombre;
    private LocalDate fechaCreacion;
    private List<Jugador> jugadores;
    private String nombreCancha;
    private List<Jugador> titulares;


    public Equipo() {
    }

    @Override
    public String toString() {
        return " Nombre='" + getNombre() +
            " FechaCreacion='" + getFechaCreacion() +
            " Jugadores='" + getJugadores() +
            " Nombre de la Cancha= " + getNombreCancha();
    }


    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaCreacion() {
        return this.fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public List<Jugador> getJugadores() {
        return this.jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public String getNombreCancha() {
        return this.nombreCancha;
    }

    public void setNombreCancha(String nombreCancha) {
        this.nombreCancha = nombreCancha;
    }

    public List<Jugador> getTitulares() {
        return this.titulares;
    }

    public void setTitulares(List<Jugador> titulares) {
        this.titulares = titulares;
    }

}
