package com.info.futbol5.service.fuciones.exportarJugadoresPorPosicionYCamiseta.impl;

import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;
import com.info.futbol5.service.fuciones.exportarJugadoresPorPosicionYCamiseta.ExportarJugadoresOrdenadosXPosYCamService;
import com.info.futbol5.service.fuciones.ordenarPorPosicionyNumCam.OrdenarPorPosicionyNumCamService;
import com.info.futbol5.service.fuciones.ordenarPorPosicionyNumCam.impl.OrdenarPorPosicionyNumCamServiceImpl;
import com.info.futbol5.service.salida.file.OutPutFileService;
import com.info.futbol5.service.salida.file.impl.OutPutFileServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class ExportarJugadoresOrdenadosXPosYCamServiceImpl implements ExportarJugadoresOrdenadosXPosYCamService {
    @Override
    public void exporteJugadoresOrdenadosXPosYCam(List<Equipo> todosLosEquipos) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Exportacion lista de jugadores ordenados por Posicion y N° Camisetas");
        System.out.println("-------------------------------------------------------------");
        List<Jugador> listaJugadoresAuxiliar = new ArrayList<>();
        for (Equipo equipo: todosLosEquipos) {
            OrdenarPorPosicionyNumCamService ordenarPorPosicionyNumCamService = new OrdenarPorPosicionyNumCamServiceImpl();
            ordenarPorPosicionyNumCamService.ordenePorPosicionYNumCamiseta(equipo.getNombre(),todosLosEquipos);
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

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
