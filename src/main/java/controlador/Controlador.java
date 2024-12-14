package controlador;

import Modelo.Pelicula;
import Modelo.Usuario;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import vista.MenuPrincipalClass;

public class Controlador {
    private MenuPrincipalClass vista;
    private Scanner scanner;
    private Usuario usuarioActual;

  
    // Registrar un nuevo usuario
    public void registrarUsuario(Usuario usuario) {
        // Lógica de almacenamiento (en base de datos o en memoria)
        System.out.println("Usuario registrado exitosamente.");
    }

    // Iniciar sesión de usuario
    public boolean iniciarSesion(String email, String contrasena) {
        // Lógica para validar usuario en base de datos (simulada aquí)
        if ("usuario@example.com".equals(email) && "password123".equals(contrasena)) {
            usuarioActual = new Usuario("Usuario", email, contrasena);
            return true;
        }
        return false;
    }

    // Mostrar películas disponibles
    public void mostrarPeliculas() {
        List<Pelicula> peliculas = obtenerPeliculas();
        System.out.println("\nPelículas disponibles:");
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula.getIdPelicula() + ". " + pelicula.getTitulo() + " - " + pelicula.getGenero());
        }
    }

    // Obtener las películas disponibles (simulado con una lista fija)
    private List<Pelicula> obtenerPeliculas() {
        // Cambié List.of() por un ArrayList para mayor flexibilidad
        List<Pelicula> peliculas = new ArrayList<>();
        /*
        peliculas.add(new Pelicula(1, "Película 1", "Acción", 120, "A"));
        peliculas.add(new Pelicula(2, "Película 2", "Comedia", 100, "B"));
*/
        return peliculas;
    }

    // Reservar película, asiento y aperitivos
    public void reservarPelicula(int idPelicula) {
        // Mostrar la información de la película
        System.out.println("Reserva de la película con ID: " + idPelicula);
        // Aquí puedes invocar otros métodos como seleccionar asiento, aperitivos, etc.
        seleccionarAsiento();
        seleccionarAperitivos();
        confirmarReserva();
    }

    private void seleccionarAsiento() {
        System.out.println("Selecciona un asiento (A, B, C...): ");
        // Simula la selección de un asiento, puedes hacer esto más dinámico
        String asiento = scanner.nextLine();
        System.out.println("Asiento " + asiento + " seleccionado.");
    }

    private void seleccionarAperitivos() {
        System.out.println("Selecciona aperitivos:");
        System.out.println("1. Palomitas");
        System.out.println("2. Refresco");
        System.out.println("3. Nada");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        String aperitivo = "";
        switch (opcion) {
            case 1:
                aperitivo = "Palomitas";
                break;
            case 2:
                aperitivo = "Refresco";
                break;
            case 3:
                aperitivo = "Nada";
                break;
            default:
                System.out.println("Opción no válida, no se selecciona aperitivo.");
        }
        System.out.println("Aperitivo seleccionado: " + aperitivo);
    }

    private void confirmarReserva() {
        System.out.println("Reserva confirmada.");
        // Lógica para confirmar la reserva y almacenarla
    }

    // Mostrar historial de reservas (simulado)
    public void mostrarHistorialReservas() {
        System.out.println("Mostrando historial de reservas...");
        // Lógica para mostrar las reservas anteriores del usuario
    }
}
