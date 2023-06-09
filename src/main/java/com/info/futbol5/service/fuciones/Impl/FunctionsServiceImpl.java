package com.info.futbol5.service.fuciones.Impl;

import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;
import com.info.futbol5.domain.Posicion;
import com.info.futbol5.service.CargaDB.ServiceCargaDB;
import com.info.futbol5.service.CargaDB.impl.ServiceCargaDBImpl;
import com.info.futbol5.service.entrada.console.InputServiceInterface;
import com.info.futbol5.service.entrada.console.impl.InputService;
import com.info.futbol5.service.entrada.file.InputFileService;
import com.info.futbol5.service.entrada.file.impl.InputFileServiceImpl;
import com.info.futbol5.service.fuciones.FunctionsService;
import com.info.futbol5.service.salida.file.OutPutFileService;
import com.info.futbol5.service.salida.file.impl.OutPutFileServiceImpl;

import java.time.LocalDate;
import java.util.*;

public class FunctionsServiceImpl implements FunctionsService {
    static List<Jugador> todosLosJugadores = new ArrayList<>();
    static List<List<Jugador>> listaDeListaDeJug =  new ArrayList<>();
    static List<Equipo> todosLosEquipos = new ArrayList<>();
    static List<Entrenador> todosLosEntrenadores = new ArrayList<>();
    @Override
    public void logicaFunciones() {

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
            System.out.println("9. Salir");

            System.out.print("Ingrese una opción: ");
            int opcion = InputService.scanner.nextInt();
            InputService.scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    crearEquipo();
                    break;
                case 2:
                    buscarJugadorPorNombre();
                    break;
                case 3:
                    buscarEquipoPorNombre();
                    break;
                case 4:
                    mostrarJugadoresDeEquipo();
                    break;
                case 5:
                    eliminarEquipo();
                    break;
                case 6:
                    importarListaJugadores();
                    break;
                case 7:
                    exportarListaJugadores();
                    break;
                case 8:
                    System.out.println("-------------------------------------------------------------");
                    System.out.println(todosLosJugadores.size());
                    for (Jugador jugador: todosLosJugadores){
                        System.out.println(jugador.toString());
                    }
                    System.out.println("-------------------------------------------------------------");
                    System.out.println(todosLosEquipos.size());
                    for (Equipo equipo: todosLosEquipos){
                        System.out.println(equipo.toString());
                    }
                    System.out.println("-------------------------------------------------------------");
                    System.out.println(todosLosEntrenadores.size());
                    for (Entrenador entrenador: todosLosEntrenadores){
                        System.out.println(entrenador.toString());
                    }
                    System.out.println("-------------------------------------------------------------");
                    break;
                case 9:
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

    public static void crearEquipo() {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Menu Para la carga de Equipo");
        System.out.println("-------------------------------------------------------------");
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
            while (bandera){
                if (Objects.equals(ent, "s")){
                    newJugador.setEsCapitan(true);
                    bandera = false;
                }else if(Objects.equals(ent, "n")){
                    newJugador.setEsCapitan(false);
                    bandera = false;
                }else{
                    System.out.println("opcion incorrecta Ingrese nuevamente");
                    ent = InputService.scanner.nextLine();
                }
            }
            System.out.println("N° Camiseta:");
            newJugador.setNumeroCamiseta(InputService.scanner.nextInt());
            InputService.scanner.nextLine();
            todosLosJugadores.add(newJugador);
            jugadoresEquipo.add(newJugador);
            cont ++;
        }
        System.out.println("-------------------------------------------------------------");
        System.out.println("Equipo");
        System.out.println("-------------------------------------------------------------");
        Equipo newEquipo = new Equipo();
        System.out.println("Nombre Equipo:");
        newEquipo.setNombre(InputService.scanner.nextLine());
        newEquipo.setFechaCreacion(LocalDate.now());
        newEquipo.setJugadores(jugadoresEquipo);
        System.out.println("Nombre Cancha:");
        newEquipo.setNombreCancha(InputService.scanner.nextLine());
        todosLosEquipos.add(newEquipo);
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
        newEntrenador.setEquipo(newEquipo);
        todosLosEntrenadores.add(newEntrenador);

    }

    public static void buscarJugadorPorNombre() {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Buscar Jugador por nombre");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Ingrese Nombre de jugador a buscar:");
        String nombreJugador =InputService.scanner.nextLine();
        boolean bandera = false;
        for (Equipo equipo: todosLosEquipos) {
            for (Jugador jugador: equipo.getJugadores()) {
                if (Objects.equals(nombreJugador, jugador.getNombre())){
                    System.out.println("Nombre: " + jugador.getNombre());
                    System.out.println("Apellido: " + jugador.getApellido());
                    System.out.println("Posicion: "+ jugador.getPosicion().getNombre());
                    System.out.println("Capitan: "+ jugador.getEsCapitan());
                    System.out.println("Equipo: "+ equipo.getNombre());
                    bandera = true;
                }
            }
        }
        if (!bandera){
            System.out.println("Jugador no encontrado");
        }

    }

    public static void buscarEquipoPorNombre() {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Buscar Equipo por nombre");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Ingrese Nombre de equipo a buscar:");
        String nombreEquipo = InputService.scanner.nextLine();
        boolean bandera = false;
        for (Equipo equipo: todosLosEquipos) {
            if (Objects.equals(nombreEquipo, equipo.getNombre())){
                System.out.println("Nombre: "+ equipo.getNombre());
                for (Entrenador entrenador: todosLosEntrenadores) {
                    if (Objects.equals(entrenador.getEquipo().getNombre(), equipo.getNombre())) {
                        System.out.println("Entrenador: " + entrenador.getNombre());
                    }
                }
                for (Jugador jugador: equipo.getJugadores()) {
                    if (jugador.getEsCapitan()){
                        System.out.println("Capitan: "+ jugador.getNombre());
                    }
                }
                bandera = true;
            }
        }
        if (!bandera){
            System.out.println("Equipo No encontrado");
        }
    }

    public static void mostrarJugadoresDeEquipo() {
        System.out.println("-------------------------------------------------------------");
        System.out.println("Buscar Equipo por nombre y lista jugadores");
        System.out.println("-------------------------------------------------------------");
        System.out.println("Ingrese Nombre de equipo a buscar:");
        String nombreEquipo = InputService.scanner.nextLine();
        boolean bandera = false;
        for (Equipo equipo: todosLosEquipos) {
            if (Objects.equals(nombreEquipo, equipo.getNombre())){
                System.out.println("Nombre: "+ equipo.getNombre());
                for (Entrenador entrenador: todosLosEntrenadores) {
                    if (Objects.equals(entrenador.getEquipo().getNombre(), equipo.getNombre())) {
                        System.out.println("Entrenador: " + entrenador.getNombre());
                    }
                }
                for (Jugador jugador: equipo.getJugadores()) {
                    System.out.println("Nombre: "+ jugador.getNombre() + " " + jugador.getPosicion().getNombre());
                }
                bandera = true;
            }
        }
        if (!bandera){
            System.out.println("Equipo No encontrado");
        }
    }

    public static void eliminarEquipo() {
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

    public static void importarListaJugadores() {
        System.out.println("-----------------------------------------------------------------------");
        ServiceCargaDB servicioCargaDB = new ServiceCargaDBImpl();
        String rutaArchivoJ = "src\\main\\java\\com\\info\\futbol5\\resources\\jugador_IO.txt";
        String rutaArchivoE = "src\\main\\java\\com\\info\\futbol5\\resources\\equipo_IO.txt";
        String rutaArchivoEn = "src\\main\\java\\com\\info\\futbol5\\resources\\entrenador_IO.txt";
        todosLosJugadores = servicioCargaDB.cargaJugadores(rutaArchivoJ);
        InputFileService inputFileService = new InputFileServiceImpl();
        listaDeListaDeJug = inputFileService.loadListadeListadeJugadores(todosLosJugadores);
        todosLosEquipos =servicioCargaDB.cargaEquipos(listaDeListaDeJug,rutaArchivoE);
        todosLosEntrenadores = servicioCargaDB.cargaEntrenadores(todosLosEquipos,rutaArchivoEn);
        System.out.println("Archivos de Jugadores, Equipos y Entrenadores importados con éxito");
    }

    public static void exportarListaJugadores() {
        System.out.println("-------------------------------------------------------------------------");
        OutPutFileService outPutFileService= new OutPutFileServiceImpl();
        String rutaArchivoSalida = "src\\main\\java\\com\\info\\futbol5\\resources\\pruebasalida.txt";
        String rutaArchivoSalida1 = "src\\main\\java\\com\\info\\futbol5\\resources\\pruebasalida1.txt";
        String rutaArchivoSalida2 = "src\\main\\java\\com\\info\\futbol5\\resources\\pruebasalida2.txt";
        outPutFileService.exportJugadores(todosLosJugadores, rutaArchivoSalida);
        outPutFileService.exportarEquipos(todosLosEquipos, rutaArchivoSalida1);
        outPutFileService.exportarEntrenador(todosLosEntrenadores, rutaArchivoSalida2);
        System.out.println("Archivos de Jugadores, Equipos y Entrenadores exportados con éxito");
    }


}
