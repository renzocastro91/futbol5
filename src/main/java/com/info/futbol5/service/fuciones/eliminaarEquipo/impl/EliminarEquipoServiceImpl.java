package com.info.futbol5.service.fuciones.eliminaarEquipo.impl;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;
import com.info.futbol5.service.entrada.console.impl.InputService;
import com.info.futbol5.service.fuciones.eliminaarEquipo.EliminarEquipoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EliminarEquipoServiceImpl implements EliminarEquipoService {
    @Override
    public void eliminaEquipo(List<Equipo> todosLosEquipos, List<Jugador> todosLosJugadores, List<Entrenador> todosLosEntrenadores) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Eliminar un equipo");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Ingrese Nombre de equipo a buscar:");
        String nombreEquipo = InputService.scanner.nextLine();
        Entrenador entrenadorRes = new Entrenador();
        Equipo equipoRes = new Equipo();
        ArrayList<Jugador> jugadoresAEliminar = new ArrayList<>();

        boolean bandera = false;
        for (Equipo equipo: todosLosEquipos) {
            if (Objects.equals(nombreEquipo, equipo.getNombre())){
                equipoRes = equipo;
                bandera = true;
                for (Entrenador entrenador: todosLosEntrenadores) {
                    if (Objects.equals(entrenador.getEquipo().getNombre(), equipo.getNombre())){
                        entrenadorRes = entrenador;
                    }
                }
                for (Jugador jugador: equipo.getJugadores()) {
                    for (Jugador jugador1: todosLosJugadores) {
                        if (jugador.getId() == jugador1.getId()){
                            jugadoresAEliminar.add(jugador);
                        }
                    }
                }

            }

        }
        if (bandera){
            todosLosEntrenadores.remove(entrenadorRes);
            todosLosJugadores.removeAll(jugadoresAEliminar);
            todosLosEquipos.remove(equipoRes);
            System.out.println("Equipo Eliminado!");
        }else{
            System.out.println("Equipo No encontrado");
        }
    }
}
