package com.info.futbol5.service.buscarEquipo;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;

import java.util.List;

public interface BuscarEquipoService {
    void buscaEquipoXNombre(List<Equipo> todosLosEquipos, List<Entrenador> todosLosEntrenadores);
    void busqueEquipoPorNombreOrdenadoPorCamiseta(List<Equipo> todosLosEquipos, List<Entrenador> todosLosEntrenadores);
    void busqueEquipoXNombreOrdenadoXNombre(List<Equipo> todosLosEquipos, List<Entrenador> todosLosEntrenadores);
    void busqueEquipoXNomOrdenadoXPosyCam(List<Equipo> todosLosEquipos, List<Entrenador> todosLosEntrenadores);
    void muestraJugadoresDeEquipo(List<Equipo> todosLosEquipos, List<Entrenador> todosLosEntrenadores);
}
