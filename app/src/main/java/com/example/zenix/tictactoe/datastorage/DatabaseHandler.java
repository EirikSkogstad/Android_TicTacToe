package com.example.zenix.tictactoe.datastorage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class DatabaseHandler extends SQLiteOpenHelper implements IOInterface {

    private static final String DATABASE_NAME = "HighScores";
    private SQLiteDatabase database;

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void saveHighScores(Map<String, Integer> highScores) throws IOException {
        SQLiteDatabase readableDatabase = getReadableDatabase();

        readableDatabase.beginTransaction();
    }

    @Override
    public Map<String, Integer> readHighScores() throws FileNotFoundException {
        return null;
    }
}
