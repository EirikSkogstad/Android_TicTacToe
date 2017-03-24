package com.example.zenix.tictactoe.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.zenix.tictactoe.Player;
import com.example.zenix.tictactoe.adapters.HighScoreAdapter;
import com.example.zenix.tictactoe.R;
import com.example.zenix.tictactoe.datastorage.HighScoreDAO;
import com.example.zenix.tictactoe.datastorage.IOInterface;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HighScoreActivity extends AppCompatActivity {
    private Button buttonBack;
    private RecyclerView recyclerView_HighScores;

    private String currentPlayer;
    private List<Player> scores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        handleIntent();
        initComponents();
        initListeners();

        loadHighScores();

        if (!scores.isEmpty()) {
            initAdapter();
        }
    }

    private void handleIntent() {
        Intent intent = getIntent();
        currentPlayer = intent.getStringExtra(GameBoardActivity.CURRENT_PLAYER);
    }

    private void initComponents() {
        buttonBack = (Button) findViewById(R.id.button_back);
        recyclerView_HighScores = (RecyclerView) findViewById(R.id.recyclerView_highScore);
        recyclerView_HighScores.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initAdapter() {
        recyclerView_HighScores.setAdapter(new HighScoreAdapter(scores));
    }

    private void initListeners() {
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    private void addTestData(HighScoreDAO highScoreDAO) {
        List<Player> data = new ArrayList<>();
        data.add(new Player("Bob", 1));
        data.add(new Player("Cesare", 400));
        data.add(new Player("Della Rovere", 3));

        highScoreDAO.saveHighScores(data);
    }

    private void loadHighScores() {
        HighScoreDAO highScoreDAO = new HighScoreDAO(this);
        addTestData(highScoreDAO);
        scores = highScoreDAO.readHighScores();
    }

}
