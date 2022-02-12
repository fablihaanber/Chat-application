/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class MyClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String p="";String str="";
        Socket s=new Socket("localhost",6666);
        DataInputStream din=new DataInputStream(s.getInputStream());
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        while(!p.equals("bye")){
        
        
        Scanner ds=new Scanner(System.in); 
         p=ds.nextLine();
        dout.writeUTF(p);
        dout.flush();
        str=(String)din.readUTF();
        System.out.println("msg Server "+str);
        }
        dout.close();
        s.close();
    }
    
}
