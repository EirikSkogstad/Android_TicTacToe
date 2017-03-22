package com.example.zenix.tictactoe.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.zenix.tictactoe.GameBoard;
import com.example.zenix.tictactoe.GameSymbol;
import com.example.zenix.tictactoe.R;

import java.util.ArrayList;

public class GameBoardAdapter extends android.support.v7.widget.RecyclerView.Adapter<GameBoardAdapter.ViewHolder> {
    private ArrayList<GameSymbol> gameSymbols;
    private GameBoard gameBoard;

    public GameBoardAdapter(ArrayList<GameSymbol> gameSymbols, GameBoard gameBoard) {
        this.gameBoard = gameBoard;
        this.gameSymbols = gameSymbols;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindContent(position, gameBoard);
    }

    @Override
    public int getItemCount() {
        return gameSymbols.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private int gameButtonPosition;
        private Button gameButton;

        public ViewHolder(View view) {
            super(view);
            this.gameButton = (Button) view.findViewById(R.id.button_gameButton);
        }

        public void bindContent(int gameButtonPosition, GameBoard gameBoard) {
            this.gameButtonPosition = gameButtonPosition;
            gameButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }



}
