package com.example.zenix.tictactoe.datastorage;

import com.example.zenix.tictactoe.Player;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Zenix on 17.03.2017.
 */

public interface IOInterface {

    void saveHighScores(List<Player> players) throws IOException;

    List<Player> readHighScores() throws FileNotFoundException;
}
