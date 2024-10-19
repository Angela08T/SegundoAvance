
package com.mycompany.varialbles.proyecto_poo.Peliculas;

import java.time.LocalDate;

public class PeliculasEnCartelera extends Pelicula {
    protected boolean encartelera;


    public PeliculasEnCartelera(boolean encartelera, String titulo, String genero, String sinopsis, String director, LocalDate fechaestreno, int duracion) {
        super(titulo, genero, sinopsis, director, fechaestreno, duracion);
        this.encartelera = encartelera;
    }

    public PeliculasEnCartelera() {
    }


    public void setEncartelera(boolean encartelera) {
        this.encartelera = encartelera;
    }

    @Override
    public void mostrarInformacion(){
        super.mostrarInformacion();
        System.out.println("En cartelera: "+(encartelera?"Si":"No"));
    }
      
}
