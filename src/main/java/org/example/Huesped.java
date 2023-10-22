package org.example;

//Huésped extiende de la clase abstracta Persona, por ende hereda todos sus atributos y métodos
// en el caso de que tuviera métodos la clase padre.
// De tener métodos entonces la clase hija estaría forzada a reescribir esos métodos de manera particular.
public class Huesped extends Persona {


    public Huesped(String dni, String nombre, String apellido) {
        super(dni, nombre, apellido);
    }
}
