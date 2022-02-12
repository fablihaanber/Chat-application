/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomno;
import java.util.*;
/**
 *
 * @author ASUS
 */
public class RandomNo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Random r=new Random();
        System.out.println(r.nextInt(12200));
        System.err.println("error message");  
    }
    
}
