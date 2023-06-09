package com.info.futbol5.service.entrada.file.impl;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;
import com.info.futbol5.domain.Posicion;
import com.info.futbol5.service.entrada.file.InputFileService;

public class InputFileServiceImpl implements InputFileService{

    @Override
    public List<Jugador> loadJugadorByFile(String rutaArchivo) {
        //Inicializamos lista de productos
        List<Jugador> jugadores = new ArrayList<>();

        try{
            //Lineas del archivo
            List<String> lineas = FileUtils.readLines(new File(rutaArchivo), StandardCharsets.UTF_8);
            //Cada linea es un jugador
            for (String linea : lineas) {
                //Partes de la linea
                String[] partes = linea.split(";");
                String nombre = partes[0];
                String apellido = partes[1];
                String sexo = partes[2];
                int anioNacimiento = Integer.parseInt(partes[3]);
                UUID id = UUID.randomUUID();
                double altura = Double.parseDouble(partes[4]);
                Posicion posicion = new Posicion();
                posicion.setNombre(partes[5]);
                int goles = Integer.parseInt(partes[6]);
                int partidos = Integer.parseInt(partes[7]);
                boolean cap ;
                if (partes[8] == "True"){
                    cap = true;
                }else{
                    cap = false;
                }
                int numeroRemera = Integer.parseInt(partes[9]);
                Jugador newJugador = new Jugador();
                newJugador.setNombre(nombre);
                newJugador.setApellido(apellido);
                newJugador.setSexo(sexo);
                newJugador.setAnioNacimiento(anioNacimiento);
                newJugador.setId(id);
                newJugador.setAltura(altura);
                newJugador.setPosicion(posicion);
                newJugador.setGoles(goles);
                newJugador.setPartidos(partidos);
                newJugador.setEsCapitan(cap);
                newJugador.setNumeroCamiseta(numeroRemera);

                jugadores.add(newJugador);
                
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }catch(NullPointerException n){
            System.out.println("Hola soy un error");
            throw new RuntimeException(n);
        }
        return jugadores;
    }


    @Override
    public List<Equipo> loadEquipoByFile(String rutaArchivo, List<Jugador> jugadores) {
        List<Equipo> equipos = new ArrayList<>();
        try{
            List<String> lineas = FileUtils.readLines(new File(rutaArchivo), StandardCharsets.UTF_8);
            for (String linea : lineas) {
                String[] partes = linea.split(";");
                String nombre = partes[0];
                String nombreCancha = partes[1];
                Equipo equipo = new Equipo();
                equipo.setNombre(nombre);
                equipo.setNombreCancha(nombreCancha);
                equipo.setFechaCreacion(LocalDate.now());
                equipo.setJugadores(jugadores);
                equipos.add(equipo);
            }

        }catch(IOException e){
            throw new RuntimeException(e);
        }catch(NullPointerException n){
            System.out.println("Hola soy un error");
            throw new RuntimeException(n);
        }
        return equipos;
    }


    @Override
    public List<Entrenador> loadEntranadorByFile(String rutaArchivo, List<Equipo> equipos) {
        List<Entrenador> entrenadores = new ArrayList<>();
        try{
            List<String> lineas = FileUtils.readLines(new File(rutaArchivo), StandardCharsets.UTF_8);
            for (String linea : lineas) {
                String[] partes = linea.split(";");
                for (Equipo equipo: equipos){
                    if (partes[4] == equipo.getNombre()){
                        String nombre = partes[0];
                        String apellido = partes[1];
                        String sexo = partes[2];
                        int anioNacimiento = Integer.parseInt(partes[3]);
                        Entrenador entrenador = new Entrenador();
                        entrenador.setNombre(nombre);
                        entrenador.setApellido(apellido);
                        entrenador.setSexo(sexo);
                        entrenador.setAnioNacimiento(anioNacimiento);
                        entrenador.setEquipo(equipo);
                        entrenadores.add(entrenador);
                    }
                        
                }
            }
        }catch(IOException e){
            throw new RuntimeException(e);
        }catch(NullPointerException n){
            System.out.println("Hola soy un error");
            throw new RuntimeException(n);
        }
        return entrenadores;
    }
    
}
