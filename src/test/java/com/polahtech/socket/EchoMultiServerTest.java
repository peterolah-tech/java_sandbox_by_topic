package com.polahtech.socket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.SocketException;

import static org.junit.jupiter.api.Assertions.assertEquals;

// @Disabled("Manual test, requires a running server")
class EchoMultiServerTest {

    final String ip = "127.0.0.1";
    final int port = 4444;

    @Test
    void testIfRespondsForMultipleClients() throws IOException {
        Client client1 = new Client();
        client1.startConnection(ip, port);
        String client1Response1 = client1.sendMessage("Hi");
        String client1Response2 = client1.sendMessage("Hallo");
        assertEquals("Hi", client1Response1);
        assertEquals("Hallo", client1Response2);

        Client client2 = new Client();
        client2.startConnection(ip, port);
        String client2Response1 = client2.sendMessage("Also here");
        String client2Response2 = client2.sendMessage("To send messages");
        assertEquals("Also here", client2Response1);
        assertEquals("To send messages", client2Response2);

        client1.stopConnection();
        client2.stopConnection();
    }

    @Test
    void testIfServerCloses() throws IOException {
        Client client = new Client();
        client.startConnection(ip, port);
        String response1 = client.sendMessage(".");
        assertEquals("Bye!", response1);
        Assertions.assertThrows(SocketException.class, () -> client.sendMessage("How are you?"));
    }
}