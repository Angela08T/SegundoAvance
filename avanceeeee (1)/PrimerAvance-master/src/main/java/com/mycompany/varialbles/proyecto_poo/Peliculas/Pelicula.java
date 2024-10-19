
package com.mycompany.varialbles.proyecto_poo.Peliculas;

import java.time.LocalDate;


public class Pelicula {
    protected String titulo;
    protected String genero;
    protected String sinopsis;
    protected String director;
    protected LocalDate fechaestreno;
    protected int duracion;


    public Pelicula() {
    }

    public Pelicula(String titulo, String genero, String sinopsis, String director, LocalDate fechaestreno, int duracion) {
        this.titulo = titulo;
        this.genero = genero;
        this.sinopsis = sinopsis;
        this.director = director;
        this.fechaestreno = fechaestreno;
        this.duracion = duracion;
        
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public LocalDate getFechaestreno() {
        return fechaestreno;
    }

    public void setFechaestreno(LocalDate fechaestreno) {
        this.fechaestreno = fechaestreno;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
    public void mostrarInformacion(){
        System.out.println("Titulo: "+titulo);
        System.out.println("Genero: "+genero);
        System.out.println("Sinopsis: "+sinopsis);
        System.out.println("Director: "+director);
        System.out.println("Fecha de estreno: "+fechaestreno);
        System.out.println("Duracion: "+duracion+ " minutos");
        
    }

    
}
