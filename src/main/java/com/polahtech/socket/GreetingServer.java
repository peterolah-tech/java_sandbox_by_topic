package com.polahtech.socket;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class GreetingServer {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter writeOut;
    private BufferedReader readIn;

    /**
     * Start a server which closes connection after a single message.
     */
    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();
            writeOut = new PrintWriter(clientSocket.getOutputStream(), true);
            readIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String greeting = readIn.readLine();
            if ("hello server".equals(greeting)) {
                writeOut.println("hello client");
            } else {
                writeOut.println("unrecognized greeting");
            }
        } catch (IOException ex) {
            throw new IllegalStateException("The server could not start", ex);
        }
    }

    public void stop() throws IOException {
        readIn.close();
        writeOut.close();
        clientSocket.close();
        serverSocket.close();
    }
}
