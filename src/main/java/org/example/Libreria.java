package org.example;

import java.util.Scanner;


public class Libreria {

    private static Scanner intInput = new Scanner(System.in);
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
    }
