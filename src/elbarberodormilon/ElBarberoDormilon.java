package elbarberodormilon;
 
public class ElBarberoDormilon {
 
    public static void main(String[] args){
        System.out.println("Los clientes se generan cada 1 a 10 segundos.");
        System.out.println("Los cortes de pelo duran de 1 a 30 segundos.");
        Barberia shop = new Barberia();//hacemos barberia
        Barbero german = new Barbero(shop);//hacemos al barbero
        GeneradorDeClientes genClien = new GeneradorDeClientes(shop);//generamos clientes 
        Thread hiloGerman = new Thread(german);//hilo del barbero
        Thread hiloGen = new Thread(genClien);//hilo para generar clientes
        hiloGen.start();
        hiloGerman.start();
    }
}
 

