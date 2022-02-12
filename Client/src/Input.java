/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rezaul
 */
public class Input implements Runnable {
    private String str;
    Scanner sc=new Scanner(System.in);
    DataOutputStream dout;
    private Socket s;
    Input(Socket s) throws IOException{
        this.s=s;
        
    }
    @Override
    public void run(){
        while(true){
        try {
            dout=new DataOutputStream(s.getOutputStream());
            str=sc.nextLine();
            System.out.println("User input is: " + str);        
            dout.writeUTF(str);
        } catch (Exception ex) {
            Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Nothing");
        }
    }
    }
}
