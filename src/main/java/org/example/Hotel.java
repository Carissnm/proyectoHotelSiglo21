package org.example;

import java.util.ArrayList;

public class Hotel {
    private String nombre;
    private ArrayList<Reserva> reservas;
    private ArrayList<Huesped> huespedes;
    private ArrayList<Habitacion> habitaciones;

    public Hotel(String nombre) {
        this.nombre = nombre;
        this.reservas = new ArrayList<Reserva>();
        this.huespedes = new ArrayList<Huesped>();
        this.habitaciones = generarHabitaciones();
    }

    private int generarNro() {
        int min = 0;
        int max = 3;
        int random_nro = (int)Math.floor(Math.random() * (max - min + 1) + min);

        return random_nro;
    }
    private ArrayList<Habitacion> generarHabitaciones() {
        this.habitaciones = new ArrayList<Habitacion>();
        for (int i = 1; i <=15; i++) {
            TipoHabitacion[] tipos = TipoHabitacion.values();
            Habitacion h = new Habitacion(i, tipos[generarNro()]);
            habitaciones.add(h);
        }
        return habitaciones;
    }
}
