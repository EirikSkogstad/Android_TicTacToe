package com.example.zenix.tictactoe.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.zenix.tictactoe.gamelogic.GameBoard;
import com.example.zenix.tictactoe.gamelogic.GameSymbol;
import com.example.zenix.tictactoe.Player;
import com.example.zenix.tictactoe.R;
import com.example.zenix.tictactoe.adapters.GameBoardAdapter;
import com.example.zenix.tictactoe.datastorage.HighScoreDAO;
import com.example.zenix.tictactoe.datastorage.IOInterface;

public class GameBoardActivity extends AppCompatActivity {

    // Intent "handles"
    public static final String CURRENT_PLAYER_NAME = "currentPlayer";
    public static final String CURRENT_PLAYER_SCORE = "currentPlayerScore";

    private Button buttonRestart;
    private Button buttonHighScore;
    private Button buttonNewGame;
    private RecyclerView recyclerView_gameBoard;

    private Player playerOne;
    private Player playerTwo;
    private Player winningPlayer;

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
        playerOne = new Player(
                intent.getStringExtra(InputScreenActivity.PLAYER_ONE_NAME),
                0,
                GameSymbol.O
        );
        playerTwo = new Player(
                intent.getStringExtra(InputScreenActivity.PLAYER_TWO_NAME),
                0,
                GameSymbol.X
        );
    }

    private void initComponents() {
        winningPlayer = null;

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
        buttonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartGame();
            }
        });
    }

    private void startHighScoreActivity() {
        Intent intent = new Intent(this, HighScoreActivity.class);

        if (winningPlayer != null) {
            intent.putExtra(CURRENT_PLAYER_NAME, winningPlayer.getPlayerName());
            intent.putExtra(CURRENT_PLAYER_SCORE, winningPlayer.getPlayerScore());
        }

        startActivity(intent);
    }

    private void savePlayerScore(Player winningPlayer) {
        IOInterface ioInterface = new HighScoreDAO(this);
        ioInterface.addToDatabase(winningPlayer);
    }

    private void restartGame() {
        recyclerView_gameBoard.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView_gameBoard.setAdapter(new GameBoardAdapter(new GameBoard(this)));
        recyclerView_gameBoard.refreshDrawableState();
    }

    public void signalWinner(GameSymbol winningSymbol) {
        Toast.makeText(this, winningSymbol.toString() + " has won!", Toast.LENGTH_SHORT).show();
        restartGame();
    }


    public void signalDraw() {
        Toast.makeText(this, "No winner =/", Toast.LENGTH_SHORT).show();
        restartGame();
    }
}
