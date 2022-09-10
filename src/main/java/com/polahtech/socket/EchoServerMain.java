package com.polahtech.socket;

import java.io.IOException;

public class EchoServerMain {

    public static void main(String[] args) throws IOException {
        EchoServer server = new EchoServer();
        server.start(4444);
    }
}
