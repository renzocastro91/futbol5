package com.info.futbol5.service.fuciones.exportarJugadoresOrdenadosPorNombre.impl;

import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;
import com.info.futbol5.service.fuciones.exportarJugadoresOrdenadosPorNombre.ExportarJugadoresOrdenadosPorNombreService;
import com.info.futbol5.service.fuciones.ordenarEquipoPorNombre.OrdenarEquipoPorNombreService;
import com.info.futbol5.service.fuciones.ordenarEquipoPorNombre.impl.OrdenarEquipoPorNombreServiceImpl;
import com.info.futbol5.service.salida.file.OutPutFileService;
import com.info.futbol5.service.salida.file.impl.OutPutFileServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class ExportarJugadoresOrdenadosPorNombreServiceImpl implements ExportarJugadoresOrdenadosPorNombreService {

    @Override
    public void exporteJugadresOrdenadosXNombre(List<Equipo> todosLosEquipos) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Exportacion lista de jugadores ordenados por nombre");
        System.out.println("-------------------------------------------------------------");
        List<Jugador> listaJugadoresAuxiliar = new ArrayList<>();
        for (Equipo equipo: todosLosEquipos) {
            OrdenarEquipoPorNombreService ordenarEquipoPorNombreService = new OrdenarEquipoPorNombreServiceImpl();
            ordenarEquipoPorNombreService.ordenarEquipoXNombre(equipo.getNombre(), todosLosEquipos);
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
}
