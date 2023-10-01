package org.example;

import java.util.ArrayList;
//La clase Hotel tiene como atributos su nombre, la lista de reservas generadas, la lista de habitaciones que possee y la lista de huéspedes
//que están alojados.
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

    //El método generarHabitaciones nos permite armar al correr el programa
    //una lista de habitaciones prearmada. Con el método generarNro() definimos de manera
    //aleatoria un número del 0 al 3 para luego utilizar en generarHabitaciones() para
    //asignarle un tipo de habitación a cada una de las habitaciones creadas.
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

    //Los siguientes métodos se utilizarán en el menú de Reservas para captar lo ingresado
    //por el usuario por consola y luego utilizarlo en los distintos métodos correspondientes.
    private String obtenerFechaEntrada(){
        String fecha = Libreria.leerStr("Coloque la fecha de ingreso (dd-mm-yyyy): ");
        return fecha;
    }

    private int obtenerCantDias(){
        int cantDias = Libreria.leerInt("Ingrese la cantidad de días que se hospedará: ");
        return cantDias;
    }

    private int obtenerCantHuespedes(){
        int cantHuespedes = Libreria.leerInt("Ingrese la cantidad de huéspedes que se hospedarán: ");
        return cantHuespedes;
    }

    private void mostrarMenuReserva(){

    }



    //el método mostrarMenúPrincipal toma la elección que toma el usuario recurriendo a los métodos de la clase Librería
    //y devuelve el número ingresado por el usuario.
    private int mostrarMenuPrincipal(){
        System.out.println("Hotel "+ this.nombre + " - Bienvenido" );
        System.out.println("Por favor, ingrese el número correspondiente a la acción que desea realizar");
        System.out.println("1. Reservar habitación " +"\n" + "2. Cancelar reservas" + "\n" + "3. Ver Habitaciones" + "\n" + "4. Salir");

        int eleccion = Libreria.leerInt("Opcion elegida:");
        return eleccion;

    }

    //El menú principal es un método que mostrará su contenido siempre que el usuario no decida salir del mismo.
    //Desde este menú principal se llamarán a los distintos métodos según los requerimientos del usuario.

    public void menu(){
        int opcion = mostrarMenuPrincipal();
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
                opcion = mostrarMenuPrincipal();
            }
        }
    }
}
