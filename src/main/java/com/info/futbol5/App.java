package com.info.futbol5;
import com.info.futbol5.service.fuciones.FunctionsService;
import com.info.futbol5.service.fuciones.Impl.FunctionsServiceImpl;

/**
 * Main Futbol 5
 * Aclaracion Para el profe, la relacion entre equipo y jugadores cuando importo desde archivo, lo hago por medio de lógica
 * se me ocurrió tarde ponerle en la línea de jugador algo así:
 * 1;Fernando;Caceres;Masculino;1990;1.75;Arquero;3;4;True;91
 * y que ese entero con el que empieza la línea sea el indicador digamos de que pertenece al equipo 1 de la lista
 * de equipos, sin embargo decidí hacerlo por lógica, recorro los jugador y cada 5 se le asigna al equipo n, es decir
 * al equipo 1 se le asigna los primeros 5 jugadores, al equipo 2 se le asigna los jugadores del 6 al 10 para la proxima
 * agrego una lógica que mejore esta parte.
 */
public class App 
{
   public static void main( String[] args )  {
       FunctionsService functionsService = new FunctionsServiceImpl();
       functionsService.logicaFunciones();

  }

}
