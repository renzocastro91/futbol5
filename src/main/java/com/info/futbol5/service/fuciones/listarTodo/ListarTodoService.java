package com.info.futbol5.service.fuciones.listarTodo;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;

import java.util.List;

public interface ListarTodoService {
    void listaTodo(List<Equipo> todosLosEquipos, List<Jugador> todosLosJugadores, List<Entrenador> todosLosEntrenadores);
}
