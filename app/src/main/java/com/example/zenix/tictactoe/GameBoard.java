package com.example.zenix.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameBoard extends AppCompatActivity {

    public static final String CURRENT_PLAYER = "currentPlayer";

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
        Intent intent = getIntent();
        playerOneName = intent.getStringExtra(InputScreen.PLAYER_ONE);
        playerTwoName = intent.getStringExtra(InputScreen.PLAYER_TWO);
    }

    private void initComponents() {
        buttonRestart = (Button) findViewById(R.id.button_restart);
        buttonHighScore = (Button) findViewById(R.id.button_high_score);
        buttonNewGame = (Button) findViewById(R.id.button_new_game);
    }

    private void initListeners() {
        buttonHighScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startHighScoreActivity();
            }
        });
        buttonNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void startHighScoreActivity() {
        Intent intent = new Intent(this, HighScore.class);
        intent.putExtra(CURRENT_PLAYER, playerTwoName);
        startActivity(intent);
    }
}
