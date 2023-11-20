package org.example;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
        //En este caso manejamos la posible excepción de no poder realizarse el cambio de un tipo de dato a otro
        // utilizando try-catch
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


    //El siguiente método permite tomar un archivo (en este caso alojado en el Desktop) para obtener
    //del mismo la lista de huéspedes considerados VIP que recibirán un descuento en la reserva.
    public static ArrayList<Huesped> leerArchivo() throws IOException {
        //Se crea una instancia de una lista de tipo huésped
        ArrayList<Huesped> huespedesVIP = new ArrayList<>();

        //se instancia un nuevo objeto Scanner para leer el archivo .txt con la lista de huéspedes VIP
        Scanner scanner = new Scanner(new FileReader("C:\\Users\\carol\\Desktop\\BBDDHuespedVIP.txt")).useDelimiter(",\\s*");
        String cadena;

        while(scanner.hasNextLine()){
            //El método trim elimina los espacios en blanco en ambos extremos de la cadena
            cadena = scanner.nextLine().trim();
            //El método split divide un objeto de tipo String en un Array de cadenas mediante la separación
            //de la cadena en subcadenas de la manera cadena.split([separador][,limite])
            String[] cadenaArray = cadena.split("\\s+");

            //Se asigna los valores de cada elemento de la lista a las distintas variables necesarias
            //para construir una nueva instancia de Huésped VIP.
            String dni = cadenaArray[0];
            String nombre = cadenaArray[1];
            String apellido = cadenaArray[2];
            String id = cadenaArray[3];

            //A continuación se instancia un objeto de tipo HuespedVIP con los datos capturados en cada variable
            Huesped huesped = new HuespedVIP(dni, nombre, apellido, id);


            //se agrega el huésped a la lista de huéspedesVIP
            huespedesVIP.add(huesped);

        }

        return huespedesVIP;
    }

    }
