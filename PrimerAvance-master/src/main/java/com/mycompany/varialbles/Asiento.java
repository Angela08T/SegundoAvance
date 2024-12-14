
package com.mycompany.varialbles;

import java.util.Scanner;

public class Asiento {
    private int numero;
    private boolean ocupado;

    public Asiento() {
    }

    public Asiento(int numero, boolean ocupado) {
        this.numero = numero;
        this.ocupado = ocupado;
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    

    public void mostrarInformacion() {
        System.out.println("Asiento número: " + numero + " - " + (ocupado ? "Ocupado" : "Disponible"));
    }

    public void reservarAsiento() {
        if (!ocupado) {
            ocupado = true;
            System.out.println("El asiento " + numero + " ha sido reservado.");
        } else {
            System.out.println("El asiento " + numero + " ya está ocupado.");
        }
    }

   public static void mostrarAsientosDisponibles(Asiento[] asientos) {
    System.out.println("Asientos disponibles:");
    for (Asiento asiento : asientos) {
        if (!asiento.isOcupado()) {
            asiento.mostrarInformacion();
        }
    }
    }

   public static void seleccionarAsiento(Asiento[] asientos) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese el número del asiento que desea reservar:");
    int asientoSeleccionado = sc.nextInt();
    
    if (asientoSeleccionado < 1 || asientoSeleccionado > asientos.length) {
        System.out.println("Número de asiento inválido.");
        return;
    }

    Asiento asiento = asientos[asientoSeleccionado - 1];
    if (!asiento.isOcupado()) {
        asiento.reservarAsiento();
    } else {
        System.out.println("El asiento " + asientoSeleccionado + " ya está ocupado.");
    }
}
    @Override
   public String toString(){
       return String.valueOf(numero);
   }
}
