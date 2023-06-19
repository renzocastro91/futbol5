package com.info.futbol5.service.fuciones.ordenarEquipoPorNumCamiseta.impl;

import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;
import com.info.futbol5.service.fuciones.ordenarEquipoPorNumCamiseta.OrdenarEquipoPorNumCamisetaService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class OrdenarEquipoPorNumCamisetaServiceImpl implements OrdenarEquipoPorNumCamisetaService {
    @Override
    public boolean ordeneEquipoPorNumCamiseta(String nombreEquipo, List<Equipo> todosLosEquipos) {
        for (Equipo equipo: todosLosEquipos) {
            if (Objects.equals(nombreEquipo, equipo.getNombre())){
                Collections.sort(equipo.getJugadores(), new Comparator<Jugador>() {
                    @Override
                    public int compare(Jugador o1, Jugador o2) {
                        return Integer.compare(o1.getNumeroCamiseta(), o2.getNumeroCamiseta());
                    }
                });
                return true;
            }
        }

        return false;
    }
}
