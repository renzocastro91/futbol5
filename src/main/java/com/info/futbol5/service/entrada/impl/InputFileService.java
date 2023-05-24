package com.info.futbol5.service.entrada.impl;
import com.info.futbol5.service.entrada.InputServiceInterface;
import java.util.Scanner;

public class InputFileService implements InputServiceInterface {
    @Override
    public void createScanner() {
        System.out.println("Creando escaner para archivo");
    }

    @Override
    public Scanner getScanner() {
        return null;
    }

    @Override
    public void closeScanner() {
        System.out.println("Cerrando escaner para archivo");

    }
}
