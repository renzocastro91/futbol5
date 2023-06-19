package com.info.futbol5.service.fuciones.buscarEquipoPorNombreOrdenadoPorNombre;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;

import java.util.List;

public interface BuscarEquipoXNombreOrdenadoXNombre {
    void busqueEquipoXNombreOrdenadoXNombre(List<Equipo> todosLosEquipos, List<Entrenador> todosLosEntrenadores);
}
