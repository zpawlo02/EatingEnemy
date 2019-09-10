package com.company;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @org.junit.jupiter.api.Test
    void isAlive() {
        Player player = new Player();
        assertFalse(player.isAlive());
    }
}