
package com.mycompany.varialbles.proyecto_poo;
import com.mycompany.varialbles.Operaciones;
import com.mycompany.varialbles.cliente.infocliente;
import java.util.Scanner;

public class Cine {
    public static void main(String[] args) {
        Scanner scn= new Scanner(System.in);
        infocliente cliente=new infocliente();
        Operaciones operacion=new Operaciones();
        int opcion;
        do{
            System.out.println("   BIENVENIDO A CINEPLANET ");
            System.out.println("1. Crear usuario");
            System.out.println("2. Operaciones");
            System.out.println("3. Salir");
            
            opcion=scn.nextInt();
        switch (opcion) {
            case 1:
                cliente.ingresarDatos();
                break;
            case 2:
                operacion.menuprincipal();
                break;
            case 3:
                System.out.println("Gracias por su visita");
                break;
                
        }      
        }while(opcion!=3);
    }
    
}
