package com.mycompany.varialbles;


import com.mycompany.varialbles.cliente.Cliente;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Boleto {
    
    private Cliente cliente;
    private String pelicula;
    private double precio;
    private int entrada;
    private double total;
    LocalDateTime fechahoractual= LocalDateTime.now();
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    // Constructor que recibe un Cliente existente
    public Boleto(Cliente cliente, String pelicula, double precio, int entrada,double total) {
        this.cliente = cliente;
        this.pelicula = pelicula;
        this.precio = precio;
        this.entrada=entrada;
        this.total=total;
    }

    public void imprimirBoleta() {
        
        System.out.println("############ CINE PLANET #############");
        System.out.println("Boleta:          "+fechahoractual.format(formato));
        System.out.println("Cliente: " + cliente);
        System.out.println("DNI: " + cliente);
        System.out.println("Película: " + pelicula);
        System.out.println("Precio: " + precio);
        System.out.println("Cantidad de entradas:"+entrada);
        System.out.println("Total:"+total);
        System.out.println("######################################");
    }
}