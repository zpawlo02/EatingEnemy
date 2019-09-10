package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void spawnPlayer() {
        Board board = new Board(10, 10);

        board.movePlayer(0,0);
        Player[][] players = board.getPlayers();
        assertEquals(true, players[1][0].isAlive());
        assertEquals(false, players[0][0].isAlive());


    }
}