package com.info.futbol5.service.entrada;
import java.util.Scanner;

public interface InputServiceInterface {
    void createScanner();
    Scanner getScanner();
    void closeScanner();
}
