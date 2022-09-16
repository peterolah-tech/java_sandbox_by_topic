package com.polahtech.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter writeOut;
    private BufferedReader readIn;

    /**
     * Start a server which maintains connection until instructed to close  .
     */
    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        writeOut = new PrintWriter(clientSocket.getOutputStream(), true);
        readIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String inputLine;
        while ((inputLine = readIn.readLine()) != null) {
            if (".".equals(inputLine)) {
                writeOut.println("good bye");
                break;
            }
            writeOut.println(inputLine);
        }
    }

    public void stop() throws IOException {
        readIn.close();
        writeOut.close();
        clientSocket.close();
        serverSocket.close();
    }
}
