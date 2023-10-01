package org.example;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        Habitacion h = new Habitacion(21,TipoHabitacion.DOBLE);

        System.out.println(h);

        System.out.println(h.verEstadoHabitacion());
    }
}