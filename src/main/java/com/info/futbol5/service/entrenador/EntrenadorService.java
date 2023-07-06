package com.info.futbol5.service.entrenador;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;

import java.util.List;

public interface EntrenadorService {
    Entrenador crearEntrenador(Equipo equipo);
    void listarEntrenadores(List<Entrenador> todosLosEntrenadores);
}
