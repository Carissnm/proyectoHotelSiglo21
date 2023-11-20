package org.example;

public class Reserva implements Descuento {
    private int idReserva;
    private String fechaIngreso;
    private static int contador;

    private int cantidadDias;
    private String fechaSalida;
    private Habitacion habReservada;

    private EstadoReserva estadoReserva;

    private double descuento;

    private double costoTotal;

    public Reserva(String fechaIngreso, int cantDias, Habitacion habReservada, EstadoReserva estadoReserva) {
        contador++; // a partir del atributo estático contador cada vez que se instancia un nuevo objeto
        //se parte del último valor de contador y se suma uno.
        this.idReserva = contador; // el id irá entonces sumando de a uno cada vez que se instancie una nueva reserva.
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = Libreria.calcularDias(fechaIngreso, cantDias);
        this.habReservada = habReservada;
        this.estadoReserva = estadoReserva;
        this.descuento = 0.0;
        this.costoTotal = calcularCosto(cantDias,habReservada);
    }

    //Se definen los getters para poder utilizarse en el método de emitirComprobante una vez que se
    //confirma una reserva.
    public int getIdReserva() {
        return idReserva;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public EstadoReserva getEstadoReserva() {
        return estadoReserva;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public Habitacion getHabReservada() {
        return habReservada;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    private double calcularCosto(int cantidadDias, Habitacion hab){
        return Math.floor(cantidadDias*hab.getCostoPorNoche()*100)/100;
    }

    public void cambiarEstado(String opcion) {
        switch(opcion) {
            case "S":
                estadoReserva = EstadoReserva.CONFIRMADA;
                break;
            case "N":
                estadoReserva = EstadoReserva.CANCELADA;
                break;
            default:
                System.out.println("Opción no disponible, por favor vuelva a intentarlo.");
        }
    }

    //Gracias al Polimorfismo tomamos el método de la Interface Descuento y esta vez le indicamos que
    //aplique un descuento que está inicializado como en 0.0. Desde hotel se chequea si en la habitación hay
    //algún huésped VIP en cuyo caso se cambia el descuento al correspondiente al asignado a los huéspedes VIP.
    public void calcularDescuento() {
        this.costoTotal = Math.floor(costoTotal * (1-descuento)*100)/100;
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
