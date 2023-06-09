package com.info.futbol5;


import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;
import com.info.futbol5.domain.Posicion;
import com.info.futbol5.service.CargaDB.ServiceCargaDB;
import com.info.futbol5.service.CargaDB.impl.ServiceCargaDBImpl;
import com.info.futbol5.service.entrada.file.InputFileService;
import com.info.futbol5.service.entrada.file.impl.InputFileServiceImpl;

import javax.sound.midi.Soundbank;
import java.time.LocalDate;
import java.util.*;

/**
 * Main Futbol 5
 *
 */
public class App 
{
    private static Scanner scanner = new Scanner(System.in);
    static ServiceCargaDB servicioCargaDB = new ServiceCargaDBImpl();
    static String rutaArchivoJ = "src\\main\\java\\com\\info\\futbol5\\resources\\jugador_IO.txt";
    static String rutaArchivoE = "src\\main\\java\\com\\info\\futbol5\\resources\\equipo_IO.txt";
    static String rutaArchivoEn = "src\\main\\java\\com\\info\\futbol5\\resources\\entrenador_IO.txt";
    static List<Jugador> todosLosJugadores = servicioCargaDB.cargaJugadores(rutaArchivoJ);
    static InputFileService inputFileService = new InputFileServiceImpl();
    static List<List<Jugador>> listaDeListaDeJug = inputFileService.loadListadeListadeJugadores(todosLosJugadores);
    static List<Equipo> todosLosEquipos =servicioCargaDB.cargaEquipos(listaDeListaDeJug,rutaArchivoE);
    static List<Entrenador> todosLosEntrenadores = servicioCargaDB.cargaEntrenadores(todosLosEquipos,rutaArchivoEn);

    public static void main( String[] args )  {

        boolean salir = false;

        while (!salir) {
            System.out.println("----- MENÚ -----");
            System.out.println("1. Crear un equipo, sus jugadores y entrenador");
            System.out.println("2. Buscar un jugador por su nombre");
            System.out.println("3. Buscar un equipo por su nombre");
            System.out.println("4. Mostrar jugadores de un equipo");
            System.out.println("5. Eliminar un equipo");
            System.out.println("6. Importar lista de jugadores desde archivo");
            System.out.println("7. Exportar lista de jugadores a archivo");
            System.out.println("8. Salir");

            System.out.print("Ingrese una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

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
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        }

        System.out.println("¡Hasta luego!");
        scanner.close();


  }
    //NOTA PARA EL PROFE, lo hago de esta manera la carga porque por algún motivo con el servicio que cree la entrada
    //por teclado con scanner, a la hora de hacer entrar datos, me saltaba como si fuera que yo le di a enter y entró eso
    // por ejemplo pedia nombre, entraba, luego cuando pasaba a apellido no me dejaba entrar nada y saltaba al siguiente
    // investigue pero no encontré nada, ni por IA supe como solucionar, no entiendo el error sinceramente, por qué para
    //algunos casos funciona el scanner y para otros no, pero eso pasa con el servicio nomás

    public static void crearEquipo() {
        System.out.println("Menu Para la carga de Equipo");
        System.out.println("------------------------------------------");
        System.out.println("Jugadores");
        System.out.println("------------------------------------------");
        int cont = 0;
        List<Jugador> jugadoresEquipo = new ArrayList<>();
        String[] posiciones = {"Arquero", "Defensor", "Mediocampista","Mediocampista" ,"Delantero"};
        for (int i=0; i < 5; i++){
            System.out.println(posiciones[cont]);
            Jugador newJugador = new Jugador();
            System.out.println("Nombre:");
            newJugador.setNombre(getScanner().nextLine());
            System.out.println("Apellido:");
            newJugador.setApellido(getScanner().nextLine());
            System.out.println("Sexo:");
            newJugador.setSexo(getScanner().nextLine());
            System.out.println("Año Nacimiento:");
            newJugador.setAnioNacimiento(getScanner().nextInt());
            newJugador.calcularEdad();
            UUID id = UUID.randomUUID();
            newJugador.setId(id);
            System.out.println("Altura:");
            newJugador.setAltura(getScanner().nextDouble());
            Posicion newPosicion = new Posicion();
            newPosicion.setNombre(posiciones[cont]);
            newJugador.setPosicion(newPosicion);
            System.out.println("Goles:");
            newJugador.setGoles(getScanner().nextInt());
            System.out.println("Partidos:");
            newJugador.setPartidos(getScanner().nextInt());
            System.out.println("Es Capitan? s o n");
            String ent = getScanner().nextLine();
            boolean bandera = true;
            while (bandera){
                if (Objects.equals(ent, "s")){
                    newJugador.setEsCapitan(true);
                    bandera = false;
                }else if(Objects.equals(ent, "n")){
                    newJugador.setEsCapitan(false);
                    bandera = false;
                }else{
                    System.out.println("opcion incorrecta");
                }
            }
            System.out.println("N° Camiseta:");
            newJugador.setNumeroCamiseta(getScanner().nextInt());
            todosLosJugadores.add(newJugador);
            jugadoresEquipo.add(newJugador);
            cont ++;
        }
        System.out.println("------------------------------------------");
        System.out.println("Equipo");
        System.out.println("------------------------------------------");
        Equipo newEquipo = new Equipo();
        System.out.println("Nombre Equipo:");
        newEquipo.setNombre(getScanner().nextLine());
        newEquipo.setFechaCreacion(LocalDate.now());
        newEquipo.setJugadores(jugadoresEquipo);
        System.out.println("Nombre Cancha:");
        newEquipo.setNombreCancha(getScanner().nextLine());
        todosLosEquipos.add(newEquipo);
        System.out.println("------------------------------------------");
        System.out.println("Entrenador");
        System.out.println("------------------------------------------");
        Entrenador newEntrenador = new Entrenador();
        System.out.println("Nombre:");
        newEntrenador.setNombre(getScanner().nextLine());
        System.out.println("Apellido:");
        newEntrenador.setApellido(getScanner().nextLine());
        System.out.println("Sexo:");
        newEntrenador.setSexo(getScanner().nextLine());
        System.out.println("Año Nacimiento:");
        newEntrenador.setAnioNacimiento(getScanner().nextInt());
        newEntrenador.calcularEdad();
        newEntrenador.setEquipo(newEquipo);

    }

    public static void buscarJugadorPorNombre() {
        System.out.println("------------------------------------------");
        System.out.println("Buscar Jugador por nombre");
        System.out.println("------------------------------------------");
        System.out.println("Ingrese Nombre de jugador a buscar:");
        String nombreJugador = getScanner().nextLine();
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
        System.out.println("------------------------------------------");
        System.out.println("Buscar Equipo por nombre");
        System.out.println("------------------------------------------");
        System.out.println("Ingrese Nombre de equipo a buscar:");
        String nombreEquipo = getScanner().nextLine();
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
        System.out.println("------------------------------------------");
        System.out.println("Buscar Equipo por nombre y lista jugadores");
        System.out.println("------------------------------------------");
        System.out.println("Ingrese Nombre de equipo a buscar:");
        String nombreEquipo = getScanner().nextLine();
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
        // Implementar la lógica para eliminar un equipo
    }

    public static void importarListaJugadores() {
        // Implementar la lógica para importar la lista de jugadores desde un archivo
    }

    public static void exportarListaJugadores() {
        // Implementar la lógica para exportar la lista de jugadores a un archivo
    }

    public static Scanner getScanner() {
        return scanner;
    }

}
