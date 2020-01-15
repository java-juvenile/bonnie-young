package com.maxwit.course;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {
    public static void main(String[] args) {
        String serverName = args[0];
        Integer port = Integer.parseInt(args[1]);

        try {
            Socket client = new Socket(serverName, port);

            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            out.writeUTF("Hello from " + client.getLocalSocketAddress());

            DataInputStream in = new DataInputStream(client.getInputStream());
            System.out.println("server responsed: " + in.readUTF());

            client.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
