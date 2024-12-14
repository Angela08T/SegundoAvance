
package com.mycompany.varialbles.Aperitivos;

public class AperitivosDisponibles {
    private GestorAperitivos<Cancha> gestorCancha;
    private GestorAperitivos<Gaseosa> gestorGaseosa;

    public AperitivosDisponibles() {
        gestorCancha = new GestorAperitivos<>();
        gestorCancha.agregarAperitivo(new Cancha("Salada", "Cancha de maíz", 6, "Grande"));
        gestorCancha.agregarAperitivo(new Cancha("Dulce", "Cancha de maíz", 5, "Mediana"));

        gestorGaseosa = new GestorAperitivos<>();
        gestorGaseosa.agregarAperitivo(new Gaseosa("Zero", "Coca Cola", 7, "Personal"));
        gestorGaseosa.agregarAperitivo(new Gaseosa("Normal", "Inka Cola", 6, "Personal"));
    }

    public GestorAperitivos<Cancha> getGestorCancha() {
        return gestorCancha;
    }

    public GestorAperitivos<Gaseosa> getGestorGaseosa() {
        return gestorGaseosa;
    }
}

