/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mserver;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author amaljith
 */
class ClientHandler implements Runnable {
    Socket socket;
    public ClientHandler(Socket s) {
        socket = s;
    }
    @Override
    public void run()
    {
       try
       {
           BufferedReader recivRead;
           OutputStream os;
           try (BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in))) {
               InputStream is=socket.getInputStream();
               recivRead = new BufferedReader(new InputStreamReader(is));
               os = socket.getOutputStream();
               PrintWriter pwrite = new PrintWriter(os,true);
               String s;
               while (true)
               {
                   s=recivRead.readLine();
                   if(s.equalsIgnoreCase("END"))
                   {
                       pwrite.println(s);
                       System.out.println("bye");
                       break;
                   }
                   System.out.println("client:"+s);
                   pwrite.println(s);
               }
               socket.close();
           }
        recivRead.close();
        os.close();
       }
       catch(Exception e)
       {
           System.out.println(e);
       }
    }
}
