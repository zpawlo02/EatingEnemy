package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void spawnPlayer() {
        Board board = new Board(5, 5);
        board.showBoard();
        board.movePlayers();;
        board.showBoard();
        board.movePlayers();;
        board.showBoard();
        /*Player[][] players = board.getPlayers();
        assertEquals(true, players[1][0].isAlive());
        assertEquals(false, players[0][0].isAlive());*/

        //ToDo JESLI WYKONASZ RUCH GRACZEM TO ZAPISUJ JEGO ID W TABLICY
        //ToDo JESLI ID SIE POWTARZA TO NIE WYKONUJ RUCHU

    }
}