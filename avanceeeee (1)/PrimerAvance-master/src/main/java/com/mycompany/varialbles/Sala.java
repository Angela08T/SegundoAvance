package com.mycompany.varialbles;

import com.mycompany.varialbles.proyecto_poo.Peliculas.Pelicula;
import java.util.List;

public class Sala {
    private int numero;
    private List<Asiento> asientos;
    private Pelicula pelicula;

    public Sala(int numero, List<Asiento> asientos, Pelicula pelicula) {
        this.numero = numero;
        this.asientos = asientos;
        this.pelicula = pelicula;
    }

    public int getNumero() {
        return numero;
    }

    public List<Asiento> getAsientos() {
        return asientos;
    }
} 
