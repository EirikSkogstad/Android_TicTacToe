package com.example.zenix.tictactoe;

/**
 * Data class for holding playerName and playerScore
 */
public class Player {
    private String playerName;
    private int playerScore;
    private GameSymbol gameSymbol;

    public Player(String playerName, int playerScore, GameSymbol gameSymbol) {
        this.playerName = playerName;
        this.playerScore = playerScore;
        this.gameSymbol = gameSymbol;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public String getPlayerScoreAsString() {
        return "" + playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public GameSymbol getGameSymbol() {
        return gameSymbol;
    }

    public void setGameSymbol(GameSymbol gameSymbol) {
        this.gameSymbol = gameSymbol;
    }
}
