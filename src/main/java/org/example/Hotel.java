package org.example;

import java.lang.reflect.Array;
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

    private void verHabitacionesDisponiblesGeneral(){
        for(Habitacion habitacion : habitaciones){
            System.out.println(habitaciones);
        }
    }

    // Con este método es posible acceder a las habitaciones que se encuentran vacías en la fecha que ingresa el usuario
    //según la cantidad de huéspedes.
    private Habitacion mostrarHabsDisponibles(String fecha, int cantDias, int cantHuespedes){
        Habitacion habitacion;
        //Con un ForEach se recorre toda la lista de habitaciones verificando que la habitación esté vacía y que
        //tenga capacidad para la cantidad de huéspedes ingresada.
        for(Habitacion hab : habitaciones){
            if(cantHuespedes - 1 <= hab.getTipoHabitacion().ordinal() && hab.verEstadoHabitacion()){
                System.out.println(hab);
            }
        }

        int nroHab = Libreria.leerInt("Por favor ingrese el número de habitación que desee reservar: ");

        habitacion = habitaciones.get(nroHab - 1);

        return habitacion;
    }

    //Este método privado instancia un nuevo objeto de tipo Huésped
    //ingresando como parámetros los datos brindados por el usuario
    private Huesped ingresarHuesped(){
        System.out.println("Ingrese los datos del huésped:");
        String nombre = Libreria.leerStr("Ingrese nombre: ");
        String apellido = Libreria.leerStr(("Ingrese apellido: "));
        String dni = Libreria.leerStr("Ingrese DNI: ");

        Huesped huesped = new Huesped(dni, nombre, apellido);

        return huesped;
    }

    //Este método permite que al realizar la confirmación de la reserva
    //se le asigne a la lista de huespedes del hotel los huéspedes ingresados
    //por el usuario
    public ArrayList<Huesped> registrarHuesped(int cantidad) {
        ArrayList<Huesped> huespedesPorHab = new ArrayList<>();
        Huesped huesped = ingresarHuesped();

        this.huespedes.add(huesped);
        huespedesPorHab.add(huesped);
        if(cantidad > 1){
            for (int i = 1; i < cantidad; i++){
                huesped = ingresarHuesped();
                this.huespedes.add(huesped);
                huespedesPorHab.add(huesped);
            }
        }

        return huespedesPorHab;

    }

    /* El método actualizarHabitación es utilizado por Hotel para
    cambiar el estado de la habitación que es reservada. Para eso recorre la
     lista de habitaciones que tiene el hotel y una vez que encuentra la habitación
     que eligió el usuario cambia su estado para indicar que está reservada
     y a su vez carga en la lista de huéspedes de la habitación aquellos huéspedes ingresados
     por el usuario */
    private void actualizarHabitacion(Habitacion habitacion, boolean estado, ArrayList<Huesped> huespedes){
        for(Habitacion hab: habitaciones){
            if(habitacion == hab){
                if(estado){
                    habitacion.actualizarEstadoHabitacion(estado);
                    habitacion.agregarHuespedes(huespedes);
                } else {
                    habitacion.actualizarEstadoHabitacion(estado);
                    habitacion.eliminarHuespedes();
                }
            }
        }
    }

    private void confirmarReserva(Reserva reserva) {


    }

    //Generar reserva toma como parámetros los datos ingresados por el usuario con ellos instancia un objeto de tipo Reserva
    //que luego agrega a la lista de reservas del hotel. Finalmente imprime por consola la lista.
    private void generarReserva(String fecha,int cantidadDias, ArrayList<Huesped> huespedesRegistrados, Habitacion habitacion){
        boolean estado = true;
        Reserva reserva = new Reserva(fecha, cantidadDias, habitacion, EstadoReserva.PENDIENTE);


        System.out.println(reserva);
        String opcion = Libreria.leerStr("¿Desea confirmar la reserva? S/N");
        if(opcion.equals("S")){
            reserva.cambiarEstado(opcion);
            reservas.add(reserva);
            Comprobante comprobante = new Comprobante(reserva);
            actualizarHabitacion(habitacion, estado,huespedesRegistrados);
            System.out.println("Gracias por confirmar la reserva");
            System.out.println(comprobante);
        } else {
            System.out.println("¿Desea regresar al menú principal? S/N");
        }
    }

    private Reserva getReservaById(int idReserva) {
        Reserva reserva = null;
        int i = 0;

        while(i < reservas.size() && this.reservas.get(i).getIdReserva() != idReserva){
            i++;
        }

        if(i < reservas.size()){
            reserva = this.reservas.get(i);
        }

        return reserva;
    }

    //Este método permite remover todos los huéspedes de la lista que se le ingrese.
    //La idea es ser utilizada para borrar los huéspedes en la habitación de la reserva cancelada.
    private void eliminarHuespedes(ArrayList<Huesped> huespedes){
        this.huespedes.removeAll(huespedes);
    }

    //El método cancelarReserva toma el id de la reserva que se desea cancelar
    //Chequea que la reserva exista y si es así reconfirma el deseo de cancelación.
    //Si se opta por continuar con la cancelación cambia el estado de reserva a Cancelada y libera la habitación.
    //Finalmente emite un comprobante de cancelación.
    private void cancelarReserva(int idReserva){
        Reserva reservaACancelar = getReservaById(idReserva);

        if(reservaACancelar != null) {
            String opcion = Libreria.leerStr("¿Desea eliminar la reserva número "+ reservaACancelar.getIdReserva() + "? S/N" );

            if(opcion.equals("S")){
                ArrayList<Huesped> huespedesPorHabitacion = reservaACancelar.getHabReservada().getHuespedes();
                eliminarHuespedes(huespedesPorHabitacion);
                reservaACancelar.cambiarEstado("N");
                actualizarHabitacion(reservaACancelar.getHabReservada(), false, null);
                Comprobante comprobanteCancelacion = new Comprobante(reservaACancelar.getIdReserva());
                System.out.println("La reserva fue exitosamente cancelada, su id de comprobante es: " + comprobanteCancelacion.getIdComprobante());
            }

        } else {
            System.out.println("No pudo encontrarse la reserva solicitada, por favor inténtelo nuevamente.");
        }
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
    // por el momento el menú reserva sólo tomará los datos correspondientes del usuario para efectuar la cotización

    private void mostrarMenuReserva(){
        String fechaEntrada = obtenerFechaEntrada();
        int cantidadDias = obtenerCantDias();
        int cantidadHuespedes = obtenerCantHuespedes();
        Habitacion habitacion = mostrarHabsDisponibles(fechaEntrada, cantidadDias, cantidadHuespedes);
        ArrayList<Huesped> huespedesRegistrados = registrarHuesped(cantidadHuespedes);

        generarReserva(fechaEntrada, cantidadDias, huespedesRegistrados, habitacion);
    }

    //Este método le solicita por pantalla al usuario que ingrese el id de la reserva a eliminar y luego
    //llama al método cancelar reserva para hacer efectiva la cancelación.
    private void mostrarMenuCancelacion(){
        int idReservaACancelar = Libreria.leerInt("Por favor, ingrese el id de la reserva que desea cancelar: ");
        cancelarReserva(idReservaACancelar);
    }

    //El menú principal es un método que mostrará su contenido siempre que el usuario no decida salir del mismo.
    //Desde este menú principal se llamarán a los distintos métodos según los requerimientos del usuario.

    public void menu(){
        int opcion = mostrarMenuPrincipal();
        boolean continuar = true;
        while (continuar == true){
            switch(opcion){
                case 1:
                    mostrarMenuReserva();
                    break;
                case 2:
                    mostrarMenuCancelacion();
                    break;
                case 3:
                    verHabitacionesDisponiblesGeneral();
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
