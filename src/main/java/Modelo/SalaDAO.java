/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class SalaDAO {
     Connection connection = cConexion.CConection.estableceConexion();  // Establecer conexión
     
    public List<String> listarSalas() {
    List<String> salas = new ArrayList<>();
    String sql = "SELECT id_sala, nombre FROM sala";

    try (
          PreparedStatement stmt = connection.prepareStatement(sql); 
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            int idSala = rs.getInt("id_sala");
            String nombreSala = rs.getString("nombre");
            salas.add(idSala + ". " + nombreSala);
        }
  JOptionPane.showMessageDialog(null, " las salas obtenidas: " );
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al obtener las salas: " + e.getMessage());
    }
    return salas;
}
    
    
    public List<String> listarFilasPorSala(int idSala) {
    List<String> filas = new ArrayList<>();
    String sql = "SELECT DISTINCT fila FROM asiento WHERE id_sala = ?";

    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setInt(1, idSala);

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String fila = rs.getString("fila");
                filas.add(fila);
            }
        }
   JOptionPane.showMessageDialog(null,"Filas obtenidas" );
    
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al obtener las filas de la sala: " + e.getMessage());
    }
    return filas;
}

    public List<Integer> listarAsientosDisponibles(int idSala, String fila) {
    List<Integer> asientosDisponibles = new ArrayList<>();
    String sql = "SELECT numero FROM asiento WHERE id_sala = ? AND fila = ? AND disponible = TRUE";

    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setInt(1, idSala);
        stmt.setString(2, fila);

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int numeroAsiento = rs.getInt("numero");
                asientosDisponibles.add(numeroAsiento);
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al obtener los asientos disponibles: " + e.getMessage());
    }
    return asientosDisponibles;
}
    
    
public boolean reservarAsiento(int idSala, String fila, int numeroAsiento) {
    String sql = "UPDATE asiento SET disponible = FALSE WHERE id_sala = ? AND fila = ? AND numero = ? AND disponible = TRUE";

    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setInt(1, idSala);
        stmt.setString(2, fila);
        stmt.setInt(3, numeroAsiento);

        int rowsUpdated = stmt.executeUpdate();
        if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(null, "Asiento reservado correctamente.");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "El asiento no está disponible.");
            return false;
        }

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al reservar el asiento: " + e.getMessage());
        return false;
    }
}


}
