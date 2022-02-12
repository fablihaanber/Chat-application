/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multicity;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class Multicity extends Thread{

    /**
     * @param args the command line arguments
     */
    public void run(){
        for(int i=1;i<=5;i++){
        try{Thread.sleep(500);} catch (InterruptedException ex) {
                System.out.println(ex);
            }
            System.out.println(i);
        }
        //System.out.println("thread");
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Multicity t=new Multicity();
        Multicity t2=new Multicity();
        Multicity t3=new Multicity();
        //Thread m=new Thread(t);
        t.start();
        try{
            t.join(1500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Multicity.class.getName()).log(Level.SEVERE, null, ex);
        }
        t2.start();
        t3.start();
    }
    
}
