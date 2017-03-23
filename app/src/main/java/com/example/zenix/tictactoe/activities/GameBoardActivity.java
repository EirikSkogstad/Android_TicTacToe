package com.example.zenix.tictactoe.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.zenix.tictactoe.GameBoard;
import com.example.zenix.tictactoe.Player;
import com.example.zenix.tictactoe.R;
import com.example.zenix.tictactoe.adapters.GameBoardAdapter;

public class GameBoardActivity extends AppCompatActivity {

    public static final String CURRENT_PLAYER = "currentPlayer";

    private Button buttonRestart;
    private Button buttonHighScore;
    private Button buttonNewGame;
    private RecyclerView recyclerView_gameBoard;

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
        playerOneName = intent.getStringExtra(InputScreenActivity.PLAYER_ONE);
        playerTwoName = intent.getStringExtra(InputScreenActivity.PLAYER_TWO);
    }

    private void initComponents() {
        buttonRestart = (Button) findViewById(R.id.button_restart);
        buttonHighScore = (Button) findViewById(R.id.button_high_score);
        buttonNewGame = (Button) findViewById(R.id.button_new_game);
        recyclerView_gameBoard = (RecyclerView) findViewById(R.id.recyclerView_gameBoard);
        recyclerView_gameBoard.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView_gameBoard.setAdapter(new GameBoardAdapter(new GameBoard(this)));
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
        Intent intent = new Intent(this, HighScoreActivity.class);
        intent.putExtra(CURRENT_PLAYER, playerTwoName);
        startActivity(intent);
    }

}
