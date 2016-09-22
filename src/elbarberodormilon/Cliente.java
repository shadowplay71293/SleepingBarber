package elbarberodormilon;


public class Cliente implements Runnable
{
    String nombre;
    Barberia bar;
 
    public Cliente(Barberia shop){
        this.bar = shop;
    }
 
    public String obtenerNombre() {
        return nombre;
    }
 
    public void nombrar(String name) {
        this.nombre = name;
    }
 
    public void run(){
        cortarseElPelo();
    }
    private synchronized void cortarseElPelo(){
        bar.agregar(this);
    }
}