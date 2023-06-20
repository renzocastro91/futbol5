package com.info.futbol5.service.entrada.file.impl;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.io.File;
import java.io.IOException;

import com.info.futbol5.service.entrada.console.impl.InputService;
import com.info.futbol5.service.entrenador.ServiceEntrenador;
import com.info.futbol5.service.entrenador.impl.ServiceEntrenadorImpl;
import com.info.futbol5.service.equipo.ServiceEquipo;
import com.info.futbol5.service.equipo.impl.ServiceEquipoImpl;
import org.apache.commons.io.FileUtils;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;
import com.info.futbol5.domain.Posicion;
import com.info.futbol5.service.entrada.file.InputFileService;

public class InputFileServiceImpl implements InputFileService{

    @Override
    public List<Jugador> loadJugadorByFile(String rutaArchivo, List<Equipo> equipos) {
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
                if (Objects.equals(partes[8], "True")){
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
                newJugador.calcularEdad();
                newJugador.setId(id);
                newJugador.setAltura(altura);
                newJugador.setPosicion(posicion);
                newJugador.setGoles(goles);
                newJugador.setPartidos(partidos);
                newJugador.setEsCapitan(cap);
                newJugador.setNumeroCamiseta(numeroRemera);
                boolean bandera= false;
                for (Equipo equipo: equipos) {
                    if(Objects.equals(partes[10], equipo.getNombre())){
                        newJugador.setEquipo(equipo);
                        equipo.getJugadores().add(newJugador);
                        bandera = true;
                    }
                }
                //Caso de que en los archivos de jugadores hayan cargado jugadores de equipos que no existen en los archivos respectivos
                //completo datos de equipo nuevo y agrego a lista de equipos existentes
                if(!bandera){
                    System.out.println("Nuevo equipo encontrado: "+ partes[10]);
                    System.out.println("Ingrese los datos faltantes del equipo");
                    Equipo newEquipo = new Equipo();
                    newEquipo.setNombre(partes[10]);
                    newEquipo.setFechaCreacion(LocalDate.now());
                    List<Jugador> jugadoresX = new ArrayList<>();
                    newEquipo.setJugadores(jugadoresX);
                    System.out.println("Nombre Cancha:");
                    newEquipo.setNombreCancha(InputService.scanner.nextLine());
                    newJugador.setEquipo(newEquipo);
                    newEquipo.getJugadores().add(newJugador);
                    equipos.add(newEquipo);
                }

                jugadores.add(newJugador);

            }
        }catch (IOException | NullPointerException e){
            throw new RuntimeException(e);
        }
        return jugadores;
    }


    @Override
    public List<Equipo> loadEquipoByFile(String rutaArchivo) {
        List<Equipo> equipos = new ArrayList<>();
        try{
            List<String> lineas = FileUtils.readLines(new File(rutaArchivo), StandardCharsets.UTF_8);
            for (String linea : lineas) {
                String[] partes = linea.split(";");
                String nombre = partes[0];
                int anio = Integer.parseInt(partes[1]);
                int mes = Integer.parseInt(partes[2]);
                int dia = Integer.parseInt(partes[3]);
                String nombreCancha = partes[4];
                Equipo equipo = new Equipo();
                equipo.setNombre(nombre);
                LocalDate fechaCreacion = LocalDate.of(anio,mes,dia);
                equipo.setFechaCreacion(fechaCreacion);
                equipo.setNombreCancha(nombreCancha);
                List<Jugador> jugadores = new ArrayList<>();
                equipo.setJugadores(jugadores);
                equipos.add(equipo);
            }
        }catch(IOException e){
            throw new RuntimeException(e);
        }catch(NullPointerException n){
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
                    if (Objects.equals(partes[4], equipo.getNombre())){
                        String nombre = partes[0];
                        String apellido = partes[1];
                        String sexo = partes[2];
                        int anioNacimiento = Integer.parseInt(partes[3]);
                        Entrenador entrenador = new Entrenador();
                        entrenador.setNombre(nombre);
                        entrenador.setApellido(apellido);
                        entrenador.setSexo(sexo);
                        entrenador.setAnioNacimiento(anioNacimiento);
                        entrenador.calcularEdad();
                        entrenador.setEquipo(equipo);
                        entrenadores.add(entrenador);
                    }
                        
                }
            }
            //Caso de que en los archivos de jugadores hayan cargado jugadores de equipos que no existen en los archivos respectivos
            //completo datos de entrenador para el equipo nuevo agregado, o los equipos nuevos
            if (entrenadores.size() < equipos.size()) {
                for (Equipo equipo : equipos) {
                    boolean entrenadorAsignado = false;
                    for (Entrenador entrenador : entrenadores) {
                        if (entrenador.getEquipo().getNombre().equals(equipo.getNombre())) {
                            entrenadorAsignado = true;
                            break;
                        }
                    }
                    if (!entrenadorAsignado) {
                        System.out.println("Complete datos del entrenador para el equipo: " + equipo.getNombre());
                        ServiceEntrenador serviceEntrenador = new ServiceEntrenadorImpl();
                        Entrenador newEntrenador = serviceEntrenador.crearEntrenador(equipo);
                        entrenadores.add(newEntrenador);
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
