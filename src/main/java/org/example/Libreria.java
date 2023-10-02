package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

//La utilidad de la clase Librería es mantener limpio el código a la hora de gestionar la interfaz con el usuario para que el mismo
//ingrese tanto las opciones del menú principal, como los datos que se le pidan según si se está efectuando una reserva,
//o una cotización.
public class Libreria {
    //Uno de los atributos toma como entrada un número de tipo Integer.
    private static Scanner intInput = new Scanner(System.in);
    //El siguiente atributo es de tipo Scanner y toma una entrada de tipo String.
    private static Scanner stringInput = new Scanner(System.in);

    private Libreria() {
        }

        ;

    public static int leerInt(String msj) {
        intInput = new Scanner(System.in);
        System.out.println(msj);

        return intInput.nextInt();

    }

    public static String leerStr(String msj) {
        stringInput = new Scanner(System.in);
        System.out.println(msj);

        return stringInput.nextLine();

    }

    //Se instancia un objeto de tipo SimpleDateFormat para luego utilizar para transformar String en Date

    private static SimpleDateFormat fecha = new SimpleDateFormat("dd-MM-yy");

    //Con el siguiente método se convierte la cadena de caracteres ingresada en un dato de tipo Date
    //que luego será utilizada para utilizar dentro de la Reserva
    public static Date convertirFechas(String f) {

        Date date = null;
        try {
            date = Libreria.fecha.parse(f);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    private static SimpleDateFormat date = new SimpleDateFormat("dd-MM-yy");
    public static String calcularDias(String fecha, int cantidadDias){
        String dateBefore = fecha;

        Calendar cal = Calendar.getInstance();

        try{
            cal.setTime(date.parse(dateBefore));
        } catch (ParseException e) {
            e.printStackTrace(); // de esta manera en caso de no poder realizarse la conversión de String a Date entonces arroja un error y se evita que el programa se cierre.
        }

        cal.add(Calendar.DAY_OF_MONTH, cantidadDias);
        String dateAfter = date.format(cal.getTime());

        return dateAfter;
    }

    }
