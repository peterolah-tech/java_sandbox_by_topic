package com.polahtech.socket;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

// @Disabled("Manual test, requires a running server")
class EchoServerTest {

    final String ip = "127.0.0.1";
    final int port = 4444;

    @Test
    void testIfReturnsGreetingFromEchoServer() throws IOException {
        Client client = new Client();
        client.startConnection(ip, port);
        String response1 = client.sendMessage("hello server");
        String response2 = client.sendMessage("How are you?");
        assertEquals("hello server", response1);
        assertEquals("How are you?", response2);
        client.stopConnection();
    }
}