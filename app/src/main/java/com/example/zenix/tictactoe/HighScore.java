package com.example.zenix.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.util.LinkedHashMap;

public class HighScore extends AppCompatActivity {

    private Button buttonBack;
    private RecyclerView recyclerView_HighScores;

    private String currentPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        handleIntent();
        initComponents();
        initListeners();

        loadHighScores();
    }

    private void handleIntent() {
        Intent intent = getIntent();
        currentPlayer = intent.getStringExtra(GameBoard.CURRENT_PLAYER);
    }

    private void initComponents() {
        buttonBack = (Button) findViewById(R.id.button_back);
        recyclerView_HighScores = (RecyclerView) findViewById(R.id.recyclerView_highScores);
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
        FileHandler fileHandler = new FileHandler(this);
        getLayoutInflater();
        try {
            fileHandler.readHighScores();
        } catch (FileNotFoundException e) {
            Toast.makeText(this, "Problems reading HighScores. Please try entering this screen again.", Toast.LENGTH_SHORT).show();
        }
    }

}
