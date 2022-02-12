/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canrundemo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
class RunnableDemo implements Runnable{
    private Thread thread;
    
    
    

    @Override
    public void run() {
        System.out.println("Running "+Thread.currentThread().getName());
        for(int i=4;i>=0;i--){
            System.out.println("Executing "+Thread.currentThread().getName()+" "+i);
            //  Thread.sleep(1);
        }
        System.out.println("Done "+Thread.currentThread().getName());
    }
    /*public void start(){
        System.out.println("Starting "+Thread.currentThread().getName());
        if(thread==null){
            thread=new Thread(this,Thread.currentThread().getName());
            thread.start();
        }
    }*/
    
}
public class CanRunDemo {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        Thread r=new Thread(new RunnableDemo(),"huhu");
        Thread r2=new Thread(new RunnableDemo(),"huhu2");
        //r.setName("Thread 12345678");
        
        
        Thread r3=new Thread(new RunnableDemo(),"dd");
      //  r.setPriority(10);
       // r2.setPriority(1);
     
        
        
        r3.start();
        
         r.start();
        r2.start();
        try {
             r.join();
             
         } catch (InterruptedException ex) {
             System.out.print("d");
         }
        
    }
    
}
