package com.info.futbol5.service.fuciones.ordenarEquipoPorNombre.impl;

import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;
import com.info.futbol5.service.fuciones.ordenarEquipoPorNombre.OrdenarEquipoPorNombreService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class OrdenarEquipoPorNombreServiceImpl implements OrdenarEquipoPorNombreService {
    @Override
    public boolean ordenarEquipoXNombre(String nombreEquipo, List<Equipo> todosLosEquipos) {
        for (Equipo equipo : todosLosEquipos) {
            if (Objects.equals(nombreEquipo, equipo.getNombre())) {
                Collections.sort(equipo.getJugadores(), new Comparator<Jugador>() {
                    @Override
                    public int compare(Jugador o1, Jugador o2) {
                        return o1.getNombre().compareTo(o2.getNombre());
                    }
                });
                return true;
            }

        }
        return false;
    }
}
