package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void spawnPlayer() {
        Board board = new Board(100, 100);

        for (int i = 0; i < 10000; i++){
            board.nextRound();
        }





        /*Player[][] players = board.getPlayers();
        assertEquals(true, players[1][0].isAlive());
        assertEquals(false, players[0][0].isAlive());*/

        //ToDo JESLI WYKONASZ RUCH GRACZEM TO ZAPISUJ JEGO ID W TABLICY
        //ToDo JESLI ID SIE POWTARZA TO NIE WYKONUJ RUCHU

    }
}