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

    //el método mostrarMenú toma la elección que toma el usuario recurriendo a los métodos de la clase Librería
    //y devuelve el número ingresado por el usuario.
    private int mostrarMenu(){
        System.out.println("Hotel "+ this.nombre + " - Bienvenido" );
        System.out.println("Por favor, ingrese el número correspondiente a la acción que desea realizar");
        System.out.println("1. Reservar habitación " +"\n" + "2. Cancelar reservas" + "\n" + "3. Ver Habitaciones" + "\n" + "4. Salir");

        int eleccion = Libreria.leerInt("Opcion elegida:");
        return eleccion;

    }

    public void menu(){
        int opcion = mostrarMenu();
        boolean continuar = true;
        while (continuar == true){
            switch(opcion){
                case 1:
                    System.out.println("Usted eligió el 1");
                    break;
                case 2:
                    System.out.println("Usted eligió el 2");
                    break;
                case 3:
                    System.out.println("Usted eligió el 3");
                    break;
                case 4:
                    System.out.println("Gracias por su consulta.");
                    continuar = false;
                    break;
                default:
                    System.out.println("El valor ingresado no corresponde a una opción");

            }
            if(continuar) {
                opcion = mostrarMenu();
            }
        }
    }
}
