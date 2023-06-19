package com.info.futbol5.service.fuciones.importarListasDeJugadores;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;

import java.util.List;

public interface ImportarListaDeJugadoresService {
    List<Equipo> importaListaDeEquipos();
    List<Jugador> importaListaDeJugadores(List<Equipo> todosLosEquipos);
    List<Entrenador> importaListaDeEntrenadores(List<Equipo> todosLosEquipos);
}
