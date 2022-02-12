package client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Output implements Runnable {
    Socket s;
    DataInputStream din;
    private String str;
    Output(Socket s){
        this.s=s;
        
    }
    @Override
    public void run(){
        while(true){
        try {
            din=new DataInputStream(s.getInputStream()); /// ???
            str=din.readUTF();
            System.out.println(str);
        } catch (IOException ex) {
            Logger.getLogger(Output.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
}