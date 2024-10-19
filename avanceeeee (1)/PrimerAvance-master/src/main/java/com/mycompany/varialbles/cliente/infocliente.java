
package com.mycompany.varialbles.cliente;

import java.time.LocalDate;
import java.util.Scanner;

public class infocliente extends Cliente {
   
    public infocliente() {
    }
    public void ingresarDatos(){
        Scanner scn= new Scanner(System.in);
        System.out.print("Datos del Cliente: ");
        System.out.print("Nombre: ");
        this.setNombre(scn.next());
        System.out.print("Apellido paterno: ");
        this.setApellidoPaterno(scn.next());
        System.out.print("Apellido materno: ");
        this.setApellidoMaterno(scn.next());
        System.out.print("DNI: ");
        this.setDni(scn.next());
        System.out.print("Correo: ");
        this.setCorreo(scn.next());
        System.out.print("Edad: ");
        this.setEdad(scn.nextInt());
       
        this.setFechaRegistro(LocalDate.now());
    }    
    
}
