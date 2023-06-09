package com.info.futbol5.service.salida.file;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;
import java.util.List;
public interface OutPutFileService {
    void exportJugadores(List<Jugador> jugadores, String rutaDeDestino);
    void exportarEquipos(List<Equipo> equipos, String rutaDeDestino);
    void exportarEntrenador(List<Entrenador> entrenadores, String rutaDeDestino);

}
