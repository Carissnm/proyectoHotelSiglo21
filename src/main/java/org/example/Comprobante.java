package org.example;

import java.time.LocalDate;
import java.util.Date;

public class Comprobante {
    private static int contador;
    private int idComprobante;
    private int idReserva;
    private String fechaIngreso;
    private String fechaSalida;
    private Habitacion habReservada;
    private double costoTotal;

    public Comprobante(Reserva reserva) {
        contador++;
        this.idComprobante = contador;
        this.idReserva = reserva.getIdReserva();
        this.fechaIngreso = reserva.getFechaIngreso();
        this.fechaSalida = reserva.getFechaSalida();
        this.habReservada = reserva.getHabReservada();
        this.costoTotal = reserva.getCostoTotal();
    }

    //Se realiza una sobrecarga del constructor de Comprobante para poder utilizarlo
    //para emitir un comprobante de cancelación de reserva.
    public Comprobante(int idReserva){
        contador++;
        this.idComprobante = contador;
    }

    public int getIdComprobante() {
        return idComprobante;
    }

    @Override
    public String toString() {
        return  "idComprobante: " + idComprobante +
                "\nidReserva: " + idReserva +
                "\nfechaIngreso: " + fechaIngreso  +
                "\nfechaSalida: " + fechaSalida +
                "\nhabReservada " + habReservada +
                "\ncostoTotal:" + costoTotal;
    }
}
