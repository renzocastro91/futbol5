package com.info.futbol5.service.jugador.impl;

import java.util.UUID;
import com.info.futbol5.domain.Jugador;
import com.info.futbol5.domain.Posicion;
import com.info.futbol5.service.jugador.ServiceJugador;
import com.info.futbol5.service.entrada.impl.InputService;
import com.info.futbol5.service.posicion.impl.ServicePosicionImpl;

public class ServiceJugadorImpl implements ServiceJugador {

    @Override
    public Jugador crearJugador() {
        System.out.println("-->Jugador<--");
        Jugador nuevoJugador = new Jugador();
        nuevoJugador.setId(UUID.randomUUID());
        System.out.println("Ingrese Nombre");
        nuevoJugador.setNombre(InputService.getScanner().nextLine());
        System.out.println("Ingrese Apellido");
        nuevoJugador.setApellido(InputService.getScanner().nextLine());
        System.out.println("Ingrese Anio de nacimiento");
        nuevoJugador.setAnioNacimiento(InputService.getScanner().nextInt());
        System.out.println("Ingrese Sexo");
        nuevoJugador.setSexo(InputService.getScanner().nextLine());
        System.out.println("Ingrese Altura");
        nuevoJugador.setAltura(InputService.getScanner().nextDouble());
        System.out.println("Cree una posición para el jugador");
        ServicePosicionImpl PosicionSer = new ServicePosicionImpl();
        Posicion nuevaPosicion = PosicionSer.crearPosicion();
        nuevoJugador.setPosicion(nuevaPosicion);
        nuevoJugador.setGoles(0);
        nuevoJugador.setPartidos(0);
        nuevoJugador.setEsCapitan(determinarCapitan());
        System.out.println("Ingrese Numero de camiseta");
        nuevoJugador.setNumeroCamiseta(InputService.getScanner().nextInt());
        return nuevoJugador;
    }

    @Override
    public boolean determinarCapitan() {
        boolean esCapitan = false;
        int cap;
        System.out.println("Este jugador es capitan? 1- SI 2 - NO");
        cap = InputService.getScanner().nextInt();
        switch (cap){
            case 1:
            esCapitan = true; 
            break;
            case 2: 
            esCapitan = false;
            break;
            default: 
            System.out.println("Opción incorrecta");
            determinarCapitan();
        }
        return esCapitan; 
    }
    
}
