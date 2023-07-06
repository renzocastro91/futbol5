package com.info.futbol5.service.menu.impl;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;
import com.info.futbol5.service.buscarEquipo.BuscarEquipoService;
import com.info.futbol5.service.buscarEquipo.impl.BuscarEquipoServiceImpl;
import com.info.futbol5.service.buscarJugador.BuscarJugadorService;
import com.info.futbol5.service.buscarJugador.impl.BuscarJugadorServiceImpl;
import com.info.futbol5.service.entrada.console.impl.InputService;
import com.info.futbol5.service.entrenador.EntrenadorService;
import com.info.futbol5.service.entrenador.impl.EntrenadorServiceImpl;
import com.info.futbol5.service.equipo.EquipoService;
import com.info.futbol5.service.equipo.impl.ServiceEquipoImpl;
import com.info.futbol5.service.exportarEqupoJugadorEntrenador.ExportarEqupoJugadorEntrenadorService;
import com.info.futbol5.service.exportarEqupoJugadorEntrenador.impl.ExportarEqupoJugadorEntrenadorServiceImpl;
import com.info.futbol5.service.importarEqupoJugadorEntrenador.ImportarEqupoJugadorEntrenadorService;
import com.info.futbol5.service.importarEqupoJugadorEntrenador.impl.ImportarEqupoJugadorEntrenadorServiceImpl;
import com.info.futbol5.service.jugador.JugadorService;
import com.info.futbol5.service.jugador.impl.JugadorServiceImpl;
import com.info.futbol5.service.menu.MenuService;

import java.util.ArrayList;
import java.util.List;

public class MenuServiceImpl implements MenuService {
    static List<Jugador> todosLosJugadores = new ArrayList<>();
    static List<Equipo> todosLosEquipos = new ArrayList<>();
    static List<Entrenador> todosLosEntrenadores = new ArrayList<>();

    private BuscarEquipoService buscarEquipoService = new BuscarEquipoServiceImpl();
    private EquipoService equipoService = new ServiceEquipoImpl();
    private EntrenadorService entrenadorService = new EntrenadorServiceImpl();
    private JugadorService jugadorService = new JugadorServiceImpl();
    private BuscarJugadorService buscarJugadorService = new BuscarJugadorServiceImpl();
    private ImportarEqupoJugadorEntrenadorService importarEqupoJugadorEntrenadorService = new ImportarEqupoJugadorEntrenadorServiceImpl();
    private ExportarEqupoJugadorEntrenadorService exportarEqupoJugadorEntrenadorService = new ExportarEqupoJugadorEntrenadorServiceImpl();


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
                    equipoService.crearEquipo(todosLosEquipos,todosLosJugadores,todosLosEntrenadores);
                    break;
                case 2:
                    buscarJugadorService.buscarJugadorPorNombre(todosLosEquipos);
                    break;
                case 3:
                    buscarEquipoService.buscarEquipoPorNombre(todosLosEquipos,todosLosEntrenadores);
                    break;
                case 4:
                    buscarEquipoService.muestraJugadoresDeEquipo(todosLosEquipos,todosLosEntrenadores);
                    break;
                case 5:
                    equipoService.eliminarEquipo(todosLosEquipos,todosLosJugadores,todosLosEntrenadores);
                    break;
                case 6:
                    todosLosEquipos = importarEqupoJugadorEntrenadorService.importaListaDeEquipos();
                    todosLosJugadores = importarEqupoJugadorEntrenadorService.importaListaDeJugadores(todosLosEquipos, todosLosEntrenadores);
                    todosLosEntrenadores = importarEqupoJugadorEntrenadorService.importaListaDeEntrenadores(todosLosEquipos);
                    break;
                case 7:
                    exportarEqupoJugadorEntrenadorService.exportarListaDeJugadores(todosLosEquipos,todosLosJugadores,todosLosEntrenadores);
                    break;
                case 8:
                    jugadorService.listarJugadores(todosLosJugadores);
                    equipoService.listarEquipos(todosLosEquipos);
                    entrenadorService.listarEntrenadores(todosLosEntrenadores);
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
                    buscarEquipoService.buscarEquipoPorNombreOrdenadoPorNombre(todosLosEquipos,todosLosEntrenadores);
                    break;
                case 2:
                    buscarEquipoService.buscarEquipoPorNombreOrdenadoPorNumeroCamiseta(todosLosEquipos,todosLosEntrenadores);
                    break;
                case 3:
                    buscarEquipoService.buscarEquipoPorNombreOrdenadoPorPosicionyNumeroCamiseta(todosLosEquipos,todosLosEntrenadores);
                    break;
                case 4:
                    exportarEqupoJugadorEntrenadorService.exportarJugadresOrdenadosPorNombre(todosLosEquipos);
                    break;
                case 5:
                    exportarEqupoJugadorEntrenadorService.exportarJugadoresOrdenadosPorNumeroCamiseta(todosLosEquipos);
                    break;
                case 6:
                    exportarEqupoJugadorEntrenadorService.exportarJugadoresOrdenadosPorPosicionYNumeroCamiseta(todosLosEquipos);
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }

        } while (opcion != 0);

    }




}