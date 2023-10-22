package org.example;

import java.util.UUID;

public class Reserva {
    private int idReserva;
    private String fechaIngreso;
    private static int contador;

    private int cantidadDias;
    private String fechaSalida;
    private Habitacion habReservada;

    private EstadoReserva estadoReserva;

    private double costoTotal;

    public Reserva(String fechaIngreso, int cantDias, Habitacion habReservada, EstadoReserva estadoReserva) {
        contador++; // a partir del atributo estático contador cada vez que se instancia un nuevo objeto
        //se parte del último valor de contador y se suma uno.
        this.idReserva = contador; // el id irá entonces sumando de a uno cada vez que se instancie una nueva reserva.
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = Libreria.calcularDias(fechaIngreso, cantDias);
        this.habReservada = habReservada;
        this.estadoReserva = estadoReserva;
        this.costoTotal = calcularCosto(cantDias,habReservada);
    }

    private double calcularCosto(int cantidadDias, Habitacion hab){
        return cantidadDias*hab.getTipoHabitacion().getCostoPorNoche();
    }

    @Override
    public String toString() {
        return "Datos de la reserva:\n" +
                "Id reserva:" + idReserva +  '\n' +
                "Fecha de ingreso: " + fechaIngreso + '\n' +
                "Fecha de salida: " + fechaSalida + '\n' +
                "Número de habitación reservada: " + habReservada + "\n" +
                "Costo Total:" + costoTotal;
    }
}
