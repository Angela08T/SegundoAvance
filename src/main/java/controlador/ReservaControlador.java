/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Modelo.ReservaDAO;
import com.google.protobuf.TextFormat.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ReservaControlador {
       private ReservaDAO DAOReserva;
       
    public ReservaControlador(ReservaDAO DAOReserva){
        this.DAOReserva = DAOReserva;
    }
 
    
    public int registrarReserva(int idUsuario, int idPelicula) {
      
        return DAOReserva.registrarReserva(idUsuario, idPelicula);
    }
    public void registrarDetallesReserva(int idReserva, int idHorario, int idSala, int idAsiento) {
          DAOReserva.registrarDetallesReserva(idReserva, idHorario, idSala, idAsiento);
     }
   public void registrarDetallesAperitivo(int idReserva, int idAperitivo, int cantidad, double subtotal) {
       DAOReserva.registrarDetallesAperitivo(idReserva, idAperitivo, cantidad, subtotal);
   }
    public void verMisReservas(int idUsuario) {
        DAOReserva.verMisReservas(idUsuario);
    }
    public void generarBoleta(int idReserva) {
        DAOReserva.generarBoleta(idReserva);
    }
 
}
