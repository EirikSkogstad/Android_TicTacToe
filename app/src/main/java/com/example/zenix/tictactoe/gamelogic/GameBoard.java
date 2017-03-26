package com.example.zenix.tictactoe.gamelogic;

import com.example.zenix.tictactoe.activities.GameBoardActivity;

import java.util.ArrayList;

public class GameBoard {

    private GameBoardActivity gameBoardActivity;
    private GameSymbol currentSymbol;
    private ArrayList<GameSymbol> board;
    private ArrayList<GameRow> rows;
    private boolean gameDraw;

    public GameBoard(GameBoardActivity gameBoardActivity) {
        this.gameBoardActivity = gameBoardActivity;
        initBoard();
    }

    private void initBoard() {
        currentSymbol = GameSymbol.O;
        board = new ArrayList<>();
        rows = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            board.add(i, new GameSymbol(GameSymbol.Symbol.EMPTY));
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
        board.get(index).setSymbol(currentSymbol.getSymbol());

        if (isGameOver()) {
            if (isGameDraw()) {
                // Signal acitvity, no winner.
                gameBoardActivity.signalDraw();
            } else {
                // Signal activity, currenPlayer == winner.
                gameBoardActivity.signalWinner(currentSymbol);
            }
        }
        updateCurrentSymbol();
        gameBoardActivity.toggleCurrentPlayer();
    }


    /**
     * Checks the board to see if game is over, based on two conditions:
     * 1. If a row has only X or O.
     * 2. All rows are filled.
     * @return is game over.
     */
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
        return numberOfRowsFilled == rows.size();
    }

    private void updateCurrentSymbol() {
        if (currentSymbol == GameSymbol.X) {
            currentSymbol = GameSymbol.O;
        } else {
            currentSymbol = GameSymbol.X;
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

    public int getSize() {
        return board.size();
    }

    public GameSymbol getCurrentSymbol() {
        return currentSymbol;
    }
}
