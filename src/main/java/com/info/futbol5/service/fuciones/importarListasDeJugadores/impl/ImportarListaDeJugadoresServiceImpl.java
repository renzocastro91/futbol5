package com.info.futbol5.service.fuciones.importarListasDeJugadores.impl;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;
import com.info.futbol5.service.CargaDB.ServiceCargaDB;
import com.info.futbol5.service.CargaDB.impl.ServiceCargaDBImpl;
import com.info.futbol5.service.fuciones.importarListasDeJugadores.ImportarListaDeJugadoresService;

import java.util.ArrayList;
import java.util.List;

public class ImportarListaDeJugadoresServiceImpl implements ImportarListaDeJugadoresService {

    @Override
    public List<Equipo> importaListaDeEquipos() {
        System.out.println("-------------------------------------------------------------");
        ServiceCargaDB servicioCargaDB = new ServiceCargaDBImpl();
        String rutaArchivoE = "src\\main\\java\\com\\info\\futbol5\\resources\\equipo_IO.txt";
        List<Equipo> todosLosEquipos = servicioCargaDB.cargaEquipos(rutaArchivoE);
        return todosLosEquipos;
    }

    @Override
    public List<Jugador> importaListaDeJugadores(List<Equipo> todosLosEquipos) {
        System.out.println("-------------------------------------------------------------");
        ServiceCargaDB servicioCargaDB = new ServiceCargaDBImpl();
        String rutaArchivoJ = "src\\main\\java\\com\\info\\futbol5\\resources\\jugador_IO.txt";
        List<Jugador> todosLosJugadores =  servicioCargaDB.cargaJugadores(rutaArchivoJ,todosLosEquipos);
        return todosLosJugadores;
    }

    @Override
    public List<Entrenador> importaListaDeEntrenadores(List<Equipo> todosLosEquipos) {
        System.out.println("-------------------------------------------------------------");
        ServiceCargaDB servicioCargaDB = new ServiceCargaDBImpl();
        String rutaArchivoEn = "src\\main\\java\\com\\info\\futbol5\\resources\\entrenador_IO.txt";
        List<Entrenador> todosLosEntrenadores = servicioCargaDB.cargaEntrenadores(rutaArchivoEn,todosLosEquipos);
        System.out.println("Archivos de Jugadores, Equipos y Entrenadores importados con éxito");
        return todosLosEntrenadores;
    }
}
