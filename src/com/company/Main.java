package com.company;

public class Main {

    public static void main(String[] args) {
        Board board = new Board(5, 10);

        while (!board.endOfGame()){
            board.nextRound();
        }


    }

    //TODO Program startuje X rozgrywek i zlicza z nich statystki MAX PLAYER ALIVED I PO ILU RUNDACH - ZALEZNIE OD WIELKOSCI PLANSZY

}
