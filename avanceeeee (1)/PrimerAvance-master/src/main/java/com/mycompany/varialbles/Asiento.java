
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
    
    
    
}
