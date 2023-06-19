package com.info.futbol5.service.fuciones.exportarJugadoresOrdenadosPorNombre;

import com.info.futbol5.domain.Equipo;

import java.util.List;

public interface ExportarJugadoresOrdenadosPorNombreService {
    void exporteJugadresOrdenadosXNombre(List<Equipo> todosLosEquipos);
}
