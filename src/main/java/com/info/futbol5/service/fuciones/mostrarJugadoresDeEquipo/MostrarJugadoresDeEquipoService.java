package com.info.futbol5.service.fuciones.mostrarJugadoresDeEquipo;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;

import java.util.List;

public interface MostrarJugadoresDeEquipoService {
    void muestraJugadoresDeEquipo(List<Equipo> todosLosEquipos, List<Entrenador> todosLosEntrenadores);
}
