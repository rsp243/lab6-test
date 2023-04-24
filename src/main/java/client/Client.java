package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    private String host;
    private int port;
    private final BufferedReader inpReader;

    public Client (String host, int port) {
        this.host = host;
        this.port = port;
        inpReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void sendMessage(String message) {
        try {
            byte[] dataToSend = message.getBytes();
            InetAddress address = InetAddress.getByName(host);
            DatagramPacket packet = new DatagramPacket(dataToSend, dataToSend.length, address, port);
            DatagramSocket socket = new DatagramSocket();
            socket.send(packet);
            socket.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getMessageToSend() {
        String message = "";
        try {
            message = inpReader.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return message.trim();
    }

}
