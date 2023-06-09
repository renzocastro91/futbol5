package com.info.futbol5.service.entrenador.impl;
import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.service.entrenador.ServiceEntrenador;
import com.info.futbol5.service.entrada.console.impl.InputService;


public class ServiceEntrenadorImpl implements ServiceEntrenador {
    @Override
    public Entrenador crearEntrenador(Equipo equipo){
        System.out.println("-->ENTRENADOR<--");
        Entrenador nuevoEntrenador = new Entrenador();
        System.out.println("Ingrese Nombre");
        nuevoEntrenador.setNombre(InputService.getScanner().nextLine());
        System.out.println("Ingrese Apellido");
        nuevoEntrenador.setApellido(InputService.getScanner().nextLine());
        System.out.println("Ingrese Anio de nacimiento");
        nuevoEntrenador.setAnioNacimiento(InputService.getScanner().nextInt());
        System.out.println("Ingrese Sexo");
        nuevoEntrenador.setSexo(InputService.getScanner().nextLine());
        nuevoEntrenador.setEquipo(equipo);
        return nuevoEntrenador;
    }
}
