package com.example.zenix.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class GameBoard extends AppCompatActivity {

    private Button buttonRestart;
    private Button buttonHighScore;
    private Button buttonNewGame;

    private String playerOneName;
    private String playerTwoName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_board);

        handleIntent();
        initComponents();
        initListeners();
    }

    private void handleIntent() {

    }

    private void initComponents() {
        buttonRestart = (Button) findViewById(R.id.button_restart);
        buttonHighScore = (Button) findViewById(R.id.button_high_score);
        buttonNewGame = (Button) findViewById(R.id.button_new_game);
    }

    private void initListeners() {

    }
}
