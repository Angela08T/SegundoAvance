package com.mycompany.varialbles;

public class cliente {
    private String nombre;
    private String correo;
    private int DNI;
    
    public cliente(String nombre, String correo, int DNI){
        
        this.nombre = nombre;
        this.DNI = DNI;
        this.correo = correo;
        
    }
    public String getnombre(){
        return nombre;
    }
    public void setnombre(String nombre) {
        this.nombre = nombre;
    }
    public String getcorreo() {
        return correo;
    }
    public void setcorreo(String correo) {
        this.correo = correo;
    }
    
    public int getDNI() {
        return DNI;
    }
    public void setDNI(int DNI) {
        this.DNI = DNI;
    }
    
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Correo: " + correo);
        System.out.println("DNI: "+ DNI);
    }  
}
