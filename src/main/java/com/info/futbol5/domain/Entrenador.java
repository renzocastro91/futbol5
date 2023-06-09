package com.info.futbol5.domain;
import java.time.LocalDate;
import java.time.Period;

public class Entrenador extends Persona{
    private int edad;
    private Equipo equipo;

    public Entrenador() {
        calcularEdad();
    }

    @Override
    public String toString() {
        return " Edad= " + getEdad()  +
            " Equipo='" + getEquipo().getNombre();
    }

    public int getEdad() {
        return this.edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Equipo getEquipo() {
        return this.equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    private void calcularEdad() {
        LocalDate fechaActual = LocalDate.now();
        int anioActual = fechaActual.getYear();

        Period periodo = Period.between(LocalDate.of(super.getAnioNacimiento(), 1, 1), LocalDate.of(anioActual, fechaActual.getMonthValue(), fechaActual.getDayOfMonth()));
        this.edad = periodo.getYears();
    }

}
