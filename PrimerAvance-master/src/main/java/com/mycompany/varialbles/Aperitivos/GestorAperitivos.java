
package com.mycompany.varialbles.Aperitivos;

import java.util.ArrayList;
import java.util.List;

public class GestorAperitivos<T extends Aperitivo> {
    private final List<T> aperitivos;

    public GestorAperitivos() {
        aperitivos = new ArrayList<>();
    }

    public List<T> obtenerAperitivos() {
        return aperitivos;
    }
    public void agregarAperitivo(T aperitivo) {
        aperitivos.add(aperitivo);
    }
    public void agregarAperitivos(List<T> nuevosAperitivos) {
        aperitivos.addAll(nuevosAperitivos);
    }

    public void infoAperitivos() {
        for (int i = 0; i < aperitivos.size(); i++) {
            System.out.println((i + 1) + ". " + aperitivos.get(i)); 
        }
    }
}

