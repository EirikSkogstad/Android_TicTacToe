package com.example.zenix.tictactoe.datastorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.example.zenix.tictactoe.Player;

import java.util.ArrayList;
import java.util.List;

import static com.example.zenix.tictactoe.datastorage.HighScoreDbSchema.Columns;
import static com.example.zenix.tictactoe.datastorage.HighScoreDbSchema.HighScoreTable;

public class HighScoreDAO implements IOInterface {

    private Context applicationContext;
    private SQLiteDatabase database;

    public HighScoreDAO(Context context) {
        this.applicationContext = context.getApplicationContext();
        this.database = new HighScoreHelper(applicationContext).getWritableDatabase();
    }

    private static ContentValues getContentValues(Player player) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(Columns.NAME, player.getPlayerName());
        contentValues.put(Columns.SCORE, player.getPlayerScore());

        return contentValues;
    }

    @Override
    public void addPLayer(Player player) {
        if (doesPlayerExistInDatabase(player)) {
            updateHighScore(player);
        } else {
            saveHighScore(player);
        }
    }

    @Override
    public List<Player> readAllPlayers() {
        List<Player> scores = new ArrayList<>();
        Cursor cursor = getHighScoreCursor();
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            Player newPlayer = getPlayerFromCursor(cursor);
            scores.add(newPlayer);
            cursor.moveToNext();
        }

        cursor.close();
        return scores;
    }

    @Override
    public int readPlayerScore(Player player) {
        int playerScore = 0;
        String query = "SELECT score" +
                " FROM " + HighScoreTable.NAME +
                " WHERE " + Columns.NAME + " = ?" +
                " LIMIT 1";
        Cursor cursor = database.rawQuery(query, new String[]{player.getPlayerName()});
        cursor.moveToFirst();

        if (!cursor.isAfterLast()) {
            playerScore = cursor.getInt(0);
        }
        cursor.close();

        return playerScore;
    }

    private boolean doesPlayerExistInDatabase(Player player) {
        int columnCount = 0;
        String query = "SELECT count(name)" +
                " FROM " + HighScoreTable.NAME +
                " WHERE " + Columns.NAME + " = ?" +
                " LIMIT 1";

        Cursor cursor = database.rawQuery(query, new String[]{player.getPlayerName()});
        cursor.moveToFirst();
        if (!cursor.isAfterLast()) {
            columnCount = cursor.getInt(0);
        }
        cursor.close();

        return columnCount > 0;
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
                new String[]{name}
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
}
