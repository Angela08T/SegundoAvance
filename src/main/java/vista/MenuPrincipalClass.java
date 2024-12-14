package vista;

import Modelo.Aperitivo;
import Modelo.AperitivoDAO;
import Modelo.Pelicula;
import Modelo.PeliculaDAO;
import Modelo.Reserva;
import Modelo.ReservaDAO;
import Modelo.SalaDAO;
import Modelo.Usuario;
import controlador.AperitivoControlador;

import controlador.Controlador;
import controlador.PeliculaControlador;
import controlador.ReservaControlador;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.swing.SpringLayout;

public class MenuPrincipalClass {
    
    
    //---------------------------------------
                //Comentario
    //La clase controlador debe ser replazara por otra, solo se esta usando como referencia, al finalixzar sera indepemdozada por controladores independientes para cada categorioa
    //Se estan llamando a algunis metodos directamente del DAO, implementra su controlador y llamar desde ahi
    //Si hay metodos que estan en el DAO incorrecto moverlo a donde corresponde para mas orden
    
    
    //La funcionalidad de iniciar sesion y regisstrarse aun no esta implementado
    
    
    
    
    
    
    
    //Objetos
    Aperitivo aperativo = new Aperitivo();
            
       // Inicializa el DAO con datos simulados
        PeliculaDAO peliculaDAO = new PeliculaDAO();
        PeliculaControlador controladorP = new PeliculaControlador(peliculaDAO);

     //iNICIAMOS EL CONTROLADOR DE APERITIVOS
        AperitivoControlador controladorA = new AperitivoControlador(new AperitivoDAO());
               
       //iNICIALIZAMOS el CONTROLADOR dE rESERVA
       
       ReservaControlador controladorR = new  ReservaControlador(new ReservaDAO());
    
        
    //Se va usar ya cuando se trabaje con diseño
   // controladorP = new PeliculaControlador();
            
    private Scanner scanner;
    private Controlador controlador;

    public MenuPrincipalClass() {
        this.scanner = new Scanner(System.in);
        this.controlador = new Controlador();
    }

    public static void main(String[] args) {
        MenuPrincipalClass menu = new MenuPrincipalClass();
        menu.mostrarMenuPrincipal();
    }

    public void mostrarMenuPrincipal() {
        int opcion;
        do {
            System.out.println("\n*** Bienvenido al Sistema de Reservas de Películas ***");
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1:
                        //Sin configurar
                        registrarUsuario();
                        break;
                    case 2:
                        //Sin configurar
                        iniciarSesion();
                        break;
                    case 3:
                        System.out.println("¡Hasta pronto!");
                        break;
                    default:
                        System.out.println("Opción no válida. Intenta de nuevo.");
                        
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingresa un número.");
                opcion = 0; // Evitar salida accidental
            }
        } while (opcion != 3);
    }

    
    public void registrarUsuario() {
        System.out.println("\n*** Registro de Usuario ***");
        System.out.print("Ingresa tu nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingresa tu email: ");
        String email = scanner.nextLine();
        System.out.print("Ingresa tu contraseña: ");
        String contrasena = scanner.nextLine();

        Usuario nuevoUsuario = new Usuario(nombre, email, contrasena);
        //Sin configurar
        controlador.registrarUsuario(nuevoUsuario);
        
        mostrarMenu();
    }
    
    
    
    
//Metodo Sin configurar
    public void iniciarSesion() {
        System.out.println("\n*** Iniciar sesión ***");
        System.out.print("Ingresa tu email: ");
        String email = scanner.nextLine();
        System.out.print("Ingresa tu contraseña: ");
        String contrasena = scanner.nextLine();

        if (controlador.iniciarSesion(email, contrasena)) {
            mostrarMenu();
        } else {
            System.out.println("Credenciales incorrectas. Intenta de nuevo.");
        }
    }

    
    //En desarrollo
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n*** Menú de Reserva ***");
            System.out.println("1. Ver películas disponibles");
            System.out.println("2. Ver Aperetivos");
            System.out.println("3. Ver mis reservas");
            System.out.println("4. Ver mis boletos ");
            System.out.println("5. Salir");
            
            System.out.print("Elige una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1:
                        //Ya funcionando
                        mostrarPeliculas();
                        //En proceso 80&
                        realizarReserva();
                        break;

                    case 2:
                        //Logica de Aperitivos
                        //Ya configurado al 70%%--aun falta rederigir para realizar la compra
                        
                      listarAperitivos();
                      
                        break;
                    case 3:
                        
                        System.out.println("Ingrese el id");
                        int idReserva =scanner.nextInt();
                          //En funcion
                        controladorR.verMisReservas(idReserva);
                        break;
                     case 4:  
                          System.out.println("Regresando al menú principal...");
                         break;
                     case 5:
                         //Loguica de reporte de boletos generados
                         //Aun no hay nada relacionado
                        break;
                    default:
                        System.out.println("Opción no válida. Intenta de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingresa un número.");
                opcion = 0; // Evitar salida accidental
            }
        } while (opcion != 3);
    }
    
    
    
    
//Metodo configurado al 80%--->falta remplazar los datos por reales
    public void realizarReserva() {
        
     
            System.out.print("Ingresa el ID de la película que deseas reservar: ");
            int idPelicula = scanner.nextInt();
            //controlador.reservarPelicula(idPelicula);
            
            
            //Estamos suponiendo que el id del usuario es 1
            //-------------------------------------------------------
            int idUsuario =1;
           // -------------------------------------------
                //Solo se esta registrando el usuario y la pelicula(SOlo se esta considerando una sopla pelicula)
              int idReserva= controladorR.registrarReserva(idUsuario,idPelicula);
               
               //Se esta registrando los detalles de acuerdo al idreserva obtenido previamente
         
               
               
               
//Se esta suponiendo datos sde acuerdo a la BD (REMPALZAR POR LOS REALES)

//-------------------------------------------------------------------------
         int idHorario = controladorP.obtenerIdHorarioPorPelicula(idPelicula);
            System.out.println("EL id el horario es: "+idHorario); 
          SalaDAO salaDao =new SalaDAO();
    
      // Paso 1: Listar salas
        List<String> salas = salaDao.listarSalas();
        
        System.out.println("Salas disponibles:");
        for (String sala : salas) {
            System.out.println(sala);
        }
        System.out.println("Ingrese el id de la sala");
          int idSala = scanner.nextInt(); 
             // Paso 2: Listar las filas de la sala seleccionada
             
        List<String> filas =salaDao.listarFilasPorSala(idSala);
        
         System.out.println("----------------------------------------------------------------");
        System.out.println("Filas disponibles en la sala seleccionada:");
    
        
        for (String fila : filas) {
            System.out.println(fila);
        }
          System.out.println("----------------------------------------------------------------");
        System.out.println("Seleccióne la fila");        // Seleccionar una fila (por ejemplo, fila A)
        String filaSeleccionada = scanner.next();
       
        List<Integer> asientosDisponibles = salaDao.listarAsientosDisponibles(idSala, filaSeleccionada);
        System.out.println("----------------------------------------------------------------");
        System.out.println("Asientos disponibles en la fila " + filaSeleccionada + ":");
        for (int asiento : asientosDisponibles) {
            System.out.println("Asiento número: " + asiento);
        }
          System.out.println("----------------------------------------------------------------");
        System.out.println("Seleccióne el asiento");
           int idAsiento= scanner.nextInt();
           
           boolean reservacionExitosa = salaDao.reservarAsiento(idSala, filaSeleccionada, idAsiento);
        if (reservacionExitosa) {
            System.out.println("¡Reserva exitosa!");
          controladorR.registrarDetallesReserva(idReserva, idHorario, idSala, idAsiento);
        } else {
            System.out.println("La reserva falló.");
            
        }
                
        
 //-------------------------------------------------------------------------
 
          System.out.println("----------------------------------------------------------------");
          System.out.println("DESEA APERITIVOS? (SI/NO)");
          String decision = scanner.next();
        
          if(decision.equalsIgnoreCase("SI")){ 
              
           listarAperitivos();
          System.out.println("Ingrese el id del aperitivo");
          
          int idAperitivo = scanner.nextInt();
          System.out.println("Ingrese la cantidad");
          int cantidad = scanner.nextInt();
          
          //Falta implementar atravez de un metodo de busqueda(Ya implementado)
          
          //-----------------S-----------------------------------------------
          double precio =controladorA.obtenerPrecioAperitivo(idAperitivo);
       
          //-----------------------------------------
         
             double subTotal=cantidad*precio;
          controladorR.registrarDetallesAperitivo(idReserva, idAperitivo, cantidad, subTotal);
          
          //Logica del boleto de esta compra
          controladorR.generarBoleta(idReserva);

        }else if(decision.equalsIgnoreCase("NO")){
           //Logica del boleto de esta compra
           controladorR.generarBoleta(idReserva);

          }
       
        } 
    
    
    //Metodo Configurado
    public void  mostrarPeliculas(){
        
         List<Pelicula> peliculas;
        peliculas = controladorP.obtenerPeliculas();
       
        System.out.println("\nPelículas disponibles:");
        
     for (Pelicula pelicula : peliculas) {
    System.out.println("--------------------------------------------------");
    System.out.println("ID: " + pelicula.getIdPelicula());
    System.out.println("Título: " + pelicula.getTitulo());
    System.out.println("Género: " + pelicula.getGenero());
    System.out.println("Duración: " + pelicula.getDuracion() + " minutos");
    System.out.println("Clasificación: " + pelicula.getClasificacion());
    System.out.println("Precio: " + pelicula.getPrecio());
    System.out.println("Fecha de proyección: " + (pelicula.getFecha() != null ? pelicula.getFecha() : "No disponible"));
    System.out.println("Hora de proyección: " + (pelicula.getHora() != null ? pelicula.getHora() : "No disponible"));
    System.out.println("--------------------------------------------------");
}

     
     
    }
    public void listarAperitivos(){
          List<Aperitivo> aperitivos ;
        
       aperitivos = controladorA.listarAperitivos();
        System.out.println("\nAperitivos disponibles:");
        
        for(Aperitivo listarAperitivo: aperitivos){
            System.out.println("ID: "+listarAperitivo.getIdAperitivo()+" NOMRE: "+listarAperitivo.getNombre()+" PRECIO:"+listarAperitivo.getPrecio()+" Soles");
        }
    }
     
 

    
}
