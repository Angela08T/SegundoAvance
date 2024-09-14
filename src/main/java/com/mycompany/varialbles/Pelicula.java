
package com.mycompany.varialbles;

public class Pelicula {
    private String titulo;
    private String genero;
    private int duracion; 
    
    public Pelicula(String titulo, String genero, int duracion) {
        this.titulo = titulo;
        this.genero = genero;
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

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void mostrarInformacion() {
        System.out.println("Título: " + titulo);
        System.out.println("Género: " + genero);
        System.out.println("Duración: " + duracion + " minutos");}
}
