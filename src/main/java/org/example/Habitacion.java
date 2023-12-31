package org.example;

import java.util.ArrayList;

public class Habitacion implements Descuento {
    private int nroHabitacion;
    private boolean isReservada;
    //El atributo tipoHabitación es un enum dado que sólo existen un número reducido y limitado de tipos
    //de habitación, y de esta manera se evitan errores de typo al ingresar un tipo de habitación
    //al instanciar un objeto habitación.
    private TipoHabitacion tipoHabitacion;

    private double costoPorNoche;
    private boolean conDescuento;
    private final double DESCUENTO = 0.1;
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
        this.conDescuento = false;
        this.huespedes = new ArrayList<Huesped>();
    }

    public double getCostoPorNoche() {
        return costoPorNoche;
    }

    public void setConDescuento(boolean conDescuento) {
        this.conDescuento = conDescuento;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }



    public ArrayList<Huesped> getHuespedes() {
        return huespedes;
    }

    /* El siguiente método permite verificar si una habitación
        tiene o no huéspedes para poder luego ser utilizado por el
         Hotel cuando realiza las cotizaciones y consultas de
         habitaciones disponibles */
    public Boolean verEstadoHabitacion() {
        return huespedes.isEmpty();
    }

    public void agregarHuespedes(ArrayList<Huesped> huespedes){
        this.huespedes.addAll(huespedes);
    }


    // Este método permite eliminar todos los huéspedes de la lista de la habitación. Es utilizado por el método
    //de cancelar reserva de la clase hotel.
    public void eliminarHuespedes(){
        this.huespedes.clear();
    }

    public void actualizarEstadoHabitacion(boolean estado){
        this.isReservada = estado;
    }


    //Utilizando la propiedad de Polimorfismo se toma el método calcularDescuento() de la interface Descuento
    //y se define que en caso de que la habitación figure como con descuento al costo de la habitación por noche
    //se le aplicará el descuento definido por el hotel, que en este caso es del 10%.
    public void calcularDescuento() {
        if(this.conDescuento){
            this.costoPorNoche = Math.floor(costoPorNoche*(1-DESCUENTO)*100)/100;
        }
    }
    @Override
    public String toString() {
        return "Habitacion número: " +
                nroHabitacion +
                "\nTipo:" + tipoHabitacion +
                "\nValor por noche: " + costoPorNoche;
    }
}
