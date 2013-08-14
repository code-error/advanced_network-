
package mclient;
import java.io.*;
import java.net.*;
/**
 *
 * @author amaljith
 */
public class Mclient 
{

    public static void main(String[] args) throws IOException
    {
        try
        {
            Socket sock = new Socket("127.0.0.1", 3002);
            BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
            InputStream is=sock.getInputStream();
            BufferedReader recivRead=new BufferedReader(new InputStreamReader(is));
            OutputStream os=sock.getOutputStream();
            PrintWriter pwrite = new PrintWriter(os,true);
            String s;
            while(true)
            {
                s=keyRead.readLine();
                pwrite.println(s);
                s=recivRead.readLine();
                if(s.equalsIgnoreCase("END"))
                {
                    System.out.println("connection lost");
                    break;
                }
            }
            
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
}
