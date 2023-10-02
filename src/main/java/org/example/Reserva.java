package org.example;

import java.util.UUID;

public class Reserva {
    private String idReserva;
    private String fechaIngreso;
    private int cantidadDias;
    private String fechaSalida;
    private Habitacion habReservada;

    private EstadoReserva estadoReserva;

    private double costoTotal;

    public Reserva(String fechaIngreso, int cantDias, Habitacion habReservada, EstadoReserva estadoReserva) {
        this.idReserva = generarIdUnico();
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = Libreria.calcularDias(fechaIngreso, cantDias);
        this.habReservada = habReservada;
        this.estadoReserva = estadoReserva;
        this.costoTotal = calcularCosto(cantDias,habReservada);
    }

    //Este método permite generar un id único siempre que se instancie un objeto de tipo Reserva. Se lo llama dentro del
    //propio constructor de la clase
    private String generarIdUnico(){
        String id = UUID.randomUUID().toString();
        return id;
    }

    private double calcularCosto(int cantidadDias, Habitacion hab){
        return cantidadDias*hab.getTipoHabitacion().getCostoPorNoche();
    }

    @Override
    public String toString() {
        return "Datos de la reserva:\n" +
                "Fecha de ingreso:\n " + fechaIngreso + '\'' +
                "Cantidad de días de estadía: \n" + cantidadDias +
                "Fecha de salida: \n" + fechaSalida + '\'' +
                "Número de habitación reservada: \n" + habReservada +
                "Costo Total: \n" + costoTotal +
                '}';
    }
}
