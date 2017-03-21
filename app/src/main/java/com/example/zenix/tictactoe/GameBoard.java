package com.example.zenix.tictactoe;

import java.util.ArrayList;

public class GameBoard {

    private GameSymbol currentPlayer;
    private ArrayList<GameSymbol> board;
    private ArrayList<GameRow> rows;
    private boolean gameDraw;

    public GameBoard() {
        initBoard();
    }

    private void initBoard() {
        board = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
            board.add(GameSymbol.EMPTY);
        }

        // Horizontal
        rows.add(new GameRow(board.get(0), board.get(1), board.get(2)));
        rows.add(new GameRow(board.get(3), board.get(4), board.get(5)));
        rows.add(new GameRow(board.get(6), board.get(7), board.get(8)));

        // Vertical
        rows.add(new GameRow(board.get(0), board.get(3), board.get(6)));
        rows.add(new GameRow(board.get(1), board.get(4), board.get(7)));
        rows.add(new GameRow(board.get(2), board.get(5), board.get(8)));

        // Diagonal
        rows.add(new GameRow(board.get(0), board.get(4), board.get(8)));
        rows.add(new GameRow(board.get(2), board.get(4), board.get(6)));
    }

    public void updateBoard(int index) {
        board.set(index, currentPlayer);


        if (isGameOver()) {
            if (isGameDraw()) {
                // Signal acitvity, no winner.
            }
            else {
                // Signal activity, currenPlayer == winner.
            }
        }
        updateCurrentPlayer();
    }


    private boolean isGameOver() {
        int numberOfRowsFilled = 0;
        for (GameRow row : rows) {
            if (row.isFilled()) {
                numberOfRowsFilled++;
                if (row.hasWinner()) {
                    return true;
                }
            }
        }
        if (numberOfRowsFilled == rows.size()) {
            return true;
        }
        return false;
    }

    private void updateCurrentPlayer() {
        if (currentPlayer == GameSymbol.X) {
            currentPlayer = GameSymbol.O;
        }
        else {
            currentPlayer = GameSymbol.X;
        }
    }

    private boolean isGameDraw() {
        for (GameRow row : rows) {
            if (row.hasWinner()) {
                return false;
            }
        }
        return true;
    }
}
