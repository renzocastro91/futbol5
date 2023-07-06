package com.info.futbol5.service.importarEqupoJugadorEntrenador;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;

import java.util.List;

public interface ImportarEqupoJugadorEntrenadorService {
    List<Equipo> importaListaDeEquipos();
    List<Jugador> importaListaDeJugadores(List<Equipo> todosLosEquipos, List<Entrenador> todosLosEntrenadores);
    List<Entrenador> importaListaDeEntrenadores(List<Equipo> todosLosEquipos);
}
