package com.info.futbol5.service.exportarEJE;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;

import java.util.List;

public interface ExportarEJEService {
    void exporteJugadresOrdenadosXNombre(List<Equipo> todosLosEquipos);
    void exporteJugadoresOrdenadosXNumCamiseta(List<Equipo> todosLosEquipos);
    void exporteJugadoresOrdenadosXPosYCam(List<Equipo> todosLosEquipos);
    void exporteListaDeJugadores(List<Equipo> todosLosEquipos, List<Jugador> todosLosJugadores, List<Entrenador> todosLosEntrenadores);
}
