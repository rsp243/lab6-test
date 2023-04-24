package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
    private DatagramSocket socket;
    private boolean running;
    private byte[] buf = new byte[5];

    public Server() throws SocketException {
        socket = new DatagramSocket(1112);
    }

    public void run() {
        running = true;
        try {
            while (running) {
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                System.out.println(new String(packet.getData()));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        socket.close();
    }

}
