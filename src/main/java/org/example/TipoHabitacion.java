package org.example;

public enum TipoHabitacion {
    INDIVIDUAL(114.29),DOBLE(114.29),TRIPLE(128.01),CUADRUPLE(154.30);

    private double costoPorNoche;

    TipoHabitacion(double costo) {
        this.costoPorNoche = costo;
    }

    //Este método permite se llamado desde otras clases para poder hacer los cálculos sobre
    //el precio total de la estadía en cada habitación según su tipo.
    public double getCostoPorNoche() {
        return costoPorNoche;
    }
}
