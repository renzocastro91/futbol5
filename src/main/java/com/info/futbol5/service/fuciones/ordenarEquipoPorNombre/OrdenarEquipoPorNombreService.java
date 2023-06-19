package com.info.futbol5.service.fuciones.ordenarEquipoPorNombre;

import com.info.futbol5.domain.Equipo;

import java.util.List;

public interface OrdenarEquipoPorNombreService {
    boolean ordenarEquipoXNombre(String nombreEquipo, List<Equipo> todosLosEquipos);

}
