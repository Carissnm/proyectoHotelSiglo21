package org.example;

import java.util.ArrayList;

public class Habitacion {
    private int nroHabitacion;
    private boolean isReservada;
    //El atributo tipoHabitación es un enum dado que sólo existen un número reducido y limitado de tipos
    //de habitación, y de esta manera se evitan errores de typo al ingresar un tipo de habitación
    //al instanciar un objeto habitación.
    private TipoHabitacion tipoHabitacion;

    private double costoPorNoche;
    private ArrayList<Huesped> huespedes;

    //Con el constructor se genera cada habitación. En el caso de huéspedes es una lista de los
    // huéspedes que se alojan si se encuentra ocupada la habitación.
    public Habitacion(int nroHabitacion, TipoHabitacion tipoHabitacion) {
        this.nroHabitacion = nroHabitacion;
        this.isReservada = false;
        //dentro del constructor se llama al método de tipoHabitación para asignarle el valor del costo
        //unitario de la habitación directo en el constructor
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
