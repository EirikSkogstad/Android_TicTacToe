package com.example.zenix.tictactoe;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.LinkedHashMap;

/**
 * Used in HighScore's RecyclerView
 */
public class HighScoreAdapter extends RecyclerView.Adapter {

    private LinkedHashMap<String, Integer> scores;
    private LayoutInflater layoutInflater;

    public HighScoreAdapter(LayoutInflater layoutInflater, LinkedHashMap<String, Integer> scores) {
        this.scores = scores;
        this.layoutInflater = layoutInflater;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        layoutInflater.inflate();
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

}
