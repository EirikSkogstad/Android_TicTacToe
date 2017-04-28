package com.example.zenix.tictactoe.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.zenix.tictactoe.InputValidator;
import com.example.zenix.tictactoe.R;

public class InputScreenActivity extends AppCompatActivity {

    public static final String PLAYER_ONE_NAME = "playerOneName";
    public static final String PLAYER_TWO_NAME = "playerTwoName";

    private EditText editTextPlayerOne;
    private EditText editTextPlayerTwo;
    private Button buttonPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_screen);

        initComponents();
        initListeners();
    }

    private void initComponents() {
        editTextPlayerOne = (EditText) findViewById(R.id.editText_playerOne);
        editTextPlayerTwo = (EditText) findViewById(R.id.editText_playerTwo);
        buttonPlay = (Button) findViewById(R.id.button_play);

    }

    private void initListeners() {
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlayerInputValid()) {
                    startGameBoardActivity();
                } else {
                    Toast.makeText(InputScreenActivity.this, R.string.error_empty_input, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isPlayerInputValid() {
        if (InputValidator.isEditTextEmpty(editTextPlayerOne)) {
            return false;
        }
        if (InputValidator.isEditTextEmpty(editTextPlayerTwo)) {
            return false;
        }
        // Don't allow two players with the same name.
        if (InputValidator.isEditTextContentEqual(editTextPlayerOne, editTextPlayerTwo)) {
            return false;
        }
        return true;
    }


    private void startGameBoardActivity() {
        Intent intent = new Intent(this, GameBoardActivity.class);
        intent.putExtra(PLAYER_ONE_NAME, editTextPlayerOne.getText().toString());
        intent.putExtra(PLAYER_TWO_NAME, editTextPlayerTwo.getText().toString());

        startActivity(intent);
    }
}
