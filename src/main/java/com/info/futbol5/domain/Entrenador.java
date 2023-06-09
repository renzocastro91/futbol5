package com.info.futbol5.domain;
import java.time.LocalDate;
import java.time.Period;

public class Entrenador extends Persona{
    private Equipo equipo;

    public Entrenador() {

    }

    @Override
    public String toString() {
        return super.toString()  +
            " Equipo='" + getEquipo().getNombre();
    }

    public Equipo getEquipo() {
        return this.equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }



}
