package com.info.futbol5.service.menu.impl;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;
import com.info.futbol5.service.buscarEquipo.BuscarEquipoService;
import com.info.futbol5.service.buscarEquipo.impl.BuscarEquipoServiceImpl;
import com.info.futbol5.service.buscarJugador.BuscarJugadorService;
import com.info.futbol5.service.buscarJugador.impl.BuscarJugadorServiceImpl;
import com.info.futbol5.service.entrada.console.impl.InputService;
import com.info.futbol5.service.creacionEquipo.ServiceEquipo;
import com.info.futbol5.service.creacionEquipo.impl.ServiceEquipoImpl;
import com.info.futbol5.service.exportarEJE.ExportarEJEService;
import com.info.futbol5.service.exportarEJE.impl.ExportarEJEServiceImpl;
import com.info.futbol5.service.importarEJE.ImportarEJEService;
import com.info.futbol5.service.importarEJE.impl.ImportarEJEServiceImpl;
import com.info.futbol5.service.menu.MenuService;

import java.util.ArrayList;
import java.util.List;

public class MenuServiceImpl implements MenuService {
    static List<Jugador> todosLosJugadores = new ArrayList<>();
    static List<Equipo> todosLosEquipos = new ArrayList<>();
    static List<Entrenador> todosLosEntrenadores = new ArrayList<>();

    private BuscarEquipoService buscarEquipoService = new BuscarEquipoServiceImpl();
    private ServiceEquipo serviceEquipo = new ServiceEquipoImpl();
    private BuscarJugadorService buscarJugadorService = new BuscarJugadorServiceImpl();
    private ImportarEJEService importarEJEService = new ImportarEJEServiceImpl();
    private ExportarEJEService exportarEJEService = new ExportarEJEServiceImpl();


    @Override
    public void menu() {
        boolean salir = false;
        InputService.createScanner();
        while (!salir) {
            System.out.println("-------------------------------------------------------------");
            System.out.println("----- MENÚ -----");
            System.out.println("-------------------------------------------------------------");
            System.out.println("1. Crear un equipo, sus jugadores y entrenador");
            System.out.println("2. Buscar un jugador por su nombre");
            System.out.println("3. Buscar un equipo por su nombre");
            System.out.println("4. Mostrar jugadores de un equipo");
            System.out.println("5. Eliminar un equipo");
            System.out.println("6. Importar lista de jugadores desde archivo");
            System.out.println("7. Exportar lista de jugadores a archivo");
            System.out.println("8. Listar todo");
            System.out.println("9. Mas Opciones");
            System.out.println("0. Salir");

            System.out.print("Ingrese una opción: ");
            int opcion = InputService.scanner.nextInt();
            InputService.scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    serviceEquipo.creoEquipo(todosLosEquipos,todosLosJugadores,todosLosEntrenadores);
                    break;
                case 2:
                    buscarJugadorService.buscaJugadorxNombre(todosLosEquipos);
                    break;
                case 3:
                    buscarEquipoService.buscaEquipoXNombre(todosLosEquipos,todosLosEntrenadores);
                    break;
                case 4:
                    buscarEquipoService.muestraJugadoresDeEquipo(todosLosEquipos,todosLosEntrenadores);
                    break;
                case 5:
                    serviceEquipo.eliminaEquipo(todosLosEquipos,todosLosJugadores,todosLosEntrenadores);
                    break;
                case 6:
                    todosLosEquipos = importarEJEService.importaListaDeEquipos();
                    todosLosJugadores = importarEJEService.importaListaDeJugadores(todosLosEquipos, todosLosEntrenadores);
                    todosLosEntrenadores = importarEJEService.importaListaDeEntrenadores(todosLosEquipos);
                    break;
                case 7:
                    exportarEJEService.exporteListaDeJugadores(todosLosEquipos,todosLosJugadores,todosLosEntrenadores);
                    break;
                case 8:
                    listaTodo(todosLosEquipos,todosLosJugadores,todosLosEntrenadores);
                    break;
                case 9:
                    masOpciones();
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }

        }
        System.out.println("¡Hasta luego!");
        InputService.scanner.close();
    }
    private void masOpciones() {
        int opcion;
        do {
            System.out.println("----- Mas Opciones -----");
            System.out.println("1. Buscar equipo por nombre (ordenado por nombre)");
            System.out.println("2. Buscar equipo por nombre (ordenado por número de camiseta)");
            System.out.println("3. Buscar equipo por nombre (ordenado por posición y número de camiseta)");
            System.out.println("4. Exportar jugadores ordenados por nombre");
            System.out.println("5. Exportar jugadores ordenados por número de camiseta");
            System.out.println("6. Exportar jugadores ordenados por posición y número de camiseta");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = InputService.scanner.nextInt();
            InputService.scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    buscarEquipoService.busqueEquipoXNombreOrdenadoXNombre(todosLosEquipos,todosLosEntrenadores);
                    break;
                case 2:
                    buscarEquipoService.busqueEquipoPorNombreOrdenadoPorCamiseta(todosLosEquipos,todosLosEntrenadores);
                    break;
                case 3:
                    buscarEquipoService.busqueEquipoXNomOrdenadoXPosyCam(todosLosEquipos,todosLosEntrenadores);
                    break;
                case 4:
                    exportarEJEService.exporteJugadresOrdenadosXNombre(todosLosEquipos);
                    break;
                case 5:
                    exportarEJEService.exporteJugadoresOrdenadosXNumCamiseta(todosLosEquipos);
                    break;
                case 6:
                    exportarEJEService.exporteJugadoresOrdenadosXPosYCam(todosLosEquipos);
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }

        } while (opcion != 0);

    }

    private void listaTodo(List<Equipo> todosLosEquipos, List<Jugador> todosLosJugadores, List<Entrenador> todosLosEntrenadores) {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Jugadores");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Cantidad: "+ todosLosJugadores.size());
        for (Jugador jugador: todosLosJugadores){
            System.out.println(jugador.toString());
        }
        System.out.println("-------------------------------------------------------------");
        System.out.println("Equipos");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Cantidad: "+todosLosEquipos.size());
        for (Equipo equipo: todosLosEquipos){
            System.out.println(equipo.toString());
        }
        System.out.println("-------------------------------------------------------------");
        System.out.println("Entrenadores");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Cantidad: "+todosLosEntrenadores.size());
        for (Entrenador entrenador: todosLosEntrenadores){
            System.out.println(entrenador.toString());
        }
        System.out.println("-------------------------------------------------------------");
    }
}