package com.info.futbol5;
import com.info.futbol5.service.entrenador.impl.ServiceEntrenadorImpl;
import com.info.futbol5.service.equipo.impl.ServiceEquipoImpl;
import com.info.futbol5.domain.*;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Creación de equipo");
        ServiceEquipoImpl equipoS = new ServiceEquipoImpl();
        Equipo nuevoEquipo = equipoS.crearEquipo();
        ServiceEntrenadorImpl entrenadorS = new ServiceEntrenadorImpl();
        Entrenador nuevoEntrenador = entrenadorS.crearEntrenador(nuevoEquipo);
        System.out.println("Datos Entrenador");
        System.out.println(nuevoEntrenador);
        System.out.println("Datos del equipo");
        System.out.println(nuevoEquipo);

    }
}
