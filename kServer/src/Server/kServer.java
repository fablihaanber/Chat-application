package Server;

/**
 *
 * @author lab206
 */
import java.net.*;
import java.io.*;
import java.util.*;
public class kServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss;
        Socket s;
        Socket ara[]=new Socket[100];
        DataInputStream din;
        DataOutputStream dout;
        String str=" ";
        String s1;
        System.out.println("Server START......");
        ss=new ServerSocket(6000);
        int i=0;
        while(true){
            s=ss.accept();
            ara[i]=s;
            Multi a=new Multi(s,i,ara);
            Thread x=new Thread(a,"Client "+i+" : ");
            x.start();
            i++;
        }
    }
}