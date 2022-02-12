/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filedemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class FileDemo {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        File file;
        file = new File("text.txt");
        Scanner sc=new Scanner(file);
        while(sc.hasNextLine()){
	
	int cnt=0; 
        try{  
         	
        }catch(Exception m){System.out.println("Exception occured: "+m);}  
	      
	}
	sc.close();
	}
			
     }  
    
    

