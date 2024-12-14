/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import Modelo.Aperitivo;
import Modelo.AperitivoDAO;
import Modelo.DetalleAperitivo;
import Modelo.DetalleReserva;
import Modelo.Pelicula;
import Modelo.PeliculaDAO;
import Modelo.Reserva;
import Modelo.ReservaDAO;
import Modelo.SalaDAO;
import controlador.AperitivoControlador;
import controlador.PeliculaControlador;
import controlador.ReservaControlador;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Prueva {
    
  //CLASE DE PRUBAS DE METODOS

    
    public static void main(String[] args) {
        System.out.println("HOLASSS");
        
        
      
        /*
          // Inicializa el DAO con datos simulados
        PeliculaDAO peliculaDAO = new PeliculaDAO();
        PeliculaControlador controladorP = new PeliculaControlador(peliculaDAO);

        //controladorP  = new PeliculaControlador(null,new Pelicula());
      
        //PeliculaDAO x = new PeliculaDAO();
        //x.obtenerPeliculas();
        
       List<Pelicula> peliculas;
        peliculas = controladorP.obtenerPeliculas();
       
        System.out.println("\nPelículas disponibles:");
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula.getIdPelicula() + ". " + pelicula.getTitulo() + " - " + pelicula.getGenero());
        }
*/

       /*
          //iNICIAMOS EL CONTROLADOR DE APERITIVOS
        AperitivoControlador controladorA = new AperitivoControlador(new AperitivoDAO());
        List<Aperitivo> aperitivos ;
        
       aperitivos = controladorA.listarAperitivos();
        System.out.println("\nAperitivos disponibles:");
        
        for(Aperitivo listarAperitivo: aperitivos){
            System.out.println("ID: "+listarAperitivo.getIdAperitivo()+" NOMRE: "+listarAperitivo.getNombre()+" PRECIO:"+listarAperitivo.getPrecio()+" Soles");
        }
        */
       
       
       
       /*
       //iNICIALIZAMOS el CONTROLADOR dE rESERVA
       
       ReservaControlador controladorR = new  ReservaControlador(new ReservaDAO());
    Date fechaActual = new Date(); // Fecha y hora actual
       int idReserva =  controladorR.registrarReserva(1,1);
     */
             
      /*
     //Iniciamos el controladro de reserva
     ReservaControlador controladorR = new  ReservaControlador(new ReservaDAO());
     
     controladorR.registrarDetallesReserva(1, 1, 1, 1);
       */
      
      /*
           //Iniciamos el controladro de reserva
     ReservaControlador controladorR = new  ReservaControlador(new ReservaDAO());
     controladorR.registrarDetallesAperitivo(1, 1, 2, 10); 
*/
  
      /*
      
     
      //Iniciamos el controladro de reserva
      
     ReservaControlador controladorR = new  ReservaControlador(new ReservaDAO());
     controladorR.verMisReservas(1);
     */
      
      //
      /*
    SalaDAO X =new SalaDAO();
    
      // Paso 1: Listar salas
        List<String> salas = X.listarSalas();
        System.out.println("Salas disponibles:");
        for (String sala : salas) {
            System.out.println(sala);
        }
*/
      ReservaDAO x = new ReservaDAO();
      x.generarBoleta(1);
     /*
     
   
      List<DetalleReserva> detalles = x.obtenerDetallesReserva(16);
      for (DetalleReserva detalle : detalles) {
          
            System.out.println(detalle);
        }
*/
    } 
}
