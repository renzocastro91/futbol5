package com.info.futbol5.service.fuciones.buscarEquipoPorNombreOrdenadoPorCamiseta.impl;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;
import com.info.futbol5.service.entrada.console.impl.InputService;
import com.info.futbol5.service.fuciones.buscarEquipoPorNombreOrdenadoPorCamiseta.BuscarEquipoPorNombreOrdenadoPorCamisetaService;
import com.info.futbol5.service.fuciones.ordenarEquipoPorNumCamiseta.OrdenarEquipoPorNumCamisetaService;
import com.info.futbol5.service.fuciones.ordenarEquipoPorNumCamiseta.impl.OrdenarEquipoPorNumCamisetaServiceImpl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class BuscarEquipoPorNombreOrdenadoPorCamisetaServiceImpl implements BuscarEquipoPorNombreOrdenadoPorCamisetaService {
    @Override
    public void busqueEquipoPorNombreOrdenadoPorCamiseta(List<Equipo> todosLosEquipos, List<Entrenador> todosLosEntrenadores) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Buscar Equipo por nombre y Mostrar jugadores ordenados por n°Camiseta");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Ingrese Nombre de equipo a buscar:");
        String nombreEquipo = InputService.scanner.nextLine();
        OrdenarEquipoPorNumCamisetaService ordenarEquipoPorNumCamisetaService = new OrdenarEquipoPorNumCamisetaServiceImpl();
        boolean bandera = ordenarEquipoPorNumCamisetaService.ordeneEquipoPorNumCamiseta(nombreEquipo,todosLosEquipos);
        for (Equipo equipo: todosLosEquipos) {
            if (Objects.equals(nombreEquipo, equipo.getNombre())){
                System.out.println("Nombre: "+ equipo.getNombre());
                for (Entrenador entrenador: todosLosEntrenadores) {
                    if (Objects.equals(entrenador.getEquipo().getNombre(), equipo.getNombre())) {
                        System.out.println("Entrenador: " + entrenador.getNombre());
                    }
                }
                Collections.sort(equipo.getJugadores(), new Comparator<Jugador>() {
                    @Override
                    public int compare(Jugador o1, Jugador o2) {
                        return Integer.compare(o1.getNumeroCamiseta(), o2.getNumeroCamiseta());
                    }
                });
                System.out.println("Jugadores Ordenados por número Camiseta: ");
                for (Jugador jugador: equipo.getJugadores()) {
                    System.out.println("-------------------------------------");
                    System.out.println("Nombre: " + jugador.getNombre());
                    System.out.println("Apellido: " + jugador.getApellido());
                    System.out.println("N°Camiseta: "+ jugador.getNumeroCamiseta());
                    System.out.println("Posicion: "+ jugador.getPosicion().getNombre());
                    System.out.println("Capitan: "+ jugador.getEsCapitan());
                    System.out.println("Equipo: "+ equipo.getNombre());
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
