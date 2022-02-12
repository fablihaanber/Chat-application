package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lab206
 */
public class Multi implements Runnable {
    ServerSocket ss;
    private Socket s;
    DataInputStream din;
    DataOutputStream dout;
    String str=" ";
    String s1;
    private Socket ara[]=new Socket[10000];
    private int i;
    Multi(Socket s,int i,Socket ara[]){
        this.ara=ara;
        this.i=i;
        this.s=s;
        System.out.println("s : "+s);
    }
    @Override
    public void run(){
        System.out.println("Client Connected.....");
        for(int j=0;ara[j]!=null;j++) {
            System.out.println(ara[j]);
        }
        try {
            din = new DataInputStream(ara[i].getInputStream());
        } catch (IOException ex) {
            //Logger.getLogger(Multi.class.getName()).log(Level.SEVERE, null, ex);
        }
        do{
            try{
                System.out.println("Waiting for Client response ...");
                str = din.readUTF();
                System.out.println("Client response is: " + str);
                Thread.sleep(10);
                String z=Thread.currentThread().getName();
                for(int j=0;j<=10000;j++) {
                   try {
                       dout = new DataOutputStream(ara[j].getOutputStream());
                       dout.writeUTF(z + str);
                       dout.flush();
                       System.out.println(ara[j] + "Done");
                   }catch(Exception ex){
                   }
                }
            }catch(Exception ex){
                //Logger.getLogger(Multi.class.getName()).log(Level.SEVERE, null, ex);
                break;
            }
        }while(!str.equals("bye"));
        try {
            //Thread.currentThread().stop();
            ara[i]=null;
        } catch (Exception ex) {
            //Logger.getLogger(Multi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
