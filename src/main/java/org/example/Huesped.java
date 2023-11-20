package org.example;


public class Huesped {
    private String dni;
    private String nombre;
    private String apellido;

    public Huesped(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return  "Dni:" + dni +
                "\nNombre:" + nombre +
                "\nApellido:" + apellido
                ;
    }
}
