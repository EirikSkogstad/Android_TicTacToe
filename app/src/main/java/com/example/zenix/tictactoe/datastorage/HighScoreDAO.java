package com.example.zenix.tictactoe.datastorage;

import android.content.ContentResolver;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.zenix.tictactoe.Player;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class HighScoreDAO implements IOInterface {

    private Context applicationContext;
    private SQLiteDatabase database;

    public HighScoreDAO(Context context) {
        applicationContext = context.getApplicationContext();
        this.database = new HighScoreHelper(context).getWritableDatabase();
    }

    @Override
    public void saveHighScores(List<Player> players) throws IOException {

    }

    @Override
    public List<Player> readHighScores() throws FileNotFoundException {
        return null;
    }
}
