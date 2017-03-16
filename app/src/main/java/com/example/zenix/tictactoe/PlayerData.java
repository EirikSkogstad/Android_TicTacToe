package com.example.zenix.tictactoe;

/**
 * Data class for holding playerName and playerScore
 */
public class PlayerData {
    private String playerName;
    private int playerScore;

    public PlayerData(String playerName, int playerScore) {
        this.playerName = playerName;
        this.playerScore = playerScore;
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
}
