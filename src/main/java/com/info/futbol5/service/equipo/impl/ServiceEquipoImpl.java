package com.info.futbol5.service.equipo.impl;

import java.time.LocalDate;
import java.util.List;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;
import com.info.futbol5.service.equipo.ServiceEquipo;
import com.info.futbol5.service.entrada.console.impl.InputService;

public class ServiceEquipoImpl implements ServiceEquipo {
    @Override
    public Equipo crearEquipo(List<Jugador> jugadores) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Equipo");
        System.out.println("-------------------------------------------------------------");
        Equipo newEquipo = new Equipo();
        System.out.println("Nombre Equipo:");
        newEquipo.setNombre(InputService.scanner.nextLine());
        newEquipo.setFechaCreacion(LocalDate.now());
        newEquipo.setJugadores(jugadores);
        System.out.println("Nombre Cancha:");
        newEquipo.setNombreCancha(InputService.scanner.nextLine());
        return newEquipo;
    }

}
