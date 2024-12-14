/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class AperitivoDAO {
    private Connection connection = cConexion.CConection.estableceConexion();
    //En funcion
    public List<Aperitivo> listarAperitivos(){
      List<Aperitivo> aperitivos = new ArrayList<>();
      
       String sql = "SELECT * FROM aperitivo";
       
    try (
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql)
    ) {
        while (rs.next()) {
            Aperitivo  aperitivo= new Aperitivo();
            
            aperitivo.setIdAperitivo(rs.getInt("id_aperitivo"));
            aperitivo.setNombre(rs.getString("Nombre"));
            aperitivo.setPrecio(rs.getDouble("precio"));
            aperitivos.add(aperitivo);
           
                
        }
        
           JOptionPane.showMessageDialog(null, "Aperitivos Cargado correctamente");
                 
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "ERROR-AL CARGAR Aperitivos"+e.getMessage());
              
    }
    return aperitivos;

    }
    public double obtenerPrecioAperitivo(int idAperitivo) {
    String sql = "SELECT precio FROM aperitivo WHERE id_aperitivo = ?";
    double precio = 0.0;

    try (
          PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setInt(1, idAperitivo);

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                precio = rs.getDouble("precio");
            } else {
                JOptionPane.showMessageDialog(null, "Aperitivo no encontrado.");
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al obtener el precio del aperitivo: " + e.getMessage());
    }

    return precio;
}

    
    
}
