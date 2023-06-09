package com.info.futbol5.domain;

public class Persona {
    private String nombre;
    private String apellido;
    private String sexo;
    private int anioNacimiento;


    public Persona() {
    }


    @Override
    public String toString() {
        return " Nombre= " + getNombre() +
            " Apellido='" + getApellido() +
            " Sexo= " + getSexo() +
            " Anio Nacimiento= " + getAnioNacimiento();
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

}
