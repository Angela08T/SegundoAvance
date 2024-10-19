
package com.mycompany.varialbles.Aperitivos;

import java.util.List;

public class gestorAperitivos {
    private final List<Aperitivo> aperitivos;

    public gestorAperitivos(List<Aperitivo> aperitivos) {
        this.aperitivos = aperitivos;
    }

    public List<Aperitivo> getAperitivos() {
        return aperitivos;
    }
    public void infoAperitivos(){
        aperitivos.add(new Cancha("salada","Cancha de maiz",7,"grande"));
        aperitivos.add(new Gaseosa("Zero","Coca Cola",8,"personal"));
    }

}
