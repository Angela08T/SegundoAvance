/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Modelo.Aperitivo;
import Modelo.AperitivoDAO;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class AperitivoControlador {
    private AperitivoDAO DAOAperitivo;
//Solo con paarmetro-se usa 2 cuando es con Jframe
    public AperitivoControlador(AperitivoDAO DAOAperitivo) {
        this.DAOAperitivo = DAOAperitivo;
    }
    public List<Aperitivo> listarAperitivos(){
        return DAOAperitivo.listarAperitivos();
    }
    public double obtenerPrecioAperitivo(int idAperitivo) {
        return DAOAperitivo.obtenerPrecioAperitivo(idAperitivo);
    }
}
