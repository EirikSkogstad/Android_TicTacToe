package com.example.zenix.tictactoe.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zenix.tictactoe.Player;
import com.example.zenix.tictactoe.R;
import com.example.zenix.tictactoe.adapters.GameBoardAdapter;
import com.example.zenix.tictactoe.datastorage.HighScoreDAO;
import com.example.zenix.tictactoe.datastorage.IOInterface;
import com.example.zenix.tictactoe.gamelogic.GameBoard;
import com.example.zenix.tictactoe.gamelogic.GameSymbol;

public class GameBoardActivity extends AppCompatActivity {

    // Intent "handles"
    public static final String CURRENT_PLAYER_NAME = "currentPlayer";
    public static final String CURRENT_PLAYER_SCORE = "currentPlayerScore";

    private Button buttonRestart;
    private Button buttonHighScore;
    private Button buttonNewGame;
    private RecyclerView recyclerView_gameBoard;
    private TextView textView_currentPlayer;

    private Player playerOne;
    private Player playerTwo;
    private Player currentPlayer;
    private IOInterface ioInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_board);

        handleIntent();
        initComponents();
        initListeners();
        loadPreviousScores();

        restartGame();
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
        buttonRestart = (Button) findViewById(R.id.button_restart);
        buttonHighScore = (Button) findViewById(R.id.button_high_score);
        buttonNewGame = (Button) findViewById(R.id.button_new_game);
        textView_currentPlayer = (TextView) findViewById(R.id.textView_currentPlayer);
        recyclerView_gameBoard = (RecyclerView) findViewById(R.id.recyclerView_gameBoard);
        recyclerView_gameBoard.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView_gameBoard.setAdapter(new GameBoardAdapter(new GameBoard(this)));

        this.ioInterface = new HighScoreDAO(this);
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

        if (currentPlayer != null) {
            intent.putExtra(CURRENT_PLAYER_NAME, currentPlayer.getPlayerName());
            intent.putExtra(CURRENT_PLAYER_SCORE, currentPlayer.getPlayerScore());
        }

        startActivity(intent);
    }

    private void restartGame() {
        currentPlayer = playerOne;
        updateCurrentPlayerText();
        recyclerView_gameBoard.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView_gameBoard.setAdapter(new GameBoardAdapter(new GameBoard(this)));
        recyclerView_gameBoard.refreshDrawableState();
    }

    private void updateCurrentPlayerText() {
        textView_currentPlayer.setText("Current Player: " + this.currentPlayer.getGameSymbol() + ": " + this.currentPlayer.getPlayerName());
    }

    private void saveScores() {
        ioInterface.addPLayer(currentPlayer);
    }

    private void loadPreviousScores() {
        playerOne.setPlayerScore(ioInterface.readPlayerScore(playerOne));
        playerTwo.setPlayerScore(ioInterface.readPlayerScore(playerTwo));
    }

    public void toggleCurrentPlayer() {
        if (currentPlayer == playerOne) {
            currentPlayer = playerTwo;
        } else {
            currentPlayer = playerOne;
        }
        updateCurrentPlayerText();
    }

    public void signalWinner(GameSymbol winningSymbol) {
        Toast.makeText(this, currentPlayer.getPlayerName() + " has won!", Toast.LENGTH_SHORT).show();
        currentPlayer.setPlayerScore(currentPlayer.getPlayerScore() + 1);
        saveScores();
        restartGame();
    }

    public void signalDraw() {
        Toast.makeText(this, "No winner =/", Toast.LENGTH_SHORT).show();
        restartGame();
    }
}
