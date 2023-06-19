package com.info.futbol5.service.fuciones.ordenarPorPosicionyNumCam;

import com.info.futbol5.domain.Equipo;

import java.util.List;

public interface OrdenarPorPosicionyNumCamService {
    boolean ordenePorPosicionYNumCamiseta(String nombreEquipo ,List<Equipo> todosLosEquipos);
}
