package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void spawnPlayer() {
        Board board = new Board(4, 5);

        while (!board.endOfGame()){
            board.nextRound();
        }





        /*Player[][] players = board.getPlayers();
        assertEquals(true, players[1][0].isAlive());
        assertEquals(false, players[0][0].isAlive());*/

        //ToDo JESLI WYKONASZ RUCH GRACZEM TO ZAPISUJ JEGO ID W TABLICY
        //ToDo JESLI ID SIE POWTARZA TO NIE WYKONUJ RUCHU

    }
}