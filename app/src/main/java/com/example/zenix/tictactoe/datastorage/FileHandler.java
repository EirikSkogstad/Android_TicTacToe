//package com.example.zenix.tictactoe.datastorage;
//
//import android.content.Context;
//
//import java.io.File;
//import java.io.FileFilter;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
///**
// * Helper class for saving and reading data from files.
// */
//public class FileHandler implements IOInterface {
//    //FIXME needs to take into account new scores from existing user. Update the existing data.
//
//    private static final String HIGHSCORE_FILE_NAME = "/highscore.txt";
//    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
//    private static FileFilter filter;
//
//    private File highScoreFile;
//
//    public FileHandler(Context context) {
//        File filesDir = context.getFilesDir();
//        highScoreFile = new File(filesDir.toString() + HIGHSCORE_FILE_NAME);
//    }
//
//    /**
//     * Tries to read the HighScoreActivity file if it can be found.
//     * @return Map with playerName and playerScore.
//     * @throws FileNotFoundException if file cannot be found.
//     */
//    public Map<String, Integer> readHighScores() throws FileNotFoundException {
//        Map<String, Integer> highScores = new HashMap<>();
//        if (highScoreFile.exists()) {
//            Scanner scanner = new Scanner(highScoreFile);
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                String[] values = line.split(",");
//
//                String playerName = values[0];
//                int playerScore = Integer.parseInt(values[1]);
//
//                highScores.put(playerName, playerScore);
//            }
//        }
//        else {
//            throw new FileNotFoundException("Could not find " + highScoreFile.toString());
//        }
//        return highScores;
//    }
//
//    /**
//     * Tries to highscores, using a spesific format: *PlayerName* + "," + *PlayerScore + *UniversalLineSeperator*
//     * @param highScores Map containting playername as key, and value as value.
//     * @throws IOException If problems occur during writing of files.
//     */
//    public void saveHighScores(Map<String, Integer> highScores) throws IOException {
//        if (!highScoreFile.exists()) {
//            highScoreFile.createNewFile();
//        }
//        StringBuilder stringBuilder = new StringBuilder();
//        FileOutputStream fileOutputStream = new FileOutputStream(highScoreFile);
//
//        for (Map.Entry<String, Integer> entry : highScores.entrySet()) {
//            stringBuilder
//                    .append(entry.getKey())
//                    .append(",")
//                    .append(entry.getValue())
//                    .append(LINE_SEPARATOR);
//            fileOutputStream.write(stringBuilder.toString().getBytes());
//        }
//
//    }
//}
