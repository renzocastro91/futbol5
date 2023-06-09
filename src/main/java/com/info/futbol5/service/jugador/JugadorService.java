package com.info.futbol5.service.jugador;

import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;

import java.util.List;

public interface JugadorService {
    List<Jugador> crearJugadores(Equipo equipo);
    void listarJugadores(List<Jugador> todosLosJugadores);
}
