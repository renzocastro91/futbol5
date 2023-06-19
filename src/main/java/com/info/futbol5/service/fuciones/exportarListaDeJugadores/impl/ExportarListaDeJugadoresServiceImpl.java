package com.info.futbol5.service.fuciones.exportarListaDeJugadores.impl;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;
import com.info.futbol5.service.fuciones.exportarListaDeJugadores.ExportarListaDeJugadoresService;
import com.info.futbol5.service.salida.file.OutPutFileService;
import com.info.futbol5.service.salida.file.impl.OutPutFileServiceImpl;

import java.util.List;

public class ExportarListaDeJugadoresServiceImpl implements ExportarListaDeJugadoresService {
    @Override
    public void exporteListaDeJugadores(List<Equipo> todosLosEquipos, List<Jugador> todosLosJugadores, List<Entrenador> todosLosEntrenadores) {
        System.out.println("-------------------------------------------------------------");
        OutPutFileService outPutFileService= new OutPutFileServiceImpl();
        String rutaArchivoSalida = "src\\main\\java\\com\\info\\futbol5\\resources\\pruebasalida.txt";
        String rutaArchivoSalida1 = "src\\main\\java\\com\\info\\futbol5\\resources\\pruebasalida1.txt";
        String rutaArchivoSalida2 = "src\\main\\java\\com\\info\\futbol5\\resources\\pruebasalida2.txt";
        outPutFileService.exportJugadores(todosLosJugadores, rutaArchivoSalida);
        outPutFileService.exportarEquipos(todosLosEquipos, rutaArchivoSalida1);
        outPutFileService.exportarEntrenador(todosLosEntrenadores, rutaArchivoSalida2);
        System.out.println("Archivos de Jugadores, Equipos y Entrenadores exportados con éxito");
    }
}
