package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Board {

    private int width;
    private int heigth;
    private static int numberOfRound;
    private static int numberOfPlayersCreated = 1;
    private int playersAlive = 1;
    private Player[][] players;

    public Board(int width, int heigth){
        this.width = width;
        this.heigth = heigth;
        this.players = new Player[width][heigth];
        this.players[0][0] = new Player(2, numberOfPlayersCreated,true);
    }

    public void spawnPlayer(){
        int whichWay = new Random().nextInt(4) + 1;
        int playerX = new Random().nextInt(width+1);
        int playerY = new Random().nextInt(heigth+1);

        while (players[playerX][playerY].isAlive()){
            playerX = new Random().nextInt(width+1);
            playerY = new Random().nextInt(heigth+1);
        }


        players[playerX][playerY] = new Player(whichWay, numberOfPlayersCreated, true);
        numberOfPlayersCreated++;
        playersAlive++;
    }

    public void nextRound(){
        if (numberOfRound % 3 == 0){
            spawnPlayer();
        }

        movePlayers();

        showBoard();

    }

    public void movePlayers(){
        ArrayList<Integer> movedPlayers = new ArrayList<Integer>();
        for (int i = 0; i < width; i++){
            for (int j = 0; j < heigth; j++){
                if(players[i][j] != null && players[i][j].isAlive()){
                    boolean canMove = true;
                    for(int k = 0; k < movedPlayers.size(); k++){
                        if(movedPlayers.get(k) == players[i][j].getIdOfPlayer()){
                            canMove = false;
                        }
                    }
                    if(canMove){
                        movedPlayers.add(players[i][j].getIdOfPlayer());
                        movePlayer(i,j);
                    }
                }
            }
        }
    }
    // 10 --- 8 - 9 -10
    public void movePlayer(int x, int y){

        //RANDOM WAY OF MOVING
        int random = new Random().nextInt(4) + 1;
        //GOING UP
        if (players[x][y].getWhichWay() == 1) {

            if (y < heigth && y > 0) {

                //ZROB RUCH GRACZEM JESLI NIKT TAM NIE STOI
                //JESLI STOI TO GO ZABIJA I WCHODZI NA JEGO MIEJSCE
                if (players[x][y - 1] != null && (players[x][y - 1].isAlive() && players[x][y - 1].getWhichWay() != 3)) {

                    //EATING OPONENT AND CHANGING POSITION
                    players[x][y - 1] = players[x][y];

                    //LESS ALIVE
                    playersAlive--;

                    //CLEAR LAST POSITION
                    players[x][y] = new Player();

                } else if (players[x][y - 1] == null || !players[x][y - 1].isAlive()) {

                    //CHANGE POSITION
                    players[x][y - 1] = players[x][y];

                    //CLEAR LAST POSITION
                    players[x][y] = new Player();

                } else if (players[x][y - 1].isAlive() && players[x][y - 1].getWhichWay() == 3) {
                    // NOTHING HAPPENS
                }

                //CHANGING WAY OF MOVING
                players[x][y - 1].setWhichWay(random);

            }
        } //GOING RIGHT
        else if(players[x][y].getWhichWay() == 2){
            if(x < width - 1 && x >= 0) {

                if (players[x + 1][y] != null && (players[x + 1][y].isAlive() && players[x + 1][y].getWhichWay() != 4)) {

                    players[x + 1][y] = players[x][y];

                    playersAlive--;

                    players[x][y] = new Player();

                } else if (players[x + 1][y] == null || !players[x + 1][y].isAlive()) {

                    players[x + 1][y] = players[x][y];

                    players[x][y] = new Player();

                } else if (players[x + 1][y].isAlive() && players[x + 1][y].getWhichWay() == 4) {

                }

                //CHANGING WAY OF MOVING

                players[x + 1][y].setWhichWay(random);
            }
        }//GOING DOWN
        else if(players[x][y].getWhichWay() == 3) {
            if (y < width - 1 && y >= 0) {

                if (players[x][y + 1] != null && (players[x][y + 1].isAlive() && players[x][y + 1].getWhichWay() != 1)) {

                    players[x][y + 1] = players[x][y];

                    playersAlive--;

                    players[x][y] = new Player();

                } else if (players[x][y + 1] == null || !players[x][y + 1].isAlive()) {

                    players[x][y + 1] = players[x][y];

                    players[x][y] = new Player();

                } else if (players[x][y + 1].isAlive() && players[x][y + 1].getWhichWay() == 1) {

                }

                //CHANGING WAY OF MOVING
                players[x][y + 1].setWhichWay(random);

            }
        }//GOING LEFT
        else if(players[x][y].getWhichWay() == 4) {
            if (x < width && x > 0) {

                if (players[x - 1][y] != null && (players[x - 1][y].isAlive() && players[x - 1][y].getWhichWay() != 2)) {

                    players[x - 1][y] = players[x][y];

                    playersAlive--;

                    players[x][y] = new Player();

                } else if (players[x - 1][y] == null || !players[x - 1][y].isAlive()) {

                    players[x - 1][y] = players[x][y];

                    players[x][y] = new Player();

                } else if (players[x - 1][y].isAlive() && players[x - 1][y].getWhichWay() == 2) {

                }

                //CHANGING WAY OF MOVING
                players[x - 1][y].setWhichWay(random);

            }
        }

    }

    public Player[][] getPlayers() {
        return players;
    }

    public void setPlayers(Player[][] players) {
        this.players = players;
    }

    public void showBoard(){
        StringBuilder boardS = new StringBuilder();

        for(int i = 0; i < heigth; i++){

            for(int j = 0; j < width; j++){
                if( players[i][j] != null && players[i][j].isAlive()){
                    if(players[i][j].getWhichWay() == 1){

                        boardS.append("^");

                    } else if(players[i][j].getWhichWay() == 2){

                        boardS.append(">");

                    }else if(players[i][j].getWhichWay() == 3){

                        boardS.append("v");

                    }else if (players[i][j].getWhichWay() == 4){

                        boardS.append("<");

                    }
                }else {

                    boardS.append(" ");

                }

                if(!(j + 1 == width)){

                    boardS.append("|");

                }

            }
            boardS.append(System.getProperty("line.separator"));
            for(int k = 0; k < width; k++){
                boardS.append("- ");
            }
            boardS.append(System.getProperty("line.separator"));


        }

        System.out.println(boardS);
    }
}
