package com.example.zenix.tictactoe.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.zenix.tictactoe.gamelogic.GameBoard;
import com.example.zenix.tictactoe.R;

public class GameBoardAdapter extends android.support.v7.widget.RecyclerView.Adapter<GameBoardAdapter.ViewHolder> {
    private GameBoard gameBoard;

    public GameBoardAdapter(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.layout_game_board_button, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindContent(position, gameBoard);
    }

    @Override
    public int getItemCount() {
        return gameBoard.getSize();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private int gameButtonPosition;
        private Button gameButton;
        private boolean hasGameButtonBeenPressed = false;

        public ViewHolder(View view) {
            super(view);
            this.gameButton = (Button) view.findViewById(R.id.button_gameButton);
        }

        void bindContent(final int gameButtonPosition, final GameBoard gameBoard) {
            this.gameButtonPosition = gameButtonPosition;

            gameButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!hasGameButtonBeenPressed) {
                        gameButton.setText(gameBoard.getCurrentSymbol().toString());
                        gameBoard.updateBoard(gameButtonPosition);
                        hasGameButtonBeenPressed = true;
                    }
                }
            });
        }
    }



}
