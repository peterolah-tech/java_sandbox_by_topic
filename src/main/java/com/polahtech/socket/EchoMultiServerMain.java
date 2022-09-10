package com.polahtech.socket;

import java.io.IOException;

public class EchoMultiServerMain {

    public static void main(String[] args) throws IOException {
        EchoMultiServer echoMultiServer = new EchoMultiServer();
        echoMultiServer.start(4444);
    }
}
