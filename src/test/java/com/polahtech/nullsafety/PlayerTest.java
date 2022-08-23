package com.polahtech.nullsafety;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void getName() {
        Player player = new Player("Jack");
        String playerName = player.getName();
    }
}