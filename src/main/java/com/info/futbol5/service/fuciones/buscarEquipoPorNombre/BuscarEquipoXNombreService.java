package com.info.futbol5.service.fuciones.buscarEquipoPorNombre;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;

import java.util.List;

public interface BuscarEquipoXNombreService {
    void buscaEquipoXNombre(List<Equipo> todosLosEquipos, List<Entrenador> todosLosEntrenadores);
}
