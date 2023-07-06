package com.info.futbol5.service.jugador.impl;

import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;
import com.info.futbol5.domain.Posicion;
import com.info.futbol5.service.jugador.JugadorService;
import com.info.futbol5.service.entrada.console.impl.InputService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class JugadorServiceImpl implements JugadorService {
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
    public void listarJugadores(List<Jugador> todosLosJugadores) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Lista de Jugadores");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Cantidad: "+ todosLosJugadores.size());
        for (Jugador jugador: todosLosJugadores){
            System.out.println(jugador.toString());
        }
    }

}
