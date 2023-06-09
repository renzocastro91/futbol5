package com.info.futbol5;
import com.info.futbol5.service.fuciones.FunctionsService;
import com.info.futbol5.service.fuciones.Impl.FunctionsServiceImpl;


import javax.sound.midi.Soundbank;
import java.time.LocalDate;
import java.util.*;

/**
 * Main Futbol 5
 *
 */
public class App 
{
   public static void main( String[] args )  {
       FunctionsService functionsService = new FunctionsServiceImpl();
       functionsService.logicaFunciones();

  }

}
