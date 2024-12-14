/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class DetalleAperitivo {
    private int idDetalleAperitivo;
    private int idReserva;
    private int idAperitivo;
    private int cantidad;
    private double subtotal;
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

    // Getters y Setters
    public int getIdDetalleAperitivo() {
        return idDetalleAperitivo;
    }

    public void setIdDetalleAperitivo(int idDetalleAperitivo) {
        this.idDetalleAperitivo = idDetalleAperitivo;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdAperitivo() {
        return idAperitivo;
    }

    public void setIdAperitivo(int idAperitivo) {
        this.idAperitivo = idAperitivo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
       @Override
    public String toString() {
        return "DetalleAperitivo{" +
               "idAperitivo=" + idAperitivo +
               ", nombreAperitivo='" + nombre + '\'' +
               ", cantidad=" + cantidad +
               ", subtotal=" + subtotal +
               '}';
    }

}

