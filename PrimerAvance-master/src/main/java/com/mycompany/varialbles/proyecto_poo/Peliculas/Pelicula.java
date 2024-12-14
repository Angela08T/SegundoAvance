
package com.mycompany.varialbles.proyecto_poo.Peliculas;

import java.time.LocalDate;

public record Pelicula(String titulo, String genero, String sinopsis, String director, LocalDate fechaestreno, int duracion, double precio, int fechaoriginal) {

    
    public void mostrarInformacion() {
        System.out.println("Titulo: " + titulo);
        System.out.println("Genero: " + genero);
        System.out.println("Sinopsis: " + sinopsis);
        System.out.println("Director: " + director);
        System.out.println("Fecha de estreno en el cine: " + fechaestreno);
        System.out.println("Duracion: " + duracion + " minutos");
        System.out.println("Precio: " + precio);
        System.out.println("Fecha de publicación:"+ fechaoriginal);
    }
} 
