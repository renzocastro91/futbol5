package com.info.futbol5;
import com.info.futbol5.service.menu.MenuService;
import com.info.futbol5.service.menu.impl.MenuServiceImpl;

/*
 * Main Futbol 5
 */
public class App 
{
   public static void main( String[] args )  {
       MenuService menuService = new MenuServiceImpl();
       menuService.menu();
  }

}
