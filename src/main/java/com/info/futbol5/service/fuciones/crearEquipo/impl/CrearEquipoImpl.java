package com.info.futbol5.service.fuciones.crearEquipo.impl;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;
import com.info.futbol5.service.entrenador.ServiceEntrenador;
import com.info.futbol5.service.entrenador.impl.ServiceEntrenadorImpl;
import com.info.futbol5.service.equipo.ServiceEquipo;
import com.info.futbol5.service.equipo.impl.ServiceEquipoImpl;
import com.info.futbol5.service.fuciones.crearEquipo.CrearEquipoService;
import com.info.futbol5.service.jugador.ServiceJugador;
import com.info.futbol5.service.jugador.impl.ServiceJugadorImpl;

import java.util.List;

public class CrearEquipoImpl implements CrearEquipoService {

    @Override
    public void creoEquipo(List<Equipo> todosLosEquipos, List<Jugador> todosLosJugadores, List<Entrenador> todosLosEntrenadores) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Menu Para la carga de Equipo");
        System.out.println("-------------------------------------------------------------");
        ServiceEquipo serviceEquipo = new ServiceEquipoImpl();
        Equipo newEquipo = serviceEquipo.crearEquipo();
        todosLosEquipos.add(newEquipo);
        ServiceJugador serviceJugador = new ServiceJugadorImpl();
        List<Jugador> jugadoresEquipo = serviceJugador.crearJugadores(newEquipo);
        for (Jugador jugador: jugadoresEquipo ) {
            todosLosJugadores.add(jugador);
            newEquipo.getJugadores().add(jugador);
        }
        ServiceEntrenador serviceEntrenador = new ServiceEntrenadorImpl();
        Entrenador newEntrenador = serviceEntrenador.crearEntrenador(newEquipo);
        todosLosEntrenadores.add(newEntrenador);
        System.out.println("-------------------------------------------------------------");
        System.out.println("Carga de equipo exitoso!");
        System.out.println("-------------------------------------------------------------");
    }
}
