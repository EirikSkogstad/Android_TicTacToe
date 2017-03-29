package com.example.zenix.tictactoe.datastorage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HighScoreHelper extends SQLiteOpenHelper {

    public static final int VERSION = 1;
    public static final String DATABASE_NAME = "highscores.db";

    private static final String CREATE_TABLE_SQL = "CREATE TABLE " + HighScoreDbSchema.HighScoreTable.NAME + "(" +
            "_id integer primary key autoincrement," +
            HighScoreDbSchema.Columns.NAME + " text not null unique," +
            HighScoreDbSchema.Columns.SCORE + " text not null" +
            ");";

    public HighScoreHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
