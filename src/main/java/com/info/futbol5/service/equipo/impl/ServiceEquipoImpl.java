package com.info.futbol5.service.equipo.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;
import com.info.futbol5.service.entrenador.EntrenadorService;
import com.info.futbol5.service.entrenador.impl.EntrenadorServiceImpl;
import com.info.futbol5.service.equipo.EquipoService;
import com.info.futbol5.service.jugador.JugadorService;
import com.info.futbol5.service.jugador.impl.JugadorServiceImpl;
import com.info.futbol5.service.entrada.console.impl.InputService;


public class ServiceEquipoImpl implements EquipoService {
    private JugadorService jugadorService = new JugadorServiceImpl();
    private EntrenadorService entrenadorService = new EntrenadorServiceImpl();

    //creoEquipo() y crearEquipo() se diferencian en que cuando usamos creoEquipo se refiere al concepto general de crear un equipo
    //es decir creo el Equipo persé, lista de jugadores y entrenador, y crearEquipo() solo se encarga del equipo desde el punto de vista
    //de dominio, crea un objeto de Equipo y es usado por creoEquipo()
    @Override
    public void crearEquipo(List<Equipo> todosLosEquipos, List<Jugador> todosLosJugadores, List<Entrenador> todosLosEntrenadores) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Menu Para la carga de Equipo");
        System.out.println("-------------------------------------------------------------");
        Equipo newEquipo = crearEquipo();
        todosLosEquipos.add(newEquipo);
        List<Jugador> jugadoresEquipo = jugadorService.crearJugadores(newEquipo);
        for (Jugador jugador: jugadoresEquipo ) {
            todosLosJugadores.add(jugador);
            newEquipo.getJugadores().add(jugador);
        }
        Entrenador newEntrenador = entrenadorService.crearEntrenador(newEquipo);
        todosLosEntrenadores.add(newEntrenador);
        System.out.println("-------------------------------------------------------------");
        System.out.println("Carga de equipo exitoso!");
        System.out.println("-------------------------------------------------------------");
    }

    @Override
    public void eliminarEquipo(List<Equipo> todosLosEquipos, List<Jugador> todosLosJugadores, List<Entrenador> todosLosEntrenadores) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Eliminar un equipo");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Ingrese Nombre de equipo a buscar:");
        String nombreEquipo = InputService.scanner.nextLine();
        Entrenador entrenadorRes = new Entrenador();
        Equipo equipoRes = new Equipo();
        ArrayList<Jugador> jugadoresAEliminar = new ArrayList<>();

        boolean bandera = false;
        for (Equipo equipo: todosLosEquipos) {
            if (Objects.equals(nombreEquipo, equipo.getNombre())){
                equipoRes = equipo;
                bandera = true;
                for (Entrenador entrenador: todosLosEntrenadores) {
                    if (Objects.equals(entrenador.getEquipo().getNombre(), equipo.getNombre())){
                        entrenadorRes = entrenador;
                    }
                }
                for (Jugador jugador: equipo.getJugadores()) {
                    for (Jugador jugador1: todosLosJugadores) {
                        if (jugador.getId() == jugador1.getId()){
                            jugadoresAEliminar.add(jugador);
                        }
                    }
                }

            }

        }
        if (bandera){
            todosLosEntrenadores.remove(entrenadorRes);
            todosLosJugadores.removeAll(jugadoresAEliminar);
            todosLosEquipos.remove(equipoRes);
            System.out.println("Equipo Eliminado!");
        }else{
            System.out.println("Equipo No encontrado");
        }
    }

    @Override
    public void listarEquipos(List<Equipo> todosLosEquipos) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Lista de los Equipos");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Cantidad: "+todosLosEquipos.size());
        for (Equipo equipo: todosLosEquipos){
            System.out.println(equipo.toString());
        }
    }

    private Equipo crearEquipo() {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Equipo");
        System.out.println("-------------------------------------------------------------");
        Equipo newEquipo = new Equipo();
        System.out.println("Nombre Equipo:");
        newEquipo.setNombre(InputService.scanner.nextLine());
        newEquipo.setFechaCreacion(LocalDate.now());
        List<Jugador> jugadores = new ArrayList<>();
        newEquipo.setJugadores(jugadores);
        System.out.println("Nombre Cancha:");
        newEquipo.setNombreCancha(InputService.scanner.nextLine());
        return newEquipo;
    }

}
