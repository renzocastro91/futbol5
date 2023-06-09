package com.info.futbol5.service.salida.file.impl;

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
}
