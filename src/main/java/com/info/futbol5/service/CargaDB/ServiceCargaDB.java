package com.info.futbol5.service.CargaDB;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;

import java.util.List;

public interface ServiceCargaDB {
    List<Jugador> cargaJugadores(String rutaArchivo);
    List<Equipo> cargaEquipos(List<Jugador> jugadores, String rutaArchivo);
    List<Entrenador> cargaEntrenadores(List<Equipo> equipos, String rutaArchivo);

}
