package util;

import ui.GameCanvas;

public class GameMaster {

    // Game options and id
    public final static int ROCK = 1;
    public final static int PAPER = 2;
    public final static int SCISSORS = 3;
    public final static int LIZARD = 4;
    public final static int SPOCK = 5;

    private int wins = 0;
    private int loses = 0;
    private int draws = 0;
    private int gameResult = 0;


    public static void playerWins(int computerChoice, int playerChoice, GameMaster master) {
        int gameResult = 0;
        if(playerChoice == ROCK) {
            if(computerChoice == PAPER) {
                master.loses++;
                gameResult = -1;
            } else if(computerChoice == SCISSORS) {
                master.wins++;
                gameResult = 1;
            } else if(computerChoice == LIZARD) {
                master.wins++;
                gameResult = 1;
            } else if(computerChoice == SPOCK) {
                master.loses++;
                gameResult = -1;
            } else { master.draws++; }
        } else if(playerChoice == PAPER) {
            if(computerChoice == ROCK) {
                master.wins++;
                gameResult = 1;
            } else if(computerChoice == SCISSORS) {
                master.loses++;
                gameResult = -1;
            } else if(computerChoice == LIZARD) {
                master.loses++;
                gameResult = -1;
            } else if(computerChoice == SPOCK) {
                master.wins++;
                gameResult = 1;
            } else { master.draws++; }
        } else if(playerChoice == SCISSORS) {
            if(computerChoice == ROCK) {
                master.loses++;
                gameResult = -1;
            } else if(computerChoice == PAPER) {
                master.wins++;
                gameResult = 1;
            }
            else if(computerChoice == LIZARD) {
                master.wins++;
                gameResult = 1;
            } else if(computerChoice == SPOCK) {
                master.loses++;
                gameResult = -1;
            } else { master.draws++; }
        } else if(playerChoice == LIZARD) {
            if(computerChoice == ROCK) {
                master.loses++;
                gameResult = -1;
            } else if(computerChoice == PAPER) {
                master.wins++;
                gameResult = 1;
            } else if(computerChoice == SCISSORS) {
                master.loses++;
                gameResult = -1;
            } else if(computerChoice == SPOCK) {
                master.wins++;
                gameResult = 1;
            } else { master.draws++; }
        } else {
            if(computerChoice == ROCK) {
                master.wins++;
                gameResult = 1;
            } else if(computerChoice == PAPER) {
                master.loses++;
                gameResult = -1;
            } else if(computerChoice == SCISSORS) {
                master.wins++;
                gameResult = 1;
            } else if(computerChoice == LIZARD) {
                master.loses++;
                gameResult = -1;
            } else { master.draws++; }
        }
        master.gameResult = gameResult;
    }

    public int getGames() {
        return wins + loses + draws;
    }

    public int getGameResult() { return gameResult; }

    @Override
    public String toString() {
        return "Juegos: " + getGames() + " | ganados: " + wins + " | perdidos: " + loses + " | empatados: " + draws;
    }
}
