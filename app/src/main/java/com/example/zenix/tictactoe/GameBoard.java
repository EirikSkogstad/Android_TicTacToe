package com.example.zenix.tictactoe;

import java.util.ArrayList;

public class GameBoard {

    private ArrayList<GameSymbol> board;
    private ArrayList<GameRow> rows;

    public GameBoard() {
        initBoard();
    }

    private void initBoard() {
        board = new ArrayList<>();
        for(int i = 0; i < 9; i++) {
            board.add(GameSymbol.EMPTY);
        }

    }


}
