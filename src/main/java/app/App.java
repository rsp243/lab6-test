package app;

import java.io.IOException;
import java.net.DatagramSocket;

import server.Server;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            Server server = new Server(); 
            server.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
