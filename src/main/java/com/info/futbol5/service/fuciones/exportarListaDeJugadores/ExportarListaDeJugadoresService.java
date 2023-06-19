package com.info.futbol5.service.fuciones.exportarListaDeJugadores;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;

import java.util.List;

public interface ExportarListaDeJugadoresService {
    void exporteListaDeJugadores(List<Equipo> todosLosEquipos, List<Jugador> todosLosJugadores, List<Entrenador> todosLosEntrenadores);
}
