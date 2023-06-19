package com.info.futbol5.service.fuciones.ordenarPorPosicionyNumCam.impl;

import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;
import com.info.futbol5.service.fuciones.ordenarPorPosicionyNumCam.OrdenarPorPosicionyNumCamService;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class OrdenarPorPosicionyNumCamServiceImpl implements OrdenarPorPosicionyNumCamService {
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
