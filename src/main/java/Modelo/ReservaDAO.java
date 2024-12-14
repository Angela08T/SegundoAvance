/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ReservaDAO {
    Connection connection = cConexion.CConection.estableceConexion();  // Establecer conexión
     //Metodo en funcion
    public int registrarReserva(int idUsuario, int idPelicula) {
    try (
          
         CallableStatement stmt = connection.prepareCall("{CALL RegistrarReserva(?, ?, ?)}")) {

        stmt.setInt(1, idUsuario);
        stmt.setInt(2, idPelicula);
      
        stmt.execute();

        int idReserva = stmt.getInt(3);
        System.out.println("Reserva registrada con ID: " + idReserva);
        JOptionPane.showMessageDialog(null, "Registro correcto con id: "+idReserva);
        return idReserva;
       

    } catch (SQLException e) {
        e.printStackTrace();
         JOptionPane.showMessageDialog(null, "Error en el registro ");
        return -1;
    }
}
      //Metodo en funcion
    public void registrarDetallesReserva(int idReserva, int idHorario, int idSala, int idAsiento) {
    try (
            
         CallableStatement stmt = connection.prepareCall("{CALL RegistrarDetallesReserva(?, ?, ?, ?)}")) {

        stmt.setInt(1, idReserva);
        stmt.setInt(2, idHorario);
        stmt.setInt(3, idSala);
        stmt.setInt(4, idAsiento);

        stmt.execute();
        System.out.println("Detalle de reserva registrado.");
       JOptionPane.showMessageDialog(null, "Detalle de reserva registrado.");
    } catch (SQLException e) {
        e.printStackTrace();
         JOptionPane.showMessageDialog(null, "ERROR--Detalle  de reserva NO registrado.");
    }
}
      //Metodo en funcion
public void registrarDetallesAperitivo(int idReserva, int idAperitivo, int cantidad, double subtotal) {
    try (
           
         CallableStatement stmt = connection.prepareCall("{CALL RegistrarDetallesAperitivo(?, ?, ?, ?)}")) {

        stmt.setInt(1, idReserva);
        stmt.setInt(2, idAperitivo);
        stmt.setInt(3, cantidad);
        stmt.setDouble(4, subtotal);

        stmt.execute();
        System.out.println("Detalle de aperitivo registrado.");
        JOptionPane.showMessageDialog(null, "Detalle de aperitivo registrado.");

    } catch (SQLException e) {
        e.printStackTrace();
          JOptionPane.showMessageDialog(null, "ERRORR--Detalle de aperitivo NO registrado.");

    }
}
  //Metodo en funcion
    public  void verMisReservas(int idUsuario) {
      
        CallableStatement stmt = null;
        ResultSet rs = null;

        try {
    
  
            String sql = "{CALL VerMisReservas(?)}";
            stmt = connection.prepareCall(sql);
            stmt.setInt(1, idUsuario); 

            // Ejecutar el procedimiento
            rs = stmt.executeQuery();

            // Mostrar los resultados
            while (rs.next()) {
                int idReserva = rs.getInt("id_reserva");
                Date fechaReserva = rs.getDate("fecha_reserva");
                String nombrePelicula = rs.getString("nombre_pelicula");
                Date horaPelicula = rs.getDate("hora_pelicula");
                String nombreAperitivo = rs.getString("nombre_aperitivo");
                int cantidadAperitivo = rs.getInt("cantidad_aperitivo");
                double subtotalAperitivo = rs.getDouble("subtotal_aperitivo");

                System.out.println("ID Reserva: " + idReserva);
                System.out.println("Fecha Reserva: " + fechaReserva);
                System.out.println("Película: " + nombrePelicula);
                System.out.println("Hora Película: " + horaPelicula);
                if (nombreAperitivo != null) {
                    System.out.println("Aperitivo: " + nombreAperitivo);
                    System.out.println("Cantidad: " + cantidadAperitivo);
                    System.out.println("Subtotal Aperitivo: " + subtotalAperitivo);
                } else {
                    System.out.println("No se compraron aperitivos.");
                }
                System.out.println("--------------------------------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
}

    
    
    public void generarBoleta(int idReserva) {
  
    CallableStatement stmt = null;
    ResultSet rs1 = null, rs2 = null, rs3 = null;

    try {
        // Ejecutar procedimiento para obtener la boleta
        stmt = connection.prepareCall("{CALL ObtenerBoletaReserva(?)}");
        stmt.setInt(1, idReserva);

        // Obtener datos de la reserva
        rs1 = stmt.executeQuery();
        if (rs1.next()) {
            System.out.println("--------------------------------------------");
            System.out.println("             CINEPLANET - BOLETA DE RESERVA");
            System.out.println("--------------------------------------------");
            System.out.println("Fecha de Emisión: " + rs1.getTimestamp("FechaReserva"));
            System.out.println("Número de Reserva: " + rs1.getInt("NumeroReserva"));
            System.out.println("--------------------------------------------");
            System.out.println("Cliente: " + rs1.getString("NombreCliente"));
            System.out.println("Correo: " + rs1.getString("CorreoCliente"));
            System.out.println("--------------------------------------------");
            System.out.println("Película: " + rs1.getString("Pelicula"));
            System.out.println("Género: " + rs1.getString("Genero"));
            System.out.println("Duración: " + rs1.getInt("Duracion") + " minutos");
            System.out.println("Clasificación: " + rs1.getString("Clasificacion"));
            System.out.println("Precio Película: S/ " + rs1.getDouble("PrecioPelicula"));
            System.out.println("--------------------------------------------");
        }

        // Obtener detalles de asientos
        System.out.println("Detalles de la Reserva:");
        
        List<DetalleReserva> detalles =obtenerDetallesReserva(16);
      for (DetalleReserva detalle : detalles) {
            System.out.println(detalle);
        }
      
        System.out.println("--------------------------------------------");

        // Obtener detalles de aperitivos
        System.out.println("Aperitivos:");
                  List<DetalleAperitivo> aperitivos =listarAperitivosPorReserva(idReserva);
                 for (DetalleAperitivo detalle : aperitivos) {
                System.out.println(detalle);
                }
        System.out.println("--------------------------------------------");
        System.out.println("TOTAL A PAGAR: S/ " + calcularTotal(idReserva));
        System.out.println("--------------------------------------------");
        System.out.println("       ¡Gracias por elegir CINEPLANETs!");
        System.out.println("--------------------------------------------");

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs1 != null) rs1.close();
            if (rs2 != null) rs2.close();
            if (rs3 != null) rs3.close();
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
    

       public List<DetalleReserva> obtenerDetallesReserva(int idReserva) {
        List<DetalleReserva> detalles = new ArrayList<>();

            String sql = "{CALL ObtenerDetallesReserva(?)}";  // Llamamos al procedimiento con el parámetro
            try (CallableStatement stmt = connection.prepareCall(sql)) {
                stmt.setInt(1, idReserva); // Establecer el parámetro p_id_reserva

                // Ejecutar la consulta
                try (ResultSet rs = stmt.executeQuery()) {
                    // Procesar el resultado
                    while (rs.next()) {
                        DetalleReserva detalle = new DetalleReserva();
                        detalle.setSala(rs.getString("Sala"));
                        detalle.setFila(rs.getString("Fila"));
                        detalle.setNumeroAsiento(rs.getInt("NumeroAsiento"));
                        detalles.add(detalle);
                    }
                
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Manejo de errores de conexión
        }

        return detalles;
    }
    
public List<DetalleAperitivo> listarAperitivosPorReserva(int idReserva) {
    List<DetalleAperitivo> aperitivos = new ArrayList<>();
    try (
        CallableStatement stmt = connection.prepareCall("{CALL ObtenerDetallesAperitivos(?)}")) {
        stmt.setInt(1, idReserva);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            DetalleAperitivo detalle = new DetalleAperitivo();
            
            detalle.setIdAperitivo(rs.getInt("AperitivoID"));
            detalle.setNombre(rs.getString("NombreAperitivo"));
            detalle.setCantidad(rs.getInt("Cantidad"));
            detalle.setSubtotal(rs.getDouble("Subtotal"));
            aperitivos.add(detalle);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return aperitivos;
}

// Método para calcular el total a pagar
private double calcularTotal(int idReserva) {
    double total = 0.0;
    try (
        CallableStatement stmt = connection.prepareCall("{CALL ObtenerTotal(?)}")) {
        stmt.setInt(1, idReserva);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            total = rs.getDouble("Total");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return total;
}


}
