package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class Reserva {
    private String idReserva;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private Habitacion habReservada;
    private Habitacion nroHabReservada;
    private EstadoReserva estadoReserva;

    public Reserva(LocalDate fechaIngreso, LocalDate fechaSalida, Habitacion habReservada, Habitacion nroHabReservada, EstadoReserva estadoReserva) {
        this.idReserva = generarIdUnico();
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
        this.habReservada = habReservada;
        this.nroHabReservada = nroHabReservada;
        this.estadoReserva = estadoReserva;
    }

    //Este método permite generar un id único siempre que se instancie un objeto de tipo Reserva. Se lo llama dentro del
    //propio constructor de la clase
    private String generarIdUnico(){
        String id = UUID.randomUUID().toString();
        return id;
    }
}
