package com.info.futbol5.service.posicion.impl;
import com.info.futbol5.domain.Posicion;
import com.info.futbol5.service.posicion.ServicePosicion;
import com.info.futbol5.service.entrada.console.impl.InputService;

public class ServicePosicionImpl implements ServicePosicion {
    @Override
    public Posicion crearPosicion() {
        System.out.println("-->POSICION<--");
        Posicion nuevaPos = new Posicion();
        int pos;
        System.out.println("Seleccione una posicion: 1- Arquero 2- Defensor 3- Mediocampista 4- Delantero");
        pos = InputService.getScanner().nextInt();
        switch (pos){
            case 1:
                nuevaPos.setNombre("Arquero"); 
                break;
            case 2:
                nuevaPos.setNombre("Defensor");
                break;
            case 3: 
                nuevaPos.setNombre("Mediocampista");
                break;
            case 4:
                nuevaPos.setNombre("Delantero");
                break;
            default:
                System.out.println("Elección incorrecta");
                crearPosicion();
        }

        return nuevaPos;
    }
    
}
