package com.example.zenix.tictactoe.datastorage;

import com.example.zenix.tictactoe.Player;

import java.util.List;

/**
 * Simple interface for saving and reading highscores.
 */
public interface IOInterface {

    void addPLayer(Player player);

    List<Player> readAllPlayers();

    int readPlayerScore(Player player);
}
