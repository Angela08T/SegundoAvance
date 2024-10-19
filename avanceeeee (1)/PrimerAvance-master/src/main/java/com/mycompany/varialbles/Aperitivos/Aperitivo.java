
package com.mycompany.varialbles.Aperitivos;

public abstract class Aperitivo {
    private final String nombre;
    private final double precio;
    private final String tamaño;

    public Aperitivo(String nombre, double precio, String tamaño) {
        this.nombre = nombre;
        this.precio = precio;
        this.tamaño = tamaño;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getTamaño() {
        return tamaño;
    }
    public abstract String getDescripcion();
}
