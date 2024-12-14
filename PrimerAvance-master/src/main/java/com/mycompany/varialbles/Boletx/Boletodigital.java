
package com.mycompany.varialbles.Boletx;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Boletodigital implements GeneradorBoleto{
    LocalDateTime fechaHoraActual=LocalDateTime.now();
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @Override
    public void imprimirBoleto(Boleto boleto) {
        System.out.println("######Boleto Digital######");
        System.out.println(" Emisión:     "+fechaHoraActual.format(formato));
        System.out.println(" Cliente: "+boleto.getCliente().getNombre()+" "+boleto.getCliente().getApellidoPaterno());
        System.out.println(" DNI: "+boleto.getCliente().getDni());
        System.out.println(" Gmail: "+boleto.getCliente().getCorreo());
        System.out.println(" Pelicula: "+boleto.getPelicula().titulo());
        System.out.println(" Precio: "+boleto.getPelicula().precio());
        System.out.println(" Asiento: "+boleto.getAsiento());
        System.out.println(" Codigo entrada:"+boleto.getCodigoentrada());
    }
    
}
