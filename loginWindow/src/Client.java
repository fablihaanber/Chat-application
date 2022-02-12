import java.net.*;
import java.io.*;
import java.util.*;
public class Client {
   String userName;
   String password;
   int n; 
    
    Client(int n,String userName,String password){
        this.userName=userName;
        this.password=password;
        this.n=n;
        }
    
    
    public void execute() throws IOException {
        Socket s;
        DataInputStream din;
        DataOutputStream dout;
        
        s=new Socket("192.168.43.185",6000);
        din=new DataInputStream(s.getInputStream());
        dout=new DataOutputStream(s.getOutputStream());
        //int n;
        //n=sc.nextInt();
        dout.writeUTF(Integer.toString(n));
        dout.writeUTF(userName);
        dout.writeUTF(password);
        
       /* din=new DataInputStream(s.getInputStream()); /// ???
        dout=new DataOutputStream(s.getOutputStream());
        do{
        System.out.println("Waiting for user input ...");
        str=sc.nextLine();
        System.out.println("User input is: " + str);
        dout.writeUTF(str);
        dout.flush();
        }while(!str.equals("bye"));*/
    }
}