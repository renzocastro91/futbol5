package com.info.futbol5.service.buscarEquipo;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;

import java.util.List;

public interface BuscarEquipoService {
    void buscarEquipoPorNombre(List<Equipo> todosLosEquipos, List<Entrenador> todosLosEntrenadores);
    void buscarEquipoPorNombreOrdenadoPorNumeroCamiseta(List<Equipo> todosLosEquipos, List<Entrenador> todosLosEntrenadores);
    void buscarEquipoPorNombreOrdenadoPorNombre(List<Equipo> todosLosEquipos, List<Entrenador> todosLosEntrenadores);
    void buscarEquipoPorNombreOrdenadoPorPosicionyNumeroCamiseta(List<Equipo> todosLosEquipos, List<Entrenador> todosLosEntrenadores);
    void muestraJugadoresDeEquipo(List<Equipo> todosLosEquipos, List<Entrenador> todosLosEntrenadores);
}
