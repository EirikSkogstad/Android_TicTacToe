package com.example.zenix.tictactoe.datastorage;

public class HighScoreDbSchema {
    public static class HighScoreTable {
        public static final String NAME = "highscores";
    }

    public static class Columns {
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String SCORE = "score";
    }

}
