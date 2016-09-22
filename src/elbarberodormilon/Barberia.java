package elbarberodormilon;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

class Barberia{
    int numSillas;
    List<Cliente> clientesSentados;
 
    public Barberia(){
        numSillas = 10;
        clientesSentados = new LinkedList<Cliente>();
    }
 
    public void corteDePelo(){
        Cliente cliente;
        
        synchronized (clientesSentados){
 
            while(clientesSentados.isEmpty()){
                System.out.println("German esta esperando algun cliente.");
                try{
                    clientesSentados.wait();
                }
                catch(InterruptedException e){}
            }
            System.out.println("German encontro un cliente sentado.");
            cliente = (Cliente)((LinkedList<?>)clientesSentados).poll();//quitamos a un cliente de la queue
        }
        long duracion=0;
        try{    
            System.out.println("German esta cortando el pelo del cliente num."+cliente.obtenerNombre()); //tiempo para cortar el pelo
            duracion = (long)(Math.random()*29+1);
            TimeUnit.SECONDS.sleep(duracion);
        }
        catch(InterruptedException e){}
        System.out.println("German le corto el pelo al cliente num."+cliente.obtenerNombre() );
    }
 
    public void agregar(Cliente clien)
    {
        System.out.println("El cliente num."+clien.obtenerNombre()+ " esta entrando.");
 
        synchronized (clientesSentados){
            if(clientesSentados.size() == numSillas){
                System.out.println("No hay silla disponible para el cliente num."+clien.obtenerNombre());
                System.out.println("Customer "+clien.obtenerNombre()+"Exists...");
                return ;
            }
 
            ((LinkedList<Cliente>)clientesSentados).offer(clien);
            System.out.println("El cliente num."+clien.obtenerNombre()+ " obtuvo una silla.");
             
            if(clientesSentados.size()==1)
                clientesSentados.notify();
        }
    }
}
