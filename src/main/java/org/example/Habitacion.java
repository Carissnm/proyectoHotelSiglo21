package org.example;

import java.util.ArrayList;

public class Habitacion {
    private int nroHabitacion;
    private boolean isReservada;
    private TipoHabitacion tipoHabitacion;

    private double costoPorNoche;
    private ArrayList<Huesped> huespedes;

    public Habitacion(int nroHabitacion, TipoHabitacion tipoHabitacion) {
        this.nroHabitacion = nroHabitacion;
        this.isReservada = false;
        this.costoPorNoche = tipoHabitacion.getCostoPorNoche();
        this.tipoHabitacion = tipoHabitacion;
        this.huespedes = new ArrayList<Huesped>();
    }

    public String verEstadoHabitacion() {
        if (huespedes.isEmpty()) {
            return "Habitación disponible";
        } else {
            return "Habitación reservada";
        }
    }
    @Override
    public String toString() {
        return "Habitacion{" +
                "nroHabitacion=" + nroHabitacion +
                ", isReservada=" + isReservada +
                ", tipoHabitacion=" + tipoHabitacion +
                ", costoPorNoche=" + costoPorNoche +
                ", huespedes=" + huespedes +
                '}';
    }
}
