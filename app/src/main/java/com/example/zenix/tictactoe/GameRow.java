package com.example.zenix.tictactoe;

import java.util.ArrayList;

class GameRow {
    private ArrayList<GameSymbol> symbols;

    public GameRow(int index1, int index2, int index3) {
        this.symbols = new ArrayList<>();
        symbols.add(index1);
        symbols.add(index2);
        symbols.add(index3);
    }

    public boolean isFilled() {

    }

}
