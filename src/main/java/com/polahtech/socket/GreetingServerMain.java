package com.polahtech.socket;

public class GreetingServerMain {

    public static void main(String[] args) {
        GreetingServer server = new GreetingServer();
        server.start(4444);
    }
}
