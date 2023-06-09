package com.info.futbol5.service.CargaDB.impl;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;
import com.info.futbol5.service.CargaDB.ServiceCargaDB;
import com.info.futbol5.service.entrada.file.InputFileService;
import com.info.futbol5.service.entrada.file.impl.InputFileServiceImpl;

import java.util.List;

public class ServiceCargaDBImpl implements ServiceCargaDB {

    @Override
    public List<Jugador> cargaJugadores(String rutaArchivo) {
        InputFileService inputFileService = new InputFileServiceImpl();
        List<Jugador> jugadores = inputFileService.loadJugadorByFile(rutaArchivo);
        return jugadores;
    }

    @Override
    public List<Equipo> cargaEquipos(List<Jugador> jugadores, String rutaArchivo) {
        InputFileService inputFileService = new InputFileServiceImpl();
        List<Equipo> equipos = inputFileService.loadEquipoByFile(rutaArchivo, jugadores);
        return equipos;
    }

    @Override
    public List<Entrenador> cargaEntrenadores(List<Equipo> equipos, String rutaArchivo) {
        InputFileService inputFileService = new InputFileServiceImpl();
        List<Entrenador> entrenadores = inputFileService.loadEntranadorByFile(rutaArchivo, equipos);
        return entrenadores;
    }
}
