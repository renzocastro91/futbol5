package com.info.futbol5.service.fuciones.buscarEquipoPorNombreOrdenadoPorCamiseta;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;

import java.util.List;

public interface BuscarEquipoPorNombreOrdenadoPorCamisetaService {
    void busqueEquipoPorNombreOrdenadoPorCamiseta(List<Equipo> todosLosEquipos, List<Entrenador> todosLosEntrenadores);
}
