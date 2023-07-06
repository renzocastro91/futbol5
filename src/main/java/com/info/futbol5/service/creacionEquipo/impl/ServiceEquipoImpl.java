package com.info.futbol5.service.creacionEquipo.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;
import com.info.futbol5.domain.Posicion;
import com.info.futbol5.service.creacionEquipo.ServiceEquipo;
import com.info.futbol5.service.entrada.console.impl.InputService;


public class ServiceEquipoImpl implements ServiceEquipo {

    @Override
    public void creoEquipo(List<Equipo> todosLosEquipos, List<Jugador> todosLosJugadores, List<Entrenador> todosLosEntrenadores) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Menu Para la carga de Equipo");
        System.out.println("-------------------------------------------------------------");
        Equipo newEquipo = crearEquipo();
        todosLosEquipos.add(newEquipo);
        List<Jugador> jugadoresEquipo = crearJugadores(newEquipo);
        for (Jugador jugador: jugadoresEquipo ) {
            todosLosJugadores.add(jugador);
            newEquipo.getJugadores().add(jugador);
        }
        Entrenador newEntrenador = crearEntrenador(newEquipo);
        todosLosEntrenadores.add(newEntrenador);
        System.out.println("-------------------------------------------------------------");
        System.out.println("Carga de equipo exitoso!");
        System.out.println("-------------------------------------------------------------");
    }

    @Override
    public void eliminaEquipo(List<Equipo> todosLosEquipos, List<Jugador> todosLosJugadores, List<Entrenador> todosLosEntrenadores) {
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
    public List<Jugador> crearJugadores(Equipo equipo) {
        System.out.println("Jugadores");
        System.out.println("-------------------------------------------------------------");
        int cont = 0;
        List<Jugador> jugadoresEquipo = new ArrayList<>();
        String[] posiciones = {"Arquero", "Defensor", "Mediocampista","Mediocampista" ,"Delantero"};
        for (int i=0; i < 5; i++){
            System.out.println(posiciones[cont]);
            Jugador newJugador = new Jugador();
            System.out.println("Nombre:");
            newJugador.setNombre(InputService.scanner.nextLine());
            System.out.println("Apellido:");
            newJugador.setApellido(InputService.scanner.nextLine());
            System.out.println("Sexo:");
            newJugador.setSexo(InputService.scanner.nextLine());
            System.out.println("Año Nacimiento:");
            newJugador.setAnioNacimiento(InputService.scanner.nextInt());
            InputService.scanner.nextLine();
            newJugador.calcularEdad();
            UUID id = UUID.randomUUID();
            newJugador.setId(id);
            System.out.println("Altura:");
            newJugador.setAltura(InputService.scanner.nextDouble());
            InputService.scanner.nextLine();
            Posicion newPosicion = new Posicion();
            newPosicion.setNombre(posiciones[cont]);
            newJugador.setPosicion(newPosicion);
            System.out.println("Goles:");
            newJugador.setGoles(InputService.scanner.nextInt());
            InputService.scanner.nextLine();
            System.out.println("Partidos:");
            newJugador.setPartidos(InputService.scanner.nextInt());
            InputService.scanner.nextLine();
            System.out.println("Es Capitan? s o n");
            String ent = InputService.scanner.nextLine();
            boolean bandera = true;
            while (bandera) {
                if (Objects.equals(ent, "s")) {
                    // Verificar si ya existe un capitán en el equipo
                    boolean existeCapitan = jugadoresEquipo.stream().anyMatch(Jugador::isEsCapitan);
                    if (existeCapitan) {
                        System.out.println("Ya existe un capitán en el equipo.");
                        System.out.println("Seleccione otra opción:");
                        ent = InputService.scanner.nextLine();
                    } else {
                        newJugador.setEsCapitan(true);
                        bandera = false;
                    }
                } else if (Objects.equals(ent, "n")) {
                    newJugador.setEsCapitan(false);
                    bandera = false;
                } else {
                    System.out.println("Opción incorrecta. Ingrese nuevamente:");
                    ent = InputService.scanner.nextLine();
                }
            }

            System.out.println("N° Camiseta:");
            int numeroCamiseta = InputService.scanner.nextInt();
            InputService.scanner.nextLine();

            int finalNumeroCamiseta = numeroCamiseta;
            boolean numeroCamisetaExistente = jugadoresEquipo.stream()
                    .anyMatch(jugador -> jugador.getNumeroCamiseta() == finalNumeroCamiseta);

            while (numeroCamisetaExistente) {
                System.out.println("El número de camiseta ya está en uso.");
                System.out.println("Ingrese otro número de camiseta:");
                numeroCamiseta = InputService.scanner.nextInt();
                InputService.scanner.nextLine();

                int finalNumeroCamiseta1 = numeroCamiseta;
                numeroCamisetaExistente = jugadoresEquipo.stream()
                        .anyMatch(jugador -> jugador.getNumeroCamiseta() == finalNumeroCamiseta1);
            }

            newJugador.setNumeroCamiseta(numeroCamiseta);
            newJugador.setEquipo(equipo);
            jugadoresEquipo.add(newJugador);
            cont ++;
        }
        return jugadoresEquipo;
    }

    @Override
    public Entrenador crearEntrenador(Equipo equipo){
        System.out.println("-------------------------------------------------------------");
        System.out.println("Entrenador");
        System.out.println("-------------------------------------------------------------");
        Entrenador newEntrenador = new Entrenador();
        System.out.println("Nombre:");
        newEntrenador.setNombre(InputService.scanner.nextLine());
        System.out.println("Apellido:");
        newEntrenador.setApellido(InputService.scanner.nextLine());
        System.out.println("Sexo:");
        newEntrenador.setSexo(InputService.scanner.nextLine());
        System.out.println("Año Nacimiento:");
        newEntrenador.setAnioNacimiento(InputService.scanner.nextInt());
        InputService.scanner.nextLine();
        newEntrenador.calcularEdad();
        newEntrenador.setEquipo(equipo);
        return newEntrenador;
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
