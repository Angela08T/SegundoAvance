
package com.mycompany.varialbles.proyecto_poo.Peliculas;

import com.mycompany.varialbles.Boletx.Boleto;
import com.mycompany.varialbles.Boletx.GestionBoletos;
import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class GestorPeliculas {
    private final Set<PeliculasEnCartelera> peliculas; 
    private final Map<String, PeliculasEnCartelera> peliculasMap; 
    GestionBoletos gestionboletos=new GestionBoletos();
    public GestorPeliculas() {
        peliculas = new HashSet<>();
        peliculasMap = new HashMap<>();
    }

    public Set<PeliculasEnCartelera> getPeliculas() {
        return peliculas;
    }

    public Map<String, PeliculasEnCartelera> getPeliculasMap() {
        return peliculasMap;
    }

    public void agregarPelicula(String titulo, String genero, String sinopsis, 
                                String director, LocalDate fechaEstreno, 
                                int duracion, double precio,int fechaoriginal, boolean enCartelera) {
        Pelicula pelicula = new Pelicula(titulo, genero, sinopsis, director, fechaEstreno, duracion, precio,fechaoriginal);
        PeliculasEnCartelera peliculaEnCartelera = new PeliculasEnCartelera(pelicula, enCartelera);
        
        peliculas.add(peliculaEnCartelera); 
        peliculasMap.put(titulo, peliculaEnCartelera); 
    }

    public void infopeliculas() {
        agregarPelicula("Titanic", "Romance", "Una historia de amor entre Jack y Rose", 
                        "James Cameron", LocalDate.of(2025, 12, 19), 195, 20,1997, true);
        agregarPelicula("Avengers: Endgame", "Acción", 
                        "Los Vengadores luchan por salvar el universo de Thanos.", 
                        "Anthony Russo, Joe Russo", LocalDate.of(2025, 4, 26), 181, 15,2019, true);
        agregarPelicula("El Señor de los Anillos: El Retorno del Rey", "Fantasía/Aventura", 
                    "Frodo y Sam llegan a Mordor mientras la batalla final se libra en Gondor.", 
                    "Peter Jackson", LocalDate.of(2025, 12, 17), 201, 18,2003, true);
        agregarPelicula("Joker", "Drama", "La transformación de Arthur Fleck en el infame Joker.", 
                    "Todd Phillips", LocalDate.of(2025, 10, 4), 122, 12,2019, false);
       
       
    }
    public void mostrarInformacionDePeliculas() {
        peliculas.forEach(pelicula -> {
            System.out.println("=========================");
            pelicula.mostrarInformacion();
            System.out.println("=========================");
        });
    } 
    public void mostrarPeliculasEnCartelera() {
        peliculas.stream()
                .filter(PeliculasEnCartelera::isEncartelera) 
                .forEach(pelicula -> {
                    pelicula.mostrarInformacion();
                    System.out.println("=========================");
                });
    }
    public void mostrarPeliculasPorFechaDePublicación() {
    peliculas.stream()
            .sorted(Comparator.comparing(p -> p.getPelicula().fechaoriginal())) 
            .forEach(pelicula -> {
                System.out.println("Pelicula: "+pelicula.getPelicula().titulo());
                System.out.println(" Fecha de publicación: "+pelicula.getPelicula().fechaoriginal());
                System.out.println("=========================");
            });
    }
    public void ordenarPorNombre() {
        peliculas.stream()
            .sorted(Comparator.comparing(p -> p.getPelicula().titulo())) 
            .forEach(p -> System.out.println(p.getPelicula().titulo()));
    }

    public void filtrarPeliculasNoEnCartelera() {
        peliculas.stream()
            .filter(p -> !p.isEncartelera())  
            .forEach(p -> System.out.println(p.getPelicula().titulo() + " no está en cartelera."));
    }

    public void buscarPelicula() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el título de la película a buscar: ");
        String titulo = sc.nextLine();

        peliculas.stream()
            .filter(p -> p.getPelicula().titulo().equalsIgnoreCase(titulo)) 
            .forEach(p -> {
                System.out.println("Pelicula encontrada: " + p.getPelicula().titulo());          
            });
    }

    public void ordenarPorFechaEstreno() {
        peliculas.stream()
            .sorted(Comparator.comparing(p -> p.getPelicula().fechaestreno(), Comparator.reverseOrder()))  
            .forEach(p -> System.out.println(p.getPelicula().titulo() + " - Fecha de estreno: " + p.getPelicula().fechaestreno()));
    }

    public void filtrarPorGenero() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Ingrese el género para filtrar: ");
    String genero = sc.nextLine().trim().toLowerCase(); 

    List<PeliculasEnCartelera> peliculasFiltradas = peliculas.stream()
        .filter(p -> p.getPelicula().genero().toLowerCase().equals(genero)) 
        .collect(Collectors.toList());

    if (peliculasFiltradas.isEmpty()) {
        System.out.println("No se encontraron películas con el género: " + genero);
    } else {
        peliculasFiltradas.forEach(p -> 
            System.out.println("Pelicula: " + p.getPelicula().titulo() + " - Género: " + p.getPelicula().genero()));
    }
}
}     


