package com.example.zenix.tictactoe.datastorage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Zenix on 17.03.2017.
 */

public interface IOInterface {

    void saveHighScores(Map<String, Integer> highScores) throws IOException;

    Map<String, Integer> readHighScores() throws FileNotFoundException;
}
