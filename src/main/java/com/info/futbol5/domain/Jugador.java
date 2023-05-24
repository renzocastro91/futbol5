package com.info.futbol5.domain;
import java.util.*;

public class Jugador extends Persona {
    private UUID id;
    private double altura;
    private Posicion posicion;
    private int goles;
    private int partidos;
    private boolean esCapitan;
    private int numeroCamiseta;

    public Jugador() {
    }


    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getAltura() {
        return this.altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public Posicion getPosicion() {
        return this.posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public int getGoles() {
        return this.goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public int getPartidos() {
        return this.partidos;
    }

    public void setPartidos(int partidos) {
        this.partidos = partidos;
    }

    public boolean isEsCapitan() {
        return this.esCapitan;
    }

    public boolean getEsCapitan() {
        return this.esCapitan;
    }

    public void setEsCapitan(boolean esCapitan) {
        this.esCapitan = esCapitan;
    }

    public int getNumeroCamiseta() {
        return this.numeroCamiseta;
    }

    public void setNumeroCamiseta(int numeroCamiseta) {
        this.numeroCamiseta = numeroCamiseta;
    }

   

}
