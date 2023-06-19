package com.info.futbol5;
import com.info.futbol5.service.fuciones.menu.FunctionsService;
import com.info.futbol5.service.fuciones.menu.Impl.FunctionsServiceImpl;

/**
 * Main Futbol 5
 */
public class App 
{
   public static void main( String[] args )  {
       FunctionsService functionsService = new FunctionsServiceImpl();
       functionsService.logicaFunciones();

  }

}
