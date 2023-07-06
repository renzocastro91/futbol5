package com.info.futbol5.service.buscarJugador.impl;

import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;
import com.info.futbol5.service.buscarJugador.BuscarJugadorService;
import com.info.futbol5.service.entrada.console.impl.InputService;

import java.util.List;
import java.util.Objects;

public class BuscarJugadorServiceImpl implements BuscarJugadorService {
    @Override
    public void buscarJugadorPorNombre(List<Equipo> todosLosEquipos) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Buscar Jugador por nombre");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Ingrese Nombre de jugador a buscar:");
        String nombreJugador = InputService.scanner.nextLine();
        boolean bandera = false;
        for (Equipo equipo: todosLosEquipos) {
            for (Jugador jugador: equipo.getJugadores()) {
                if (Objects.equals(nombreJugador, jugador.getNombre())){
                    System.out.println("Nombre: " + jugador.getNombre());
                    System.out.println("Apellido: " + jugador.getApellido());
                    System.out.println("Posicion: "+ jugador.getPosicion().getNombre());
                    System.out.println("Capitan: "+ jugador.getEsCapitan());
                    System.out.println("Equipo: "+ jugador.getEquipo().getNombre());
                    bandera = true;
                }
            }
        }
        if (!bandera){
            System.out.println("Jugador no encontrado");
        }
    }

}
