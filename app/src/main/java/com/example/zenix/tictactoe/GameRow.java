package com.example.zenix.tictactoe;

import java.util.ArrayList;

class GameRow {
    private ArrayList<GameSymbol> symbols;

    public GameRow(GameSymbol... symbols) {
        validateInput(symbols);
        addSymbolsToList(symbols);
    }

    private static void validateInput(GameSymbol[] symbols) {
        if (symbols.length > 3 || symbols.length < 1) {
            throw new IllegalArgumentException("Illegal amount of symbols..");
        }
    }

    private void addSymbolsToList(GameSymbol[] symbols) {
        this.symbols = new ArrayList<>();
        for (GameSymbol symbol : symbols) {
            this.symbols.add(symbol);
        }
    }

    public boolean isFilled() {
        for (GameSymbol symbol : symbols) {
            if (symbol.equals(GameSymbol.Symbol.EMPTY)) {
                return false;
            }
        }
        return true;
    }

    public GameSymbol getWinner() {
        GameSymbol gameSymbol = symbols.get(0);
        for (GameSymbol symbol : symbols) {
            if (!gameSymbol.equals(symbol)) {
                return GameSymbol.EMPTY;
            }
        }
        return gameSymbol;
    }

    public boolean hasWinner() {
        return isWinner(GameSymbol.O) || isWinner(GameSymbol.X);
    }

    private boolean isWinner(GameSymbol gameSymbol) {
        return symbols.get(0) == gameSymbol
                && symbols.get(1) == gameSymbol
                && symbols.get(2) == gameSymbol;
    }

}
