package com.info.futbol5.service.fuciones.buscarEquipoporNombreOrdenadoPorPosicionYCamiseta;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;

import java.util.List;

public interface BuscarEquipoXNomOrdenadoXPosYCamService {
    void busqueEquipoXNomOrdenadoXPosyCam(List<Equipo> todosLosEquipos, List<Entrenador> todosLosEntrenadores);
}
