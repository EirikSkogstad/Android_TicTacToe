package com.example.zenix.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GameBoard extends AppCompatActivity {

    private String playerOneName;
    private String playerTwoName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_board);

        handleActivity();
        initComponents();
        initListeners();
    }

    private void handleActivity() {

    }

    private void initComponents() {

    }

    private void initListeners() {

    }
}
