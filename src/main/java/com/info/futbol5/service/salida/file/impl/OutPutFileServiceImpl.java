package com.info.futbol5.service.salida.file.impl;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;
import com.info.futbol5.service.salida.file.OutPutFileService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class OutPutFileServiceImpl implements OutPutFileService {
    @Override
    public void exportJugadores(List<Jugador> jugadores, String rutaDeDestino) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaDeDestino))) {
            for (Jugador jugador: jugadores ) {
                String linea = jugador.getNombre() + ";" +
                        jugador.getApellido() + ";" +
                        jugador.getSexo() + ";" +
                        jugador.getAnioNacimiento()+ ";" +
                        jugador.getAltura() + ";" +
                        ((jugador.getPosicion() != null)? jugador.getPosicion().getNombre():"") + ";" +
                        jugador.getGoles() +";" +
                        jugador.getPartidos() + ";" +
                        ((jugador.getEsCapitan())? "True":"False") + ";" +
                        jugador.getNumeroCamiseta();

                writer.write(linea);
                writer.newLine();


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void exportarEquipos(List<Equipo> equipos, String rutaDeDestino) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaDeDestino))) {
            for (Equipo equipo: equipos ) {
                String linea = equipo.getNombre() + ";" +
                        equipo.getFechaCreacion().getYear() + ";" +
                        equipo.getFechaCreacion().getMonthValue() + ";" +
                        equipo.getFechaCreacion().getDayOfMonth() + ";" +
                        equipo.getNombreCancha() ;

                writer.write(linea);
                writer.newLine();


            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void exportarEntrenador(List<Entrenador> entrenadores, String rutaDeDestino) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaDeDestino))) {
            for (Entrenador entrenador: entrenadores ) {
                String linea = entrenador.getNombre() + ";" +
                        entrenador.getApellido() + ";" +
                        entrenador.getSexo() + ";" +
                        entrenador.getAnioNacimiento()+ ";" +
                        entrenador.getEquipo().getNombre();

                writer.write(linea);
                writer.newLine();


            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
