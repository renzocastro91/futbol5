package com.info.futbol5;
import com.info.futbol5.service.entrada.file.InputFileService;
import com.info.futbol5.service.entrada.file.impl.InputFileServiceImpl;
import com.info.futbol5.service.entrenador.impl.ServiceEntrenadorImpl;
import com.info.futbol5.service.equipo.impl.ServiceEquipoImpl;
import com.info.futbol5.domain.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Main Futbol 5
 *
 */
public class App 
{
    public static void main( String[] args )
  {     InputFileService inputFileService = new InputFileServiceImpl();

        /*System.out.println("Creación de equipo");
        ServiceEquipoImpl equipoS = new ServiceEquipoImpl();
        Equipo nuevoEquipo = equipoS.crearEquipo();
        ServiceEntrenadorImpl entrenadorS = new ServiceEntrenadorImpl();
        Entrenador nuevoEntrenador = entrenadorS.crearEntrenador(nuevoEquipo);
        System.out.println("Datos Entrenador");
        System.out.println(nuevoEntrenador);
        System.out.println("Datos del equipo");
        System.out.println(nuevoEquipo);*/

      String rutaArchivoJ = "F:\\ProyectosMaven\\futbol5\\src\\main\\java\\com\\info\\futbol5\\resources\\jugador_IO.txt";
      String rutaArchivoE = "F:\\ProyectosMaven\\futbol5\\src\\main\\java\\com\\info\\futbol5\\resources\\equipo_IO.txt";
      String rutaArchivoEn = "F:\\ProyectosMaven\\futbol5\\src\\main\\java\\com\\info\\futbol5\\resources\\entranador_IO.txt";
      List<Jugador> jugadores = inputFileService.loadJugadorByFile(rutaArchivoJ);
      List<Equipo> equipos = inputFileService.loadEquipoByFile(rutaArchivoE, jugadores);
      List<Entrenador> entrenadores = inputFileService.loadEntranadorByFile(rutaArchivoEn, equipos);

      System.out.println("-------------------------------------------------------------");
      System.out.println(jugadores.size());
      for (Jugador jugador: jugadores){
          System.out.println(jugador.toString());
      }
      System.out.println("-------------------------------------------------------------");
      System.out.println(equipos.size());
      for (Equipo equipo: equipos){
          System.out.println(equipo.toString());
      }
      System.out.println("-------------------------------------------------------------");
      System.out.println(entrenadores.size());
      for (Entrenador entrenador: entrenadores){
          System.out.println(entrenador.toString());
      }
      System.out.println("-------------------------------------------------------------");
    }
}
