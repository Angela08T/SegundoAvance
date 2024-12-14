
package com.mycompany.varialbles.Boletx;

import java.util.ArrayList;
import java.util.List;


public class GestionBoletos {
     private List<Boleto> boletos = new ArrayList<>();

    public void agregarBoleto(Boleto boleto) {
        boletos.add(boleto);
    }

    public void imprimirBoletos(GeneradorBoleto generadorBoleto) {
        if (boletos.isEmpty()) {
            System.out.println("No hay boletos para imprimir.");
        } else {
            for (Boleto boleto : boletos) {
                generadorBoleto.imprimirBoleto(boleto);
            }
        }
    }
     public List<Boleto> obtenerBoletos() {
        return boletos;
    }
}
    
    
    
   


