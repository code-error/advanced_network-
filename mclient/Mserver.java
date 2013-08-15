
package mserver;
import java.net.*;
/**
 *
 * @author amaljith
 */
public class Mserver {

    public static void main(String[] args) {
        try
        {
            ServerSocket socket=new ServerSocket(3002);
            Socket s=socket.accept();
            (new Thread(new ClientHandler(s))).start();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
