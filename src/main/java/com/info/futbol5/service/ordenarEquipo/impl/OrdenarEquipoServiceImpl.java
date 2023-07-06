package com.info.futbol5.service.ordenarEquipo.impl;

import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;
import com.info.futbol5.service.ordenarEquipo.OrdenarEquipoService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class OrdenarEquipoServiceImpl implements OrdenarEquipoService {
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
    @Override
    public boolean ordenePorPosicionYNumCamiseta(String nombreEquipo, List<Equipo> todosLosEquipos) {
        for (Equipo equipo: todosLosEquipos) {
            if (Objects.equals(nombreEquipo, equipo.getNombre())){
                Collections.sort(equipo.getJugadores(), new Comparator<Jugador>() {
                    @Override
                    public int compare(Jugador o1, Jugador o2) {
                        // Comparar por posición
                        int resultado = o1.getPosicion().getNombre().compareTo(o2.getPosicion().getNombre());

                        if (resultado == 0) {
                            // Si la posición es la misma, comparar por número de camiseta
                            resultado = Integer.compare(o1.getNumeroCamiseta(), o2.getNumeroCamiseta());
                        }

                        return resultado;
                    }
                });
                return true;
            }
        }

        return false;
    }
}
