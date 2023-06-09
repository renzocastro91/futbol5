package com.info.futbol5.domain;

import java.time.LocalDate;
import java.time.Period;

public class Persona {
    private String nombre;
    private String apellido;
    private String sexo;
    private int anioNacimiento;

    private int edad;


    public Persona() {

    }


    @Override
    public String toString() {
        return " Nombre= " + getNombre() +
            " Apellido='" + getApellido() +
            " Sexo= " + getSexo() +
            " Anio Nacimiento= " + getAnioNacimiento()+
            " Edad= " + getEdad();
    }
    
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getAnioNacimiento() {
        return this.anioNacimiento;
    }

    public void setAnioNacimiento(int anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public void calcularEdad() {
        LocalDate fechaActual = LocalDate.now();
        int anioActual = fechaActual.getYear();

        Period periodo = Period.between(LocalDate.of(this.anioNacimiento, 1, 1), LocalDate.of(anioActual, fechaActual.getMonthValue(), fechaActual.getDayOfMonth()));
        setEdad(periodo.getYears());
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

}
