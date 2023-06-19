package com.info.futbol5.service.fuciones.listarTodo.impl;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;
import com.info.futbol5.service.fuciones.listarTodo.ListarTodoService;

import java.util.List;

public class ListarTodoServiceImpl implements ListarTodoService {

    @Override
    public void listaTodo(List<Equipo> todosLosEquipos, List<Jugador> todosLosJugadores, List<Entrenador> todosLosEntrenadores) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Jugadores");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Cantidad: "+ todosLosJugadores.size());
        for (Jugador jugador: todosLosJugadores){
            System.out.println(jugador.toString());
        }
        System.out.println("-------------------------------------------------------------");
        System.out.println("Equipos");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Cantidad: "+todosLosEquipos.size());
        for (Equipo equipo: todosLosEquipos){
            System.out.println(equipo.toString());
        }
        System.out.println("-------------------------------------------------------------");
        System.out.println("Entrenadores");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Cantidad: "+todosLosEntrenadores.size());
        for (Entrenador entrenador: todosLosEntrenadores){
            System.out.println(entrenador.toString());
        }
        System.out.println("-------------------------------------------------------------");
    }
}
