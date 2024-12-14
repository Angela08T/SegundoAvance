
package Modelo;

import java.sql.*;

import java.sql.*;

public class UsuarioDAO {
    Connection connection = cConexion.CConection.estableceConexion();  // Establecer conexión

    // Registrar un nuevo usuario
    public void registrarUsuario(Usuario usuario) throws SQLException {
        String query = "INSERT INTO usuarios (nombre, email, contraseña, tipo_usuario) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getContraseña());
            stmt.setString(4, usuario.getTipoUsuario());
            stmt.executeUpdate();
        }
    }

    // Obtener un usuario por email y contraseña
    Usuario usuario;
    public Usuario obtenerUsuario(String email, String contraseña) throws SQLException {
        String query = "SELECT * FROM usuarios WHERE email = ? AND contraseña = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, email);
            stmt.setString(2, contraseña);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
           //     Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setEmail(rs.getString("email"));
                usuario.setContraseña(rs.getString("contraseña"));
                usuario.setTipoUsuario(rs.getString("tipo_usuario"));
                return usuario;
            }
        }
        return null;
    }
}
