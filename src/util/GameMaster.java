package util;

public class GameMaster {

    // Game options and id
    public final static int ROCK = 1;
    public final static int PAPER = 2;
    public final static int SCISSORS = 3;
    public final static int LIZARD = 4;
    public final static int SPOK = 5;

    private int wins = 0;
    private int loses = 0;
    private int draws = 0;


    public static void playerWins(int computerOption, int playerOption, GameMaster master) {
        if(playerOption == ROCK) {
            if(computerOption == PAPER) { master.loses++; }
            else if(computerOption == SCISSORS) { master.wins++; }
            else if(computerOption == LIZARD) { master.wins++; }
            else if(computerOption == SPOK) { master.loses++; }
            else { master.draws++; }
        } else if(playerOption == PAPER) {
            if(computerOption == ROCK) { master.wins++; }
            else if(computerOption == SCISSORS) { master.loses++; }
            else if(computerOption == LIZARD) { master.loses++; }
            else if(computerOption == SPOK) { master.wins++; }
            else { master.draws++; }
        } else if(playerOption == SCISSORS) {
            if(computerOption == ROCK) { master.loses++; }
            else if(computerOption == PAPER) { master.wins++; }
            else if(computerOption == LIZARD) { master.wins++; }
            else if(computerOption == SPOK) { master.loses++; }
            else { master.draws++; }
        } else if(playerOption == LIZARD) {
            if(computerOption == ROCK) { master.loses++; }
            else if(computerOption == PAPER) { master.wins++; }
            else if(computerOption == SCISSORS) { master.loses++; }
            else if(computerOption == SPOK) { master.wins++; }
            else { master.draws++; }
        } else {
            if(computerOption == ROCK) { master.loses++; }
            else if(computerOption == PAPER) { master.loses++; }
            else if(computerOption == SCISSORS) { master.wins++; }
            else if(computerOption == LIZARD) { master.wins++; }
            else { master.draws++; }
        }
    }

    public int getGames() {
        return wins + loses + draws;
    }

    @Override
    public String toString() {
        return "Juegos: " + getGames() + " | ganados: " + wins + " | perdidos: " + loses + " | empatados: " + draws;
    }
}
