    
package com.mycompany.varialbles;

import com.mycompany.varialbles.Aperitivos.AperitivosDisponibles;
import com.mycompany.varialbles.Aperitivos.Cancha;
import com.mycompany.varialbles.Aperitivos.Gaseosa;
import com.mycompany.varialbles.Aperitivos.GestorAperitivos;
import com.mycompany.varialbles.Boletx.Boleto;
import com.mycompany.varialbles.Boletx.BoletoFisico;
import com.mycompany.varialbles.Boletx.Boletodigital;
import com.mycompany.varialbles.Boletx.GeneradorBoleto;
import com.mycompany.varialbles.Boletx.GestionBoletos;
import com.mycompany.varialbles.cliente.infocliente;
import com.mycompany.varialbles.proyecto_poo.Peliculas.GestorPeliculas; import com.mycompany.varialbles.proyecto_poo.Peliculas.PeliculasEnCartelera;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

    public class Operaciones {
        String[] operaciones = {"1. Peliculas disponibles", "2. Comprar boletos", "3. Generar boleto", "4. Gestionar Peliculas", "5. Aperitivos", "6. Finalizar"};
        int opcion;
        PeliculasEnCartelera peliculaSeleccionada = null;      
        Asiento[] asientos = new Asiento[30];    
        GestorPeliculas gestor = new GestorPeliculas();
        List<Boleto> boletosComprados = new ArrayList<>();
        private infocliente cliente; 
        public void setCliente(infocliente cliente) {
        this.cliente = cliente;
        }       
        GestionBoletos gestionboletos=new GestionBoletos();
        public void menuprincipal() {
            gestor.infopeliculas();  
        
            for (int i = 0; i < asientos.length; i++) {
                asientos[i] = new Asiento(i + 1, false);  
            }
            do {
                try{
                Scanner sc = new Scanner(System.in);
                for (String operacion : operaciones) {
                    System.out.println(operacion);
                }
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:                 
                        gestor.mostrarInformacionDePeliculas();
                        elegirPelicula();  
                        break;
                    case 2:
                        if (peliculaSeleccionada != null) {
                            submenucompra();  
                        } else {
                            System.out.println("Primero debe seleccionar una película.");
                        }
                        break;
                    case 3:
                        
                        submenuGenerarBoleta();                           
                        
                        break;
                    case 4:
                        gestionarPeliculas();
                        break;
                    case 5:
                        opcionAperitivos();
                        break;
                    case 6:
                        System.out.println("FINALIZANDO");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente de nuevo.");
                        break;
                }
                }catch(InputMismatchException e){
                        System.out.println("Por favor pulsa solo números.");
                 }              
            } while (opcion != 6);
        }

    public void elegirPelicula() {
            Scanner sc = new Scanner(System.in);

        System.out.println("Seleccione una película por número:");   
        int i = 0;
        for (PeliculasEnCartelera pelicula : gestor.getPeliculas()) {
        
        System.out.println((i + 1) + ". " + pelicula.pelicula().titulo());
        i++;
        }
         System.out.println("Ingrese el número de la película que desea seleccionar (1 - " + gestor.getPeliculas().size() + "):");
        int seleccion = sc.nextInt();

         i = 0; 
        for (PeliculasEnCartelera pelicula : gestor.getPeliculas()) {
        if (i == seleccion - 1) {
            peliculaSeleccionada = pelicula;
            break; 
        }
        i++;
        }
        if (peliculaSeleccionada != null) {
        System.out.println("Película seleccionada: " + peliculaSeleccionada.pelicula().titulo());
        } else {
        System.out.println("Selección inválida.");
        }
    }
    public void submenucompra() {       
            Scanner sc = new Scanner(System.in);
            int cantidadboletos;
            System.out.println("¿Cuántos boletos desea comprar para la película: " + peliculaSeleccionada.pelicula().titulo() + "?");
            cantidadboletos = sc.nextInt();

            if (cantidadboletos > 30 || cantidadboletos <= 0) {
                System.out.println("Número de boletos inválido.");
                return;
            }
                     
            for (int i = 1; i <= cantidadboletos; i++) {
                boolean seleccionando = true;
                while (seleccionando) {
                    Asiento.mostrarAsientosDisponibles(asientos);  
                    System.out.println("Escoja su asiento (1-30):");
                    int asientoSeleccionado = sc.nextInt();
                    if (asientoSeleccionado < 1 || asientoSeleccionado > 30) {
                        System.out.println("Número de asiento inválido. Por favor, intente de nuevo.");
                    } else {
                        Asiento asiento = asientos[asientoSeleccionado - 1];
                        if (!asiento.isOcupado()) {
                            asiento.reservarAsiento();  
                            Boleto boleto = new Boleto(cliente,peliculaSeleccionada.pelicula(), asiento);
                        gestionboletos.agregarBoleto(boleto);
                        seleccionando = false;
                        System.out.println("¡Boleto comprado con éxito!");
                    } else {System.out.println("El asiento ya está ocupado. Elija otro.");
                        }
                    }
                }
            }
            System.out.println("Gracias por su compra de boletos.");
        }
        public void submenuGenerarBoleta(){
            Scanner sb=new Scanner(System.in);
            System.out.println("Que tipo de boleto desea: ");
            System.out.println("1.Boleto digital.");
            System.out.println("2.Boleto fisico.");
            int rpta=sb.nextInt();
            GeneradorBoleto generadorBoleto;
            if (rpta == 1) {
        generadorBoleto = new Boletodigital();
     } else if (rpta == 2) {
        generadorBoleto = new BoletoFisico();
     } else {
         System.out.println("Opción inválida.");
        return;
      }
    gestionboletos.imprimirBoletos(generadorBoleto);
    }
    
    public void opcionAperitivos(){
    AperitivosDisponibles aperitivosDisponibles = new AperitivosDisponibles();
    GestorAperitivos<Cancha> gestorCancha = aperitivosDisponibles.getGestorCancha();
    GestorAperitivos<Gaseosa> gestorGaseosa = aperitivosDisponibles.getGestorGaseosa();
    
    System.out.println("Seleccione un aperitivo:");
    System.out.println("1. Canchas");
    System.out.println("2. Gaseosas");

    Scanner sc = new Scanner(System.in);
    int opcionAperitivo = sc.nextInt();

    switch (opcionAperitivo) {
        case 1:
            System.out.println("Canchas disponibles:");
            gestorCancha.infoAperitivos();  
            System.out.println("Seleccione una cancha (número):");
            int seleccionCancha = sc.nextInt();
            
            if (seleccionCancha > 0 && seleccionCancha <= gestorCancha.obtenerAperitivos().size()) {
                System.out.println("Has seleccionado la cancha: " + gestorCancha.obtenerAperitivos().get(seleccionCancha-1));
            } else {
                System.out.println("Selección inválida.");
            }
            break;
        case 2:
            System.out.println("Gaseosas disponibles:");
            gestorGaseosa.infoAperitivos();  
            System.out.println("Seleccione una gaseosa (número):");
            int seleccionGaseosa = sc.nextInt();
            
            if (seleccionGaseosa > 0 && seleccionGaseosa <= gestorGaseosa.obtenerAperitivos().size()) {
                System.out.println("Has seleccionado la gaseosa: " + gestorGaseosa.obtenerAperitivos().get(seleccionGaseosa-1));
            } else {
                System.out.println("Selección inválida.");
            }
            break;
        default:
            System.out.println("Opción inválida.");
            break;
    }
    }
    public void gestionarPeliculas(){
        GestorPeliculas gestorpeli=new GestorPeliculas();
        Scanner op=new Scanner(System.in);
        System.out.println("Eliga una opción:");
        System.out.println("1. Ordenar las peliculas por nombre (A-Z)");
        System.out.println("2. Filtrar peliculas que ya no estén en cartelera");
        System.out.println("3. Buscar pelicula");
        System.out.println("4. Ordenar por fecha de publicación");
        System.out.println("5. Mostrar las peliculas en cartelera");
        System.out.println("6. Filtrar peliculas por género");
        int opcion=op.nextInt();
        switch (opcion) {
            case 1:
                gestorpeli.ordenarPorNombre();
                break;
            case 2:
                gestorpeli.filtrarPeliculasNoEnCartelera();
                break;
            case 3:
                gestorpeli.buscarPelicula();
                break;
            case 4:
                gestorpeli.mostrarPeliculasPorFechaDePublicación();
                break;
            case 5:
                gestorpeli.mostrarPeliculasEnCartelera();
                break;
            case 6:
                gestorpeli.filtrarPorGenero();
                break;
            default:
                throw new AssertionError();
        }
    }
    }
    
  