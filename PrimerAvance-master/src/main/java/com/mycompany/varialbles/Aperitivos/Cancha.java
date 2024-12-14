
package com.mycompany.varialbles.Aperitivos;

public class Cancha extends Aperitivo{
    private final String tipo;

    public Cancha(String tipo, String nombre, double precio, String tamaño) {
        super(nombre, precio, tamaño);
        this.tipo = tipo;
    }
    @Override
    public String getDescripcion() {  
        return toString();
    }

    @Override
    public String toString() {
        return  "Cancha: "+getNombre()+", Tipo: "+tipo+", Tamaño:"+getTamaño()+", Precio: "+getPrecio();
    }
    
}
