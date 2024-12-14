
package com.mycompany.varialbles.Boletx;

import com.mycompany.varialbles.Asiento;
import com.mycompany.varialbles.cliente.Cliente;
import com.mycompany.varialbles.proyecto_poo.Peliculas.Pelicula;
import java.util.Random;

public class Boleto {
    private Cliente cliente;
    private Pelicula pelicula;
    private String codigoentrada;
    private Asiento asiento;
    
    public Boleto(Cliente cliente, Pelicula pelicula, Asiento asiento) {
        this.cliente = cliente;
        this.pelicula = pelicula;
        this.codigoentrada=generarCodigoEntrada();
        this.asiento=asiento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    } 
    public String getCodigoentrada() {
        return codigoentrada;
    }

    public void setCodigoentrada(String codigoentrada) {
        this.codigoentrada = codigoentrada;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }
    
    
    private String generarCodigoEntrada(){
        Random random= new Random();
        int numero=random.nextInt(100000);        
        return String.format("%06d", numero);
    }
    
}
