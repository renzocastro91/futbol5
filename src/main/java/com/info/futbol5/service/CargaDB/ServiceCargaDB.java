package com.info.futbol5.service.CargaDB;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;

import java.util.List;

public interface ServiceCargaDB {
    List<Jugador> cargaJugadores(String rutaArchivo, List<Equipo> equipos, List<Entrenador> todosLosEntrenadores);
    List<Equipo> cargaEquipos(String rutaArchivo);
    List<Entrenador> cargaEntrenadores(String rutaArchivo,List<Equipo> equipos);

}
