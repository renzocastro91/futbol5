package com.info.futbol5.service.fuciones.ordenarEquipoPorNumCamiseta;

import com.info.futbol5.domain.Equipo;

import java.util.List;

public interface OrdenarEquipoPorNumCamisetaService {
    boolean ordeneEquipoPorNumCamiseta(String nombreEquipo, List<Equipo> todosLosEquipos);
}
