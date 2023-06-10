package com.info.futbol5.service.equipo;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;

import java.util.List;

public interface ServiceEquipo {
    Equipo crearEquipo(List<Jugador> jugadores);
}
