package elbarberodormilon;

import java.util.concurrent.TimeUnit;

public class GeneradorDeClientes implements Runnable{
    Barberia barberia;
 
    public GeneradorDeClientes(Barberia bar){
        this.barberia = bar;
    }
 
    public void run(){
        int i=0;
        while(true){
            i++;
            Cliente cliente = new Cliente(barberia);
            cliente.nombrar(""+i);
            Thread hiloCliente = new Thread(cliente);
            System.out.println("Un cliente salvaje con el num."+cliente.nombre+" aparecio, tiene el pelo muy largo.");
            hiloCliente.start();
 
            try{
                TimeUnit.SECONDS.sleep((long)(Math.random()*9+1));
            }
            catch(InterruptedException e){}
        }
    }
 
}
 