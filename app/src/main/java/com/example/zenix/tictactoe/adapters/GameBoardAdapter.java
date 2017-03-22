package com.example.zenix.tictactoe.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.zenix.tictactoe.GameSymbol;

import java.util.ArrayList;

public class GameBoardAdapter extends android.support.v7.widget.RecyclerView.Adapter<GameBoardAdapter.ViewHolder> {
    private ArrayList<GameSymbol> gameSymbols;

    public GameBoardAdapter(ArrayList<GameSymbol> gameSymbols) {
        this.gameSymbols = gameSymbols;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }



}
