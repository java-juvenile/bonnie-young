package com.maxwit.course;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) {
        Integer port = Integer.parseInt(args[0]);
        ServerSocket serverSocket;

        try {
            serverSocket = new ServerSocket(port);
                while (true) {
                    try {
                        Socket server = serverSocket.accept();

//                        DataInputStream in = new DataInputStream(server.getInputStream());
//                        System.out.println(in.readUTF());

                        String body = "lalala";
                        DataOutputStream out = new DataOutputStream(server.getOutputStream());
                        String response = "HTTP/1.1 200 OK\n" + body.length() + "\n\n" + body;
                        out.writeBytes(response);

                        server.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        break;
                    }
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
