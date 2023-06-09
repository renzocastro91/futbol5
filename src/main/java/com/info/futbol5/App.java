package com.info.futbol5;


import com.info.futbol5.domain.Entrenador;
import com.info.futbol5.domain.Equipo;
import com.info.futbol5.domain.Jugador;
import com.info.futbol5.service.CargaDB.ServiceCargaDB;
import com.info.futbol5.service.CargaDB.impl.ServiceCargaDBImpl;
import com.info.futbol5.service.entrada.file.InputFileService;
import com.info.futbol5.service.entrada.file.impl.InputFileServiceImpl;

import java.util.List;
import java.util.Scanner;

/**
 * Main Futbol 5
 *
 */
public class App 
{
    private static Scanner scanner = new Scanner(System.in);
    ServiceCargaDB servicioCargaDB = new ServiceCargaDBImpl();
    String rutaArchivoJ = "src\\main\\java\\com\\info\\futbol5\\resources\\jugador_IO.txt";
    String rutaArchivoE = "src\\main\\java\\com\\info\\futbol5\\resources\\equipo_IO.txt";
    String rutaArchivoEn = "src\\main\\java\\com\\info\\futbol5\\resources\\entrenador_IO.txt";
    List<Jugador> todosLosJugadores = servicioCargaDB.cargaJugadores(rutaArchivoJ);
    List<Equipo> todosLosEquipos =servicioCargaDB.cargaEquipos(todosLosJugadores,rutaArchivoE);
    List<Entrenador> todosLosEntrenadores = servicioCargaDB.cargaEntrenadores(todosLosEquipos,rutaArchivoEn);
    public static void main( String[] args )
  {
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
        //Creamos Equipo con todos sus componentes

    }

    public static void buscarJugadorPorNombre() {
        // Implementar la lógica para buscar un jugador por su nombre
    }

    public static void buscarEquipoPorNombre() {
        // Implementar la lógica para buscar un equipo por su nombre
    }

    public static void mostrarJugadoresDeEquipo() {
        // Implementar la lógica para mostrar los jugadores de un equipo
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
