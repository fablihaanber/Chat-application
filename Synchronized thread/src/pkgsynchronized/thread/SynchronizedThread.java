^/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgsynchronized.thread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class SynchronizedThread {

    /**
     * @param args the command line arguments
     */
     private static int count=0;
     public static synchronized void cnt(){
            count++;
     }
    public static void main(String[] args) {
        // TODO code application logic here
       
        Thread ti=new Thread(new Runnable(){
            @Override
            public void run() {
               
                for(int i=0;i<10000;i++)cnt();
            }
        
        
        });
        Thread te=new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i=0;i<10000;i++)cnt();
            }
        
        
        });
        
        ti.start();
        te.start();
        ti.setPriority(1);
        te.setPriority(5);
         try {
             ti.join();
             te.join();
         } catch (InterruptedException ex) {
             Logger.getLogger(SynchronizedThread.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        System.out.println(count);
    }
    
}
