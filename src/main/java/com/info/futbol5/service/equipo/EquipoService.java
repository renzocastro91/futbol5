package com.info.futbol5.service.equipo;
import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;

import java.util.List;

public interface EquipoService {
    void crearEquipo(List<Equipo> todosLosEquipos, List<Jugador> todosLosJugadores, List<Entrenador> todosLosEntrenadores);
    void eliminarEquipo(List<Equipo> todosLosEquipos, List<Jugador> todosLosJugadores, List<Entrenador> todosLosEntrenadores);

    void listarEquipos(List<Equipo> todosLosEquipos);
}
