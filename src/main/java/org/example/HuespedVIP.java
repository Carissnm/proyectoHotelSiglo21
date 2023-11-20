package org.example;
//HuéspedVIP extiende de la clase Huésped, por ende hereda todos sus atributos y métodos
// en el caso de que tuviera métodos la clase padre.

public class HuespedVIP extends Huesped{
    String huespedId;
    // El descuento no varía según el huésped VIP por lo tanto se declara como final
    final double descuento = 0.2;

    public HuespedVIP(String dni, String nombre, String apellido, String huespedId) {
        super(dni, nombre, apellido);
        this.huespedId = huespedId;

    }



    public String getHuespedId() {
        return huespedId;
    }

    @Override
    public String toString() {
        return "HuespedVIP:\n" +
                "Id:'" + huespedId + "\n" +
                super.toString() + "\n";
    }
}
