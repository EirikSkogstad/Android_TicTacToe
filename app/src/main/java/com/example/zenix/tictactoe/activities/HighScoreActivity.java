package com.example.zenix.tictactoe.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.zenix.tictactoe.HighScoreAdapter;
import com.example.zenix.tictactoe.R;
import com.example.zenix.tictactoe.datastorage.FileHandler;
import com.example.zenix.tictactoe.datastorage.IOInterface;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HighScoreActivity extends AppCompatActivity {
    private Button buttonBack;
    private RecyclerView recyclerView_HighScores;

    private String currentPlayer;
    private Map<String, Integer> scores;

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
        recyclerView_HighScores = (RecyclerView) findViewById(R.id.recyclerView_highScores);
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

    private void loadHighScores() {
        IOInterface ioInterface = new FileHandler(this);
        scores = new HashMap<>();
        Map<String, Integer> testScores = new HashMap<>();
        testScores.put("Bob", 200);
        testScores.put("Bobby Carl the Fifth of his name", 13);
        testScores.put("Sam", 7);
        try {
            ioInterface.saveHighScores(testScores);
            scores = ioInterface.readHighScores();
        } catch (FileNotFoundException e) {
            Toast.makeText(this, "Problems reading HighScores. Please try entering this screen again.", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, "Problems saving highscore Test data", Toast.LENGTH_SHORT).show();
        }
    }

}
