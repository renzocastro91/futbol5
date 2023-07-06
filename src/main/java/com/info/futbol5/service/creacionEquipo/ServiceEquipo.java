package com.info.futbol5.service.creacionEquipo;
import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;

import java.util.List;

public interface ServiceEquipo {
    void creoEquipo(List<Equipo> todosLosEquipos, List<Jugador> todosLosJugadores, List<Entrenador> todosLosEntrenadores);
    List<Jugador> crearJugadores(Equipo equipo);
    Entrenador crearEntrenador(Equipo equipo);
    void eliminaEquipo(List<Equipo> todosLosEquipos, List<Jugador> todosLosJugadores, List<Entrenador> todosLosEntrenadores);
}
