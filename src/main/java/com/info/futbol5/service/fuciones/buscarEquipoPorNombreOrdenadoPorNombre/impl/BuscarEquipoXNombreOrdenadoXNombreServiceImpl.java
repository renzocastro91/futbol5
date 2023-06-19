package com.info.futbol5.service.fuciones.buscarEquipoPorNombreOrdenadoPorNombre.impl;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;
import com.info.futbol5.service.entrada.console.impl.InputService;
import com.info.futbol5.service.fuciones.buscarEquipoPorNombreOrdenadoPorNombre.BuscarEquipoXNombreOrdenadoXNombre;
import com.info.futbol5.service.fuciones.ordenarEquipoPorNombre.OrdenarEquipoPorNombreService;
import com.info.futbol5.service.fuciones.ordenarEquipoPorNombre.impl.OrdenarEquipoPorNombreServiceImpl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class BuscarEquipoXNombreOrdenadoXNombreServiceImpl implements BuscarEquipoXNombreOrdenadoXNombre {
    @Override
    public void busqueEquipoXNombreOrdenadoXNombre(List<Equipo> todosLosEquipos, List<Entrenador> todosLosEntrenadores) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Buscar Equipo por nombre y Mostrar jugadores ordenados por nombre");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Ingrese Nombre de equipo a buscar:");
        String nombreEquipo = InputService.scanner.nextLine();
        OrdenarEquipoPorNombreService ordenarEquipoPorNombreService = new OrdenarEquipoPorNombreServiceImpl();
        boolean bandera = ordenarEquipoPorNombreService.ordenarEquipoXNombre(nombreEquipo,todosLosEquipos);

        for (Equipo equipo : todosLosEquipos) {
            if (Objects.equals(nombreEquipo, equipo.getNombre())) {
                System.out.println("Nombre: " + equipo.getNombre());
                for (Entrenador entrenador : todosLosEntrenadores) {
                    if (Objects.equals(entrenador.getEquipo().getNombre(), equipo.getNombre())) {
                        System.out.println("Entrenador: " + entrenador.getNombre());
                    }
                }
                System.out.println("Jugadores Ordenados por nombre: ");
                for (Jugador jugador : equipo.getJugadores()) {
                    System.out.println("-------------------------------------");
                    System.out.println("Nombre: " + jugador.getNombre());
                    System.out.println("Apellido: " + jugador.getApellido());
                    System.out.println("Posicion: " + jugador.getPosicion().getNombre());
                    System.out.println("Capitan: " + jugador.getEsCapitan());
                    System.out.println("Equipo: " + equipo.getNombre());
                }
                System.out.println("-------------------------------------");
            }

        }

        if (!bandera){
            System.out.println("Equipo No encontrado");
            InputService.scanner.nextLine();
        }
    }

}
