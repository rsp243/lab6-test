package app;

import client.Client;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Client client = new Client("localhost", 1112);
        boolean running = true;


        while (running) {
            String data = client.getMessageToSend();
            if (data.equals("exit")) {
                running = false;
                continue;
            }
            client.sendMessage(data.trim());
        }

    }
}
