package com.info.futbol5.service.buscarEquipo.impl;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;
import com.info.futbol5.service.buscarEquipo.BuscarEquipoService;
import com.info.futbol5.service.entrada.console.impl.InputService;
import com.info.futbol5.service.ordenarEquipo.OrdenarEquipoService;
import com.info.futbol5.service.ordenarEquipo.impl.OrdenarEquipoServiceImpl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class BuscarEquipoServiceImpl implements BuscarEquipoService {
    private OrdenarEquipoService ordenarEquipoService = new OrdenarEquipoServiceImpl();
    @Override
    public void buscarEquipoPorNombre(List<Equipo> todosLosEquipos, List<Entrenador> todosLosEntrenadores) {
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

    @Override
    public void buscarEquipoPorNombreOrdenadoPorNumeroCamiseta(List<Equipo> todosLosEquipos, List<Entrenador> todosLosEntrenadores) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Buscar Equipo por nombre y Mostrar jugadores ordenados por n°Camiseta");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Ingrese Nombre de equipo a buscar:");
        String nombreEquipo = InputService.scanner.nextLine();
        boolean bandera = ordenarEquipoService.ordeneEquipoPorNumCamiseta(nombreEquipo,todosLosEquipos);
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

    @Override
    public void buscarEquipoPorNombreOrdenadoPorNombre(List<Equipo> todosLosEquipos, List<Entrenador> todosLosEntrenadores) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Buscar Equipo por nombre y Mostrar jugadores ordenados por nombre");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Ingrese Nombre de equipo a buscar:");
        String nombreEquipo = InputService.scanner.nextLine();
        boolean bandera = ordenarEquipoService.ordenarEquipoXNombre(nombreEquipo,todosLosEquipos);

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

    @Override
    public void buscarEquipoPorNombreOrdenadoPorPosicionyNumeroCamiseta(List<Equipo> todosLosEquipos, List<Entrenador> todosLosEntrenadores) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Buscar Equipo por nombre y Mostrar jugadores ordenados por n°Camiseta");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Ingrese Nombre de equipo a buscar:");
        String nombreEquipo = InputService.scanner.nextLine();
        boolean bandera = ordenarEquipoService.ordenePorPosicionYNumCamiseta(nombreEquipo,todosLosEquipos);
        for (Equipo equipo: todosLosEquipos) {
            if (Objects.equals(nombreEquipo, equipo.getNombre())){
                System.out.println("Nombre: "+ equipo.getNombre());
                for (Entrenador entrenador: todosLosEntrenadores) {
                    if (Objects.equals(entrenador.getEquipo().getNombre(), equipo.getNombre())) {
                        System.out.println("Entrenador: " + entrenador.getNombre());
                    }
                }

                System.out.println("Jugadores Ordenados por Posición y número Camiseta: ");
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
                bandera = true;
            }
        }
        if (!bandera){
            System.out.println("Equipo No encontrado");
            InputService.scanner.nextLine();
        }
    }
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
