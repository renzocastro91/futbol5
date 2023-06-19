package com.info.futbol5.service.fuciones.mostrarJugadoresDeEquipo.impl;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;
import com.info.futbol5.service.entrada.console.impl.InputService;
import com.info.futbol5.service.fuciones.mostrarJugadoresDeEquipo.MostrarJugadoresDeEquipoService;

import java.util.List;
import java.util.Objects;

public class MostrarJugadoresDeEquipoServiceImpl implements MostrarJugadoresDeEquipoService {
    @Override
    public void muestraJugadoresDeEquipo(List<Equipo> todosLosEquipos, List<Entrenador> todosLosEntrenadores) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Buscar Equipo por nombre y lista jugadores");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Ingrese Nombre de equipo a buscar:");
        String nombreEquipo = InputService.scanner.nextLine();
        boolean bandera = false;
        for (Equipo equipo: todosLosEquipos) {
            if (Objects.equals(nombreEquipo, equipo.getNombre())){
                System.out.println("Nombre: "+ equipo.getNombre());
                for (Entrenador entrenador: todosLosEntrenadores) {
                    if (Objects.equals(entrenador.getEquipo().getNombre(), equipo.getNombre())) {
                        System.out.println("Entrenador: " + entrenador.getNombre());
                    }
                }
                System.out.println("Jugadores:");
                for (Jugador jugador: equipo.getJugadores()) {
                    System.out.println("Nombre: "+ jugador.getNombre() + " " + jugador.getPosicion().getNombre());
                }
                bandera = true;
            }
        }
        if (!bandera){
            System.out.println("Equipo No encontrado");
        }
    }
}
