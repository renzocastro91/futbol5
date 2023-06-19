package com.info.futbol5.service.fuciones.menu.Impl;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;
import com.info.futbol5.service.entrada.console.impl.InputService;
import com.info.futbol5.service.fuciones.buscarEquipoPorNombre.BuscarEquipoXNombreService;
import com.info.futbol5.service.fuciones.buscarEquipoPorNombre.impl.BuscarEquipoXNombreServiceImpl;
import com.info.futbol5.service.fuciones.buscarEquipoPorNombreOrdenadoPorCamiseta.BuscarEquipoPorNombreOrdenadoPorCamisetaService;
import com.info.futbol5.service.fuciones.buscarEquipoPorNombreOrdenadoPorCamiseta.impl.BuscarEquipoPorNombreOrdenadoPorCamisetaServiceImpl;
import com.info.futbol5.service.fuciones.buscarEquipoPorNombreOrdenadoPorNombre.BuscarEquipoXNombreOrdenadoXNombre;
import com.info.futbol5.service.fuciones.buscarEquipoPorNombreOrdenadoPorNombre.impl.BuscarEquipoXNombreOrdenadoXNombreServiceImpl;
import com.info.futbol5.service.fuciones.buscarEquipoporNombreOrdenadoPorPosicionYCamiseta.BuscarEquipoXNomOrdenadoXPosYCamService;
import com.info.futbol5.service.fuciones.buscarEquipoporNombreOrdenadoPorPosicionYCamiseta.impl.BuscarEquipoXNomOrdenadoXPosYCamServiceImpl;
import com.info.futbol5.service.fuciones.buscarJugadorPorNombre.BuscarJugadorXNombreService;
import com.info.futbol5.service.fuciones.buscarJugadorPorNombre.impl.BuscarJugadorXNombreServiceImpl;
import com.info.futbol5.service.fuciones.crearEquipo.CrearEquipoService;
import com.info.futbol5.service.fuciones.crearEquipo.impl.CrearEquipoImpl;
import com.info.futbol5.service.fuciones.eliminaarEquipo.EliminarEquipoService;
import com.info.futbol5.service.fuciones.eliminaarEquipo.impl.EliminarEquipoServiceImpl;
import com.info.futbol5.service.fuciones.exportarJugadoresOrdenadosPorNombre.ExportarJugadoresOrdenadosPorNombreService;
import com.info.futbol5.service.fuciones.exportarJugadoresOrdenadosPorNombre.impl.ExportarJugadoresOrdenadosPorNombreServiceImpl;
import com.info.futbol5.service.fuciones.exportarJugadoresOrdenadosPorNumCamiseta.ExportarJugadoresOrdenadosXNumCamisetaService;
import com.info.futbol5.service.fuciones.exportarJugadoresOrdenadosPorNumCamiseta.impl.ExportarJugadoresOrdenadosXNumCamisetaServiceImpl;
import com.info.futbol5.service.fuciones.exportarJugadoresPorPosicionYCamiseta.ExportarJugadoresOrdenadosXPosYCamService;
import com.info.futbol5.service.fuciones.exportarJugadoresPorPosicionYCamiseta.impl.ExportarJugadoresOrdenadosXPosYCamServiceImpl;
import com.info.futbol5.service.fuciones.exportarListaDeJugadores.ExportarListaDeJugadoresService;
import com.info.futbol5.service.fuciones.exportarListaDeJugadores.impl.ExportarListaDeJugadoresServiceImpl;
import com.info.futbol5.service.fuciones.importarListasDeJugadores.ImportarListaDeJugadoresService;
import com.info.futbol5.service.fuciones.importarListasDeJugadores.impl.ImportarListaDeJugadoresServiceImpl;
import com.info.futbol5.service.fuciones.listarTodo.ListarTodoService;
import com.info.futbol5.service.fuciones.listarTodo.impl.ListarTodoServiceImpl;
import com.info.futbol5.service.fuciones.menu.FunctionsService;
import com.info.futbol5.service.fuciones.mostrarJugadoresDeEquipo.MostrarJugadoresDeEquipoService;
import com.info.futbol5.service.fuciones.mostrarJugadoresDeEquipo.impl.MostrarJugadoresDeEquipoServiceImpl;

import java.util.*;



public class FunctionsServiceImpl implements FunctionsService {
    static List<Jugador> todosLosJugadores = new ArrayList<>();
    static List<Equipo> todosLosEquipos = new ArrayList<>();
    static List<Entrenador> todosLosEntrenadores = new ArrayList<>();
    @Override
    public void logicaFunciones() {

        boolean salir = false;
        InputService.createScanner();
        while (!salir) {
            clearScreen();
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
                    CrearEquipoService crearEquipoService = new CrearEquipoImpl();
                    crearEquipoService.creoEquipo(todosLosEquipos,todosLosJugadores,todosLosEntrenadores);
                    break;
                case 2:
                    BuscarJugadorXNombreService buscarJugadorXNombreService = new BuscarJugadorXNombreServiceImpl();
                    buscarJugadorXNombreService.buscaJugadorxNombre(todosLosEquipos);
                    break;
                case 3:
                    BuscarEquipoXNombreService buscarEquipoXNombreService = new BuscarEquipoXNombreServiceImpl();
                    buscarEquipoXNombreService.buscaEquipoXNombre(todosLosEquipos,todosLosEntrenadores);
                    break;
                case 4:
                    MostrarJugadoresDeEquipoService mostrarJugadoresDeEquipoService = new MostrarJugadoresDeEquipoServiceImpl();
                    mostrarJugadoresDeEquipoService.muestraJugadoresDeEquipo(todosLosEquipos,todosLosEntrenadores);
                    break;
                case 5:
                    EliminarEquipoService eliminarEquipoService = new EliminarEquipoServiceImpl();
                    eliminarEquipoService.eliminaEquipo(todosLosEquipos,todosLosJugadores,todosLosEntrenadores);
                    break;
                case 6:
                    ImportarListaDeJugadoresService importarListaDeJugadoresService = new ImportarListaDeJugadoresServiceImpl();
                    todosLosEquipos = importarListaDeJugadoresService.importaListaDeEquipos();
                    todosLosJugadores = importarListaDeJugadoresService.importaListaDeJugadores(todosLosEquipos);
                    todosLosEntrenadores = importarListaDeJugadoresService.importaListaDeEntrenadores(todosLosEquipos);
                    break;
                case 7:
                    ExportarListaDeJugadoresService exportarListaDeJugadoresService = new ExportarListaDeJugadoresServiceImpl();
                    exportarListaDeJugadoresService.exporteListaDeJugadores(todosLosEquipos,todosLosJugadores,todosLosEntrenadores);
                    break;
                case 8:
                    ListarTodoService listarTodoService = new ListarTodoServiceImpl();
                    listarTodoService.listaTodo(todosLosEquipos,todosLosJugadores,todosLosEntrenadores);
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
            clearScreen();
        }

        System.out.println("¡Hasta luego!");
        InputService.scanner.close();

    }

    private void masOpciones() {
        int opcion;
        do {
            clearScreen();
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
                    BuscarEquipoXNombreOrdenadoXNombre buscarEquipoXNombreOrdenadoXNombre = new BuscarEquipoXNombreOrdenadoXNombreServiceImpl();
                    buscarEquipoXNombreOrdenadoXNombre.busqueEquipoXNombreOrdenadoXNombre(todosLosEquipos,todosLosEntrenadores);
                    break;
                case 2:
                    BuscarEquipoPorNombreOrdenadoPorCamisetaService buscarEquipoPorNombreOrdenadoPorCamisetaService = new BuscarEquipoPorNombreOrdenadoPorCamisetaServiceImpl();
                    buscarEquipoPorNombreOrdenadoPorCamisetaService.busqueEquipoPorNombreOrdenadoPorCamiseta(todosLosEquipos,todosLosEntrenadores);
                    break;
                case 3:
                    BuscarEquipoXNomOrdenadoXPosYCamService buscarEquipoXNomOrdenadoXPosYCamService = new BuscarEquipoXNomOrdenadoXPosYCamServiceImpl();
                    buscarEquipoXNomOrdenadoXPosYCamService.busqueEquipoXNomOrdenadoXPosyCam(todosLosEquipos,todosLosEntrenadores);
                    break;
                case 4:
                    ExportarJugadoresOrdenadosPorNombreService exportarJugadoresOrdenadosPorNombreService = new ExportarJugadoresOrdenadosPorNombreServiceImpl();
                    exportarJugadoresOrdenadosPorNombreService.exporteJugadresOrdenadosXNombre(todosLosEquipos);
                    break;
                case 5:
                    ExportarJugadoresOrdenadosXNumCamisetaService exportarJugadoresOrdenadosXNumCamisetaService = new ExportarJugadoresOrdenadosXNumCamisetaServiceImpl();
                    exportarJugadoresOrdenadosXNumCamisetaService.exporteJugadoresOrdenadosXNumCamiseta(todosLosEquipos);
                    break;
                case 6:
                    ExportarJugadoresOrdenadosXPosYCamService exportarJugadoresOrdenadosXPosYCamService = new ExportarJugadoresOrdenadosXPosYCamServiceImpl();
                    exportarJugadoresOrdenadosXPosYCamService.exporteJugadoresOrdenadosXPosYCam(todosLosEquipos);
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }

        } while (opcion != 0);

    }


    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
