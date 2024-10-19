    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.varialbles.Aperitivos;

/**
 *
 * @author USER
 */
public class Cancha extends Aperitivo{
    private final String tipo;

    public Cancha(String tipo, String nombre, double precio, String tamaño) {
        super(nombre, precio, tamaño);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
    
    
    
    @Override
    public String getDescripcion() {
        System.out.println("Cancha: "+getNombre()+", Tipo: "+tipo+", Precio: "+getPrecio());  
        return null;
    } 
}