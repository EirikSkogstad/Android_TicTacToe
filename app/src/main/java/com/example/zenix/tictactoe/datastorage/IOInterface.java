package com.example.zenix.tictactoe.datastorage;

import com.example.zenix.tictactoe.Player;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Simple interface for saving and reading highscores.
 */
public interface IOInterface {

    void addToDatabase(List<Player> players);

    void addToDatabase(Player player);

    List<Player> readFromDatabase();
}
