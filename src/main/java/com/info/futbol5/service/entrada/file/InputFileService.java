package com.info.futbol5.service.entrada.file;
import java.util.List;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;



public interface InputFileService {
  List<Jugador> loadJugadorByFile(String rutaArchivo);
  List<List<Jugador>> loadListadeListadeJugadores(List<Jugador> jugadores);
  List<Equipo> loadEquipoByFile(String rutaArchivo, List<List<Jugador>> jugadores);
  List<Entrenador> loadEntranadorByFile(String rutaArchivo, List<Equipo> equipos);
}
