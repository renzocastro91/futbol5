package com.info.futbol5.service.fuciones.exportarJugadoresOrdenadosPorNumCamiseta;

import com.info.futbol5.domain.Equipo;

import java.util.List;

public interface ExportarJugadoresOrdenadosXNumCamisetaService {
    void exporteJugadoresOrdenadosXNumCamiseta(List<Equipo> todosLosEquipos);
}
