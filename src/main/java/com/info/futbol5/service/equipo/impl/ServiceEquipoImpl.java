package com.info.futbol5.service.equipo.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;
import com.info.futbol5.service.equipo.ServiceEquipo;
import com.info.futbol5.service.entrada.impl.InputService;
import com.info.futbol5.service.jugador.impl.ServiceJugadorImpl;

public class ServiceEquipoImpl implements ServiceEquipo {

    @Override
    public Equipo crearEquipo() {
        System.out.println("-->Equipo<--");
        Equipo nuevoEquipo = new Equipo();
        System.out.println("Ingrese Nombre del equipo");
        nuevoEquipo.setNombre(InputService.getScanner().nextLine());
        nuevoEquipo.setFechaCreacion(LocalDate.now());
        List<Jugador> jugadores= new ArrayList<>();
        ServiceJugadorImpl jugadorS= new ServiceJugadorImpl();
        for (int i = 1; i < 5; i++){
            System.out.println("Jugador N°" + i);            
            Jugador jugadorNuevo = jugadorS.crearJugador();
            jugadores.add(jugadorNuevo);
        }
        nuevoEquipo.setJugadores(jugadores);
        System.out.println("Ingrese nombre de la cancha local");
        nuevoEquipo.setNombreCancha(InputService.getScanner().nextLine());
        return nuevoEquipo;
    }
    
}
