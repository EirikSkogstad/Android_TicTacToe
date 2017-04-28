package com.example.zenix.tictactoe.datastorage;

import com.example.zenix.tictactoe.Player;

import java.util.List;

/**
 * A simple interface whose intention is to make it easier to switch between
 * different storage methods.
 */
public interface IOInterface {

    void addPlayer(Player player);

    List<Player> readAllPlayers();

    int readPlayerScore(Player player);
}
