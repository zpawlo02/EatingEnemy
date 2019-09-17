package com.company;

public class Main {

    public static void main(String[] args) {
        Board board = new Board(5, 5);
        for (int i = 0; i < 100; i++){
            board.nextRound();
        }


    }
}
