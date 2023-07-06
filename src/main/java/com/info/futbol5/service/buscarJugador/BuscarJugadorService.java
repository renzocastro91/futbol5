package com.info.futbol5.service.buscarJugador;

import com.info.futbol5.domain.Equipo;

import java.util.List;

//Abierto para agregar mas tipos de búsqueda para jugador, por ejemplo por número de camiseta, etc
public interface BuscarJugadorService {
    void buscaJugadorxNombre(List<Equipo> todosLosEquipos);
}
