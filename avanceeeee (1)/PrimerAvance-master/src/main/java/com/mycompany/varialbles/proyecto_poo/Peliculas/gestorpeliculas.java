
package com.mycompany.varialbles.proyecto_poo.Peliculas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class gestorpeliculas {
    private final List<Pelicula> peliculas;

    public gestorpeliculas() {
         peliculas = new ArrayList<>();
    }
     public List<Pelicula> getPeliculas() {
        return peliculas;
    }
    public void infopeliculas(){
        peliculas.add(new PeliculasEnCartelera(true,"Titanic","Romance","Una historia de amor entre Jack y Rose",
            "James Camero",LocalDate.of(1997,12,19),195));
    }

    public void mostrarInformacion() {
        for(Pelicula pelicula:peliculas){
            System.out.println("=========================");
            pelicula.mostrarInformacion();
            System.out.println("=========================");
        }
    }
    
      
}

