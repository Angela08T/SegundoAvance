/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.varialbles.Aperitivos;

/**
 *
 * @author USER
 */
public class Gaseosa extends Aperitivo{
    private String sabor;

    public Gaseosa(String sabor, String nombre, double precio, String tamaño) {
        super(nombre, precio, tamaño);
        this.sabor = sabor;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }
    
    
    
    @Override
    public String getDescripcion() {
        System.out.println("Gaseosa: "+getNombre()+", Tipo: "+sabor+", Precio: "+getPrecio());
        return null;
    }
    
}

