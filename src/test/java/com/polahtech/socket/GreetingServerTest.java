package com.polahtech.socket;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

// @Disabled("Manual test, requires a running server")
class GreetingServerTest {

    final String ip = "127.0.0.1";
    final int port = 4444;

    @Test
    void testIfReturnsGreeting() throws IOException {
        Client client = new Client();
        client.startConnection(ip, port);
        String response = client.sendMessage("hello server");
        assertEquals("hello client", response);
        client.stopConnection();
    }
}