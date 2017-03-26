package com.example.zenix.tictactoe.datastorage;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.example.zenix.tictactoe.Player;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.example.zenix.tictactoe.datastorage.HighScoreDbSchema.*;

public class HighScoreDAO implements IOInterface {

    private Context applicationContext;
    private SQLiteDatabase database;

    public HighScoreDAO(Context context) {
        applicationContext = context.getApplicationContext();
        this.database = new HighScoreHelper(context).getWritableDatabase();
    }

    @Override
    public void addToDatabase(Player player) {
        saveHighScore(player);
    }

    @Override
    public void addToDatabase(List<Player> players) {
        for (Player player : players) {
            saveHighScore(player);
        }
    }

    @Override
    public List<Player> readFromDatabase() {
        List<Player> scores = new ArrayList<>();
        Cursor cursor = getHighScoreCursor();
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            Player newPlayer = getPlayerFromCursor(cursor);
            scores.add(newPlayer);
        }

        cursor.close();
        return scores;
    }

    private void saveHighScore(Player player) {
        ContentValues contentValues = getContentValues(player);

        database.insert(HighScoreTable.NAME, null, contentValues);
    }

    private void updateHighScore(Player player) {
        String name = player.getPlayerName();
        ContentValues contentValues = getContentValues(player);

        database.update(
                HighScoreTable.NAME,
                contentValues,
                Columns.NAME + " = ?",
                new String[] {name}
        );
    }


    private Cursor getHighScoreCursor() {
        return database.query(
                    HighScoreTable.NAME,
                    new String[]{Columns.NAME, Columns.SCORE},
                    null,
                    null,
                    null,
                    null,
                    null
            );
    }

    @NonNull
    private Player getPlayerFromCursor(Cursor cursor) {
        return new Player(
                        cursor.getString(0),
                        cursor.getInt(1)
                );
    }

    private static ContentValues getContentValues(Player player) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(Columns.NAME, player.getPlayerName());
        contentValues.put(Columns.SCORE, player.getPlayerScore());

        return contentValues;
    }
}
