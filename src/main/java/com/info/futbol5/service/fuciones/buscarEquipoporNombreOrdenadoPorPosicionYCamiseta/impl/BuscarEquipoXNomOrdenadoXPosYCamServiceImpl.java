package com.info.futbol5.service.fuciones.buscarEquipoporNombreOrdenadoPorPosicionYCamiseta.impl;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;
import com.info.futbol5.service.entrada.console.impl.InputService;
import com.info.futbol5.service.fuciones.buscarEquipoporNombreOrdenadoPorPosicionYCamiseta.BuscarEquipoXNomOrdenadoXPosYCamService;
import com.info.futbol5.service.fuciones.ordenarPorPosicionyNumCam.OrdenarPorPosicionyNumCamService;
import com.info.futbol5.service.fuciones.ordenarPorPosicionyNumCam.impl.OrdenarPorPosicionyNumCamServiceImpl;

import java.util.List;
import java.util.Objects;

public class BuscarEquipoXNomOrdenadoXPosYCamServiceImpl implements BuscarEquipoXNomOrdenadoXPosYCamService {
    @Override
    public void busqueEquipoXNomOrdenadoXPosyCam(List<Equipo> todosLosEquipos, List<Entrenador> todosLosEntrenadores) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Buscar Equipo por nombre y Mostrar jugadores ordenados por n°Camiseta");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Ingrese Nombre de equipo a buscar:");
        String nombreEquipo = InputService.scanner.nextLine();
        OrdenarPorPosicionyNumCamService ordenarPorPosicionyNumCamService = new OrdenarPorPosicionyNumCamServiceImpl();
        boolean bandera = ordenarPorPosicionyNumCamService.ordenePorPosicionYNumCamiseta(nombreEquipo,todosLosEquipos);
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
}
