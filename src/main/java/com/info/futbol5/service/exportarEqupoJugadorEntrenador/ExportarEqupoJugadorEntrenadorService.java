package com.info.futbol5.service.exportarEqupoJugadorEntrenador;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;

import java.util.List;

public interface ExportarEqupoJugadorEntrenadorService {
    void exportarJugadresOrdenadosPorNombre(List<Equipo> todosLosEquipos);
    void exportarJugadoresOrdenadosPorNumeroCamiseta(List<Equipo> todosLosEquipos);
    void exportarJugadoresOrdenadosPorPosicionYNumeroCamiseta(List<Equipo> todosLosEquipos);
    void exportarListaDeJugadores(List<Equipo> todosLosEquipos, List<Jugador> todosLosJugadores, List<Entrenador> todosLosEntrenadores);
}
