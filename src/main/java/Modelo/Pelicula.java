
package Modelo;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

public class Pelicula {
    private int idPelicula;
    private String titulo;
    private String genero;
    private int duracion;
    private String clasificacion;
    private BigDecimal precio;
    private Date fecha;
    private Time  hora;
                
    
//Constructor general


    public Pelicula(int idPelicula, String titulo, String genero, int duracion, String clasificacion, BigDecimal precio, Date fecha, Time hora) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
        this.clasificacion = clasificacion;
        this.precio = precio;
        this.fecha = fecha;
        this.hora = hora;
  
    }
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    //Constructor vacio
    public void setHora(Time hora) {    
        this.hora = hora;
    }

    public Pelicula() {
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

 
    // Getters y Setters
    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
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

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }
}
