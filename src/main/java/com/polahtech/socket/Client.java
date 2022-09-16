package com.polahtech.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private Socket clientSocket;
    private PrintWriter writeOut;
    private BufferedReader readIn;

    // TODO: do this in constructor(?)
    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        writeOut = new PrintWriter(clientSocket.getOutputStream(), true);
        readIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public String sendMessage(String message) throws IOException {
        writeOut.println(message);
        return readIn.readLine();
    }

    public void stopConnection() throws IOException {
        readIn.close();
        writeOut.close();
        clientSocket.close();
    }
}
