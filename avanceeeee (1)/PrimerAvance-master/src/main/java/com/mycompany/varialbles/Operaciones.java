    
package com.mycompany.varialbles;

import com.mycompany.varialbles.proyecto_poo.Peliculas.gestorpeliculas;
import java.util.Scanner;


public class Operaciones {
    String[] operaciones={"1. Peliculas disponibles","2. Comprar boletos","3. Generar boleta","4. Obtener boletos","5. Aperitivos","6. Finalizar"};
    boolean apagado=true; 
    int opcion;
    public void menuprincipal(){
        gestorpeliculas gestor=new gestorpeliculas();
        gestor.infopeliculas();
        do{
            Scanner sc=new Scanner(System.in);
            for(String operacion:operaciones){
                System.out.println(operacion);
            }
        opcion=sc.nextInt();
        switch (opcion) {
            case 1:
                gestor.mostrarInformacion();
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4:
                
                break;
            case 5:
                apagado=false;
                break;
            default:
                System.out.println("Opción inválida. Intente de nuevo.");
                break;
            
        }
        }while(apagado);   
}
     public void submenucompra(){
         Asiento asiento=new Asiento();
         Scanner sc=new Scanner(System.in);
         int opcioncompra;
         int cantidadboletos;
         boolean comprando=true;
         System.out.println("¿Cuantos boletos desea comprar?");
         cantidadboletos=sc.nextInt();
         
        for(int i=1;i<=cantidadboletos;i++){
             boolean seleccionando=true;
             while(seleccionando){
                 System.out.println("Escoja su asiento(1-30):");    
                 
             }
        }
    } 
}