package elbarberodormilon;

class Barbero implements Runnable{
    Barberia bar;
 
    public Barbero(Barberia shop){
        this.bar = shop;
    }
    public void run(){
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){}
        System.out.println("German esta empezando..");
        while(true){
            bar.corteDePelo();
        }
    }
}
