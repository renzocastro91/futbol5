package com.info.futbol5.service.salida.file;

import com.info.futbol5.domain.Jugador;
import java.util.List;
public interface OutPutFileService {
    void exportJugadores(List<Jugador> jugadores, String rutaDeDestino);

}
