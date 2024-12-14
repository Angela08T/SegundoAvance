
package com.mycompany.varialbles.proyecto_poo.Peliculas;



public record PeliculasEnCartelera(Pelicula pelicula, boolean encartelera) {

    public Pelicula getPelicula() {
        return pelicula;
    }
    
    public boolean isEncartelera() {
        return encartelera;
    }

    public void mostrarInformacion() {
        pelicula.mostrarInformacion(); 
        System.out.println("En cartelera: " + (encartelera ? "Sí" : "No"));
    }
    
}