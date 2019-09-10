package com.company;

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
        int whichWay = new Random().nextInt(5) + 1;
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


    }

    private void movePlayers(){
        for (int i = 0; i < width; i++){
            for (int j = 0; j < heigth; j++){
                if(players[i][j].isAlive()){

                }
            }
        }
    }
    // 10 --- 8 - 9 -10
    public void movePlayer(int x, int y){
        if (players[x][y].getWhichWay() == 1){
            if(y < heigth && y > 0){

                //ZROB RUCH GRACZEM JESLI NIKT TAM NIE STOI
                //JESLI STOI TO GO ZABIJA I WCHODZI NA JEGO MIEJSCE
                if(players[x][y-1] != null && (players[x][y-1].isAlive() && players[x][y-1].getWhichWay() != 3 )) {

                    //ZABIJA GO I ZMIENIA POZYCJE
                    players[x][y-1] = players[x][y];

                    //ZMNIEJSZA ILOSC ZYWYCH
                    playersAlive--;

                    //POPRZEDNIE POLE PUSTE
                    players[x][y] = new Player();

                }else if(!players[x][y - 1].isAlive()){

                    //ZMIENIA POZYCJE
                    players[x][y-1] = players[x][y];

                    //POPRZEDNIE POLE PUSTE
                    players[x][y] = new Player();

                } else if(players[x][y-1].isAlive() && players[x][y-1].getWhichWay() == 3 ){
                    //NIC SIE NIE DZIEJE
                }
            }
        } else if(players[x][y].getWhichWay() == 2){
            if(x < width - 1 && x >= 0) {

                //ZROB RUCH GRACZEM JESLI NIKT TAM NIE STOI
                //JESLI STOI TO GO ZABIJA I WCHODZI NA JEGO MIEJSCE
                if (players[x + 1][y] != null && (players[x + 1][y].isAlive() && players[x + 1][y].getWhichWay() != 4)) {
                    //ZABIJA GO
                    players[x + 1][y] = players[x][y];

                    //ZMNIEJSZA ILOSC ZYWYCH
                    playersAlive--;

                    //POPRZEDNIE POLE PUSTE
                    players[x][y] = new Player();

                } else if (players[x + 1][y] == null || !players[x + 1][y].isAlive()) {
                    //ZMIENIA POZYCJE
                    players[x + 1][y] = players[x][y];

                    //POPRZEDNIE POLE PUSTE
                    players[x][y] = new Player();

                } else if (players[x + 1][y].isAlive() && players[x + 1][y].getWhichWay() == 4) {
                    //NIC SIE NIE DZIEJE
                }
            }
        }else if(players[x][y].getWhichWay() == 3) {
            if (x < width && x >= 0) {

                //ZROB RUCH GRACZEM JESLI NIKT TAM NIE STOI
                //JESLI STOI TO GO ZABIJA I WCHODZI NA JEGO MIEJSCE
                if (players[x][y + 1] != null && (players[x][y + 1].isAlive() && players[x][y + 1].getWhichWay() != 1)) {
                    //ZABIJA GO
                    players[x][y + 1] = players[x][y];

                    //ZMNIEJSZA ILOSC ZYWYCH
                    playersAlive--;

                    //POPRZEDNIE POLE PUSTE
                    players[x][y] = new Player();

                } else if (players[x][y + 1] != null || !players[x][y + 1].isAlive()) {

                    //ZMIENIA POZYCJE
                    players[x][y + 1] = players[x][y];

                    //POPRZEDNIE POLE PUSTE
                    players[x][y] = new Player();

                } else if (players[x][y + 1].isAlive() && players[x][y + 1].getWhichWay() == 1) {
                    //NIC SIE NIE DZIEJE
                }
            }
        }else if(players[x][y].getWhichWay() == 4) {
            if (x <= width && x > 0) {

                //ZROB RUCH GRACZEM JESLI NIKT TAM NIE STOI
                //JESLI STOI TO GO ZABIJA I WCHODZI NA JEGO MIEJSCE
                if (players[x - 1][y] != null && (players[x - 1][y].isAlive() && players[x - 1][y].getWhichWay() != 2)) {
                    //ZABIJA GO
                    players[x - 1][y] = players[x][y];

                    //ZMNIEJSZA ILOSC ZYWYCH
                    playersAlive--;

                    //POPRZEDNIE POLE PUSTE
                    players[x][y] = new Player();

                } else if (players[x - 1][y] == null || !players[x - 1][y].isAlive()) {

                    //ZMIENIA POZYCJE
                    players[x - 1][y] = players[x][y];

                    //POPRZEDNIE POLE PUSTE
                    players[x][y] = new Player();

                } else if (players[x - 1][y].isAlive() && players[x - 1][y].getWhichWay() == 2) {
                    //NIC SIE NIE DZIEJE
                }
            }
        }
    }

    public Player[][] getPlayers() {
        return players;
    }
}
