package com.info.futbol5.service.ordenarEquipo;

import com.info.futbol5.domain.Equipo;

import java.util.List;

public interface OrdenarEquipoService {
    boolean ordenarEquipoXNombre(String nombreEquipo, List<Equipo> todosLosEquipos);
    boolean ordeneEquipoPorNumCamiseta(String nombreEquipo, List<Equipo> todosLosEquipos);
    boolean ordenePorPosicionYNumCamiseta(String nombreEquipo ,List<Equipo> todosLosEquipos);
}
