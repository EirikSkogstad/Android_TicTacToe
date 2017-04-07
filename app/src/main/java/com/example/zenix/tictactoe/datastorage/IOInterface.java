package com.example.zenix.tictactoe.datastorage;

import com.example.zenix.tictactoe.Player;

import java.util.List;

public interface IOInterface {

    void addPlayer(Player player);

    List<Player> readAllPlayers();

    int readPlayerScore(Player player);
}
