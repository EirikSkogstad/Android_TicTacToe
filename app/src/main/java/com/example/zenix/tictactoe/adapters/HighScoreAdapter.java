package com.example.zenix.tictactoe.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.HapticFeedbackConstants;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zenix.tictactoe.PlayerData;
import com.example.zenix.tictactoe.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Used in HighScoreActivity's RecyclerView
 */
public class HighScoreAdapter extends android.support.v7.widget.RecyclerView.Adapter<HighScoreAdapter.ViewHolder> {

    private List<PlayerData> scores;
    private LayoutInflater layoutInflater;

    public HighScoreAdapter(Map<String, Integer> scoresMap) {
        initScoresList(scoresMap);
    }

    private void initScoresList(Map<String, Integer> scoresMap) {
        List<PlayerData> scores = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : scoresMap.entrySet()) {
            scores.add(new PlayerData(entry.getKey(), entry.getValue()));
        }
        sortScores(scores);
        this.scores = scores;
    }

    private void sortScores(List<PlayerData> scores) {
        Collections.sort(scores, new Comparator<PlayerData>() {
            @Override
            public int compare(PlayerData o1, PlayerData o2) {
                if (o1.getPlayerScore() < o2.getPlayerScore()) {
                    return 1;
                }
                if (o1.getPlayerScore() == o2.getPlayerScore()) {
                    return 0;
                }
                return -1;
            }
        });
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.layout_high_score, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindContent(scores.get(position));
    }

    @Override
    public int getItemCount() {
        return scores.size();
    }

    // Creds for guide: https://www.raywenderlich.com/126528/android-recyclerview-tutorial
    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView textViewPlayerName;
        private TextView textViewPlayerScore;

        public ViewHolder(View view) {
            super(view);

            textViewPlayerName = (TextView) view.findViewById(R.id.textView_playerName);
            textViewPlayerScore = (TextView) view.findViewById(R.id.textView_playerScore);
            view.setOnClickListener(this);
        }

        public void bindContent(PlayerData playerData) {
            textViewPlayerName.setText(playerData.getPlayerName());
            textViewPlayerScore.setText(playerData.getPlayerScoreAsString());
        }

        @Override
        public void onClick(View v) {
            v.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
        }
    }

}
