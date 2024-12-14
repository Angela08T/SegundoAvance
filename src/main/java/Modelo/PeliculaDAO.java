package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

public class PeliculaDAO {
     Connection connection = cConexion.CConection.estableceConexion();  // Establecer conexión
     
    // Obtener todas las películas
     //Metodo funcionando correctamente
     

public List<Pelicula> obtenerPeliculasConHorariosYPrecio() {
    List<Pelicula> peliculas = new ArrayList<>();
    String sql = "{ CALL MostrarTodasLasPeliculas() }"; // Llamada al procedimiento almacenado

    try (
        CallableStatement cstmt = connection.prepareCall(sql);
        ResultSet rs = cstmt.executeQuery()
    ) {
        while (rs.next()) {
            Pelicula pelicula = new Pelicula();
            pelicula.setIdPelicula(rs.getInt("id_pelicula"));
            pelicula.setTitulo(rs.getString("titulo"));
            pelicula.setGenero(rs.getString("genero"));
            pelicula.setDuracion(rs.getInt("duracion"));
            pelicula.setClasificacion(rs.getString("clasificacion"));
            pelicula.setPrecio(rs.getBigDecimal("precio"));
            pelicula.setFecha(rs.getDate("fecha"));
            pelicula.setHora(rs.getTime("hora"));

            peliculas.add(pelicula);
        }

        JOptionPane.showMessageDialog(null, "Películas cargadas correctamente.");

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "ERROR al cargar las películas: " + e.getMessage());
    }

    return peliculas;
}
    // Método para obtener el id_horario por id_pelicula
  public int obtenerIdHorarioPorPelicula(int idPelicula) {
    int idHorario = -1; // Valor por defecto en caso de que no se encuentre ningún horario

    String sql = "SELECT id_horario FROM horario WHERE id_pelicula = ? LIMIT 1"; // Limitar a un solo resultado

    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setInt(1, idPelicula);

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) { // Si se encuentra un resultado
                idHorario = rs.getInt("id_horario");
            }
        }

        JOptionPane.showMessageDialog(null, "Consulta ejecutada correctamente");

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al realizar la consulta: " + e.getMessage());
    }

    return idHorario;
}

            
        
}

