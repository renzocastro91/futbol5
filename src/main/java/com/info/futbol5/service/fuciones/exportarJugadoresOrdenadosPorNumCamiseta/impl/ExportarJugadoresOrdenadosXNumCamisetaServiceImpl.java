package com.info.futbol5.service.fuciones.exportarJugadoresOrdenadosPorNumCamiseta.impl;

import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;
import com.info.futbol5.service.fuciones.exportarJugadoresOrdenadosPorNumCamiseta.ExportarJugadoresOrdenadosXNumCamisetaService;
import com.info.futbol5.service.fuciones.ordenarEquipoPorNumCamiseta.OrdenarEquipoPorNumCamisetaService;
import com.info.futbol5.service.fuciones.ordenarEquipoPorNumCamiseta.impl.OrdenarEquipoPorNumCamisetaServiceImpl;
import com.info.futbol5.service.salida.file.OutPutFileService;
import com.info.futbol5.service.salida.file.impl.OutPutFileServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class ExportarJugadoresOrdenadosXNumCamisetaServiceImpl implements ExportarJugadoresOrdenadosXNumCamisetaService {
    @Override
    public void exporteJugadoresOrdenadosXNumCamiseta(List<Equipo> todosLosEquipos) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Exportacion lista de jugadores ordenados por N° Camisetas");
        System.out.println("-------------------------------------------------------------");
        List<Jugador> listaJugadoresAuxiliar = new ArrayList<>();
        for (Equipo equipo: todosLosEquipos) {
            OrdenarEquipoPorNumCamisetaService ordenarEquipoPorNumCamisetaService = new OrdenarEquipoPorNumCamisetaServiceImpl();
            ordenarEquipoPorNumCamisetaService.ordeneEquipoPorNumCamiseta(equipo.getNombre(),todosLosEquipos);
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
