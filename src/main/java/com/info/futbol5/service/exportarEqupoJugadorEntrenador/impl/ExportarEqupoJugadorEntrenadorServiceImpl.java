package com.info.futbol5.service.exportarEqupoJugadorEntrenador.impl;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;
import com.info.futbol5.service.exportarEqupoJugadorEntrenador.ExportarEqupoJugadorEntrenadorService;
import com.info.futbol5.service.ordenarEquipo.OrdenarEquipoService;
import com.info.futbol5.service.ordenarEquipo.impl.OrdenarEquipoServiceImpl;
import com.info.futbol5.service.salida.file.OutPutFileService;
import com.info.futbol5.service.salida.file.impl.OutPutFileServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class ExportarEqupoJugadorEntrenadorServiceImpl implements ExportarEqupoJugadorEntrenadorService {
    private OrdenarEquipoService ordenarEquipoService = new OrdenarEquipoServiceImpl();
    @Override
    public void exportarJugadresOrdenadosPorNombre(List<Equipo> todosLosEquipos) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Exportacion lista de jugadores ordenados por nombre");
        System.out.println("-------------------------------------------------------------");
        List<Jugador> listaJugadoresAuxiliar = new ArrayList<>();
        for (Equipo equipo: todosLosEquipos) {
            ordenarEquipoService.ordenarEquipoXNombre(equipo.getNombre(), todosLosEquipos);
            for (Jugador jugador: equipo.getJugadores()) {
                listaJugadoresAuxiliar.add(jugador);
            }
        }
        System.out.println("-------------------------------------------------------------");
        OutPutFileService outPutFileService= new OutPutFileServiceImpl();
        String rutaArchivoSalida = "src\\main\\java\\com\\info\\futbol5\\resources\\pruebasalida.txt";
        outPutFileService.exportJugadores(listaJugadoresAuxiliar, rutaArchivoSalida);
        System.out.println("Archivos de Jugadores exportados con éxito");
    }
    @Override
    public void exportarJugadoresOrdenadosPorNumeroCamiseta(List<Equipo> todosLosEquipos) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Exportacion lista de jugadores ordenados por N° Camisetas");
        System.out.println("-------------------------------------------------------------");
        List<Jugador> listaJugadoresAuxiliar = new ArrayList<>();
        for (Equipo equipo: todosLosEquipos) {
            ordenarEquipoService.ordeneEquipoPorNumCamiseta(equipo.getNombre(),todosLosEquipos);
            for (Jugador jugador: equipo.getJugadores()) {
                listaJugadoresAuxiliar.add(jugador);
            }
        }
        System.out.println("-------------------------------------------------------------");
        OutPutFileService outPutFileService= new OutPutFileServiceImpl();
        String rutaArchivoSalida = "src\\main\\java\\com\\info\\futbol5\\resources\\pruebasalida.txt";
        outPutFileService.exportJugadores(listaJugadoresAuxiliar, rutaArchivoSalida);
        System.out.println("Archivos de Jugadores exportados con éxito");
    }
    @Override
    public void exportarJugadoresOrdenadosPorPosicionYNumeroCamiseta(List<Equipo> todosLosEquipos) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Exportacion lista de jugadores ordenados por Posicion y N° Camisetas");
        System.out.println("-------------------------------------------------------------");
        List<Jugador> listaJugadoresAuxiliar = new ArrayList<>();
        for (Equipo equipo: todosLosEquipos) {
            ordenarEquipoService.ordenePorPosicionYNumCamiseta(equipo.getNombre(),todosLosEquipos);
            for (Jugador jugador: equipo.getJugadores()) {
                listaJugadoresAuxiliar.add(jugador);
            }
        }
        System.out.println("-------------------------------------------------------------");
        OutPutFileService outPutFileService= new OutPutFileServiceImpl();
        String rutaArchivoSalida = "src\\main\\java\\com\\info\\futbol5\\resources\\pruebasalida.txt";
        outPutFileService.exportJugadores(listaJugadoresAuxiliar, rutaArchivoSalida);
        System.out.println("Archivos de Jugadores exportados con éxito");
    }

    @Override
    public void exportarListaDeJugadores(List<Equipo> todosLosEquipos, List<Jugador> todosLosJugadores, List<Entrenador> todosLosEntrenadores) {
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
