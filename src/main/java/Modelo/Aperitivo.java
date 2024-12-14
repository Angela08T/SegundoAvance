/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class Aperitivo {
    private int idAperitivo;
    private String nombre;
    private double precio;
    
public Aperitivo(){
    
}
    // Getters y Setters
    public int getIdAperitivo() {
        return idAperitivo;
    }

    public void setIdAperitivo(int idAperitivo) {
        this.idAperitivo = idAperitivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
