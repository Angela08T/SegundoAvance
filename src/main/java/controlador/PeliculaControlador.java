/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Modelo.Pelicula;
import Modelo.PeliculaDAO;
import java.util.List;
import vista.MenuPrincipalClass;

/**
 *
 * @author Usuario
 */
public class PeliculaControlador {
    private MenuPrincipalClass view;
    private PeliculaDAO DAOPelicula;

    //Solo con un paarmetro hasta que se implemente jFrame
    public PeliculaControlador( PeliculaDAO DAOPelicula) {

        this.DAOPelicula = DAOPelicula;
    }
  
              
   public List<Pelicula> obtenerPeliculas() {
        if (DAOPelicula != null) {
            return DAOPelicula.obtenerPeliculasConHorariosYPrecio();
        } else {
            System.out.println("Error: PeliculaDAO no inicializado.");
            return null;
        }
    }
     public int obtenerIdHorarioPorPelicula(int idPelicula) {
         return DAOPelicula.obtenerIdHorarioPorPelicula(idPelicula);
     }
  
    
    
}
