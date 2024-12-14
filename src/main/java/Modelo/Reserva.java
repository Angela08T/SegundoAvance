/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Usuario
 */
import java.util.Date;
import java.util.List;

public class Reserva {
    private int idReserva;
    private int idUsuario;
    private int idPelicula;
    private Date fechaReserva;

    public Reserva(int idReserva, int idUsuario, int idPelicula, Date fechaReserva) {
        this.idReserva = idReserva;
        this.idUsuario = idUsuario;
        this.idPelicula = idPelicula;
        this.fechaReserva = fechaReserva;
    }
    
    public Reserva(){
        
    }
    private List<DetalleReserva> detallesReserva;
    private List<DetalleAperitivo> detallesAperitivos;

    // Getters y Setters
    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public List<DetalleReserva> getDetallesReserva() {
        return detallesReserva;
    }

    public void setDetallesReserva(List<DetalleReserva> detallesReserva) {
        this.detallesReserva = detallesReserva;
    }

    public List<DetalleAperitivo> getDetallesAperitivos() {
        return detallesAperitivos;
    }

    public void setDetallesAperitivos(List<DetalleAperitivo> detallesAperitivos) {
        this.detallesAperitivos = detallesAperitivos;
    }
}
