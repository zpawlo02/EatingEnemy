package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Board {

    private int width;
    private int heigth;
    private static int numberOfRounds = 0;
    private static int numberOfPlayersCreated = 1;
    private int playersAlive = 1;
    private Player[][] players;
    private int maxPlayersAlived = 1;

    public Board(int width, int heigth){
        this.width = width;
        this.heigth = heigth;
        this.players = new Player[heigth][width];
        this.players[0][0] = new Player(2, numberOfPlayersCreated,true);
    }

    public void spawnPlayer(){
        int whichWay = new Random().nextInt(4) + 1;
        int playerX = new Random().nextInt(heigth);
        int playerY = new Random().nextInt(width);


        while (players[playerX][playerY] != null ){
            playerX = new Random().nextInt(heigth);
            playerY = new Random().nextInt(width);
        }


        players[playerX][playerY] = new Player(whichWay, numberOfPlayersCreated, true);
        numberOfPlayersCreated++;
        playersAlive++;
    }

    public void nextRound(){
        if(playersAlive > maxPlayersAlived){
            maxPlayersAlived = playersAlive;
        }
        numberOfRounds++;
        if (numberOfRounds % 3 == 0 && playersAlive < width*heigth){

            spawnPlayer();
        }
        System.out.println("Round: " + numberOfRounds);

        System.out.println(" ");
        System.out.println("-");

        System.out.println("Alive: " + playersAlive);

        System.out.println("-");

        showBoard();

        movePlayers();

    }

    public void movePlayers(){
        ArrayList<Integer> movedPlayers = new ArrayList<Integer>();
        for (int i = 0; i < heigth; i++){
            for (int j = 0; j < width; j++){
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

            if (x < heigth && x > 0) {


                //ZROB RUCH GRACZEM JESLI NIKT TAM NIE STOI
                //JESLI STOI TO GO ZABIJA I WCHODZI NA JEGO MIEJSCE
                if (players[x - 1][y] != null && (players[x - 1][y].isAlive() && players[x - 1][y].getWhichWay() != 3)) {

                    //EATING OPONENT AND CHANGING POSITION
                    players[x - 1][y] = players[x][y];

                    //LESS ALIVE
                    playersAlive--;

                    //CLEAR LAST POSITION
                    players[x][y] = null;

                } else if (players[x - 1][y ] == null || !players[x - 1][y].isAlive()) {

                    //CHANGE POSITION
                    players[x - 1][y] = players[x][y];

                    //CLEAR LAST POSITION
                    players[x][y] = null;

                } else if (players[x - 1][y].isAlive() && players[x - 1][y].getWhichWay() == 3) {

                }

                players[x - 1][y].setWhichWay(random);

            } else {
                players[x][y].setWhichWay(random);
            }
        } //GOING RIGHT
        else if(players[x][y].getWhichWay() == 2){
            if(y < width - 1 && y >= 0) {

                if (players[x][y + 1] != null && (players[x][y + 1].isAlive() && players[x][y + 1].getWhichWay() != 4)) {

                    players[x][y + 1] = players[x][y];

                    playersAlive--;

                    players[x][y] = null;

                } else if (players[x][y + 1] == null || !players[x][y].isAlive()) {

                    players[x][y + 1] = players[x][y];

                    players[x][y] = null;

                } else if (players[x][y + 1].isAlive() && players[x][y + 1].getWhichWay() == 4) {

                }

                players[x][y + 1].setWhichWay(random);

            } else {
                players[x][y].setWhichWay(random);
            }
        }//GOING DOWN
        else if(players[x][y].getWhichWay() == 3) {
            if (x < heigth - 1 && x >= 0) {

                if (players[x + 1][y] != null && (players[x + 1][y].isAlive() && players[x + 1][y].getWhichWay() != 1)) {

                    players[x + 1][y] = players[x][y];

                    playersAlive--;

                    players[x][y] = null;

                } else if (players[x + 1][y] == null || !players[x + 1][y].isAlive()) {

                    players[x + 1][y] = players[x][y];

                    players[x][y] = null;


                } else if (players[x + 1][y].isAlive() && players[x + 1][y].getWhichWay() == 1) {

                }

                players[x + 1][y].setWhichWay(random);


            } else {
                players[x][y].setWhichWay(random);
            }

        }//GOING LEFT
        else if(players[x][y].getWhichWay() == 4) {
            if (y < width && y > 0) {

                if (players[x][y - 1] != null && (players[x][y - 1].isAlive() && players[x][y - 1].getWhichWay() != 2)) {

                    players[x][y - 1] = players[x][y];

                    playersAlive--;

                    players[x][y] = null;

                } else if (players[x][y - 1] == null || !players[x][y - 1].isAlive()) {

                    players[x][y - 1] = players[x][y];

                    players[x][y] = null;

                } else if (players[x][y - 1].isAlive() && players[x][y - 1].getWhichWay() == 2) {

                }

                    players[x][y - 1].setWhichWay(random);

            }else {
                players[x][y].setWhichWay(random);
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

    public boolean endOfGame(){
        if(playersAlive == 1 && numberOfRounds > 3){
            int idOfWinner = 0;
            for (int i = 0; i < heigth; i++){
                for(int j = 0; j < width; j++){
                    if ( players[i][j] != null){
                        idOfWinner = players[i][j].getIdOfPlayer();
                    }
                }
            }
            System.out.println("Wins player number: " + idOfWinner + " after " + numberOfRounds + " rounds!");
            System.out.println("Max players alived: " + maxPlayersAlived);
            return true;
        }else {
            return false;
        }
    }
}