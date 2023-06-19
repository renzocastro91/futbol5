package com.info.futbol5.service.fuciones.buscarEquipoPorNombre.impl;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;
import com.info.futbol5.service.entrada.console.impl.InputService;
import com.info.futbol5.service.fuciones.buscarEquipoPorNombre.BuscarEquipoXNombreService;

import java.util.List;
import java.util.Objects;

public class BuscarEquipoXNombreServiceImpl implements BuscarEquipoXNombreService {
    @Override
    public void buscaEquipoXNombre(List<Equipo> todosLosEquipos, List<Entrenador> todosLosEntrenadores) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Buscar Equipo por nombre");
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
                for (Jugador jugador: equipo.getJugadores()) {
                    if (jugador.getEsCapitan()){
                        System.out.println("Capitan: "+ jugador.getNombre());
                    }
                }
                bandera = true;
            }
        }
        if (!bandera){
            System.out.println("Equipo No encontrado");
        }
    }
}
