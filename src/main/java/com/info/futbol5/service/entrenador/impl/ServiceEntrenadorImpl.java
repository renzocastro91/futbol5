package com.info.futbol5.service.entrenador.impl;
import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.service.entrenador.ServiceEntrenador;
import com.info.futbol5.service.entrada.console.impl.InputService;


public class ServiceEntrenadorImpl implements ServiceEntrenador {
    @Override
    public Entrenador crearEntrenador(Equipo equipo){
        System.out.println("-------------------------------------------------------------");
        System.out.println("Entrenador");
        System.out.println("-------------------------------------------------------------");
        Entrenador newEntrenador = new Entrenador();
        System.out.println("Nombre:");
        newEntrenador.setNombre(InputService.scanner.nextLine());
        System.out.println("Apellido:");
        newEntrenador.setApellido(InputService.scanner.nextLine());
        System.out.println("Sexo:");
        newEntrenador.setSexo(InputService.scanner.nextLine());
        System.out.println("Año Nacimiento:");
        newEntrenador.setAnioNacimiento(InputService.scanner.nextInt());
        InputService.scanner.nextLine();
        newEntrenador.calcularEdad();
        newEntrenador.setEquipo(equipo);
        return newEntrenador;
    }
}
