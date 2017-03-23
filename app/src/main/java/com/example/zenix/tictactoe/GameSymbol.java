package com.example.zenix.tictactoe;

/**
 * Wrapper class for holding different symbols. X, O and EMPTY.
 * This class should be used as much as as possible, instead of Symbol.
 *
 * Needed so that collections can contain the same, mutable object. FIXME explain.
 */

public class GameSymbol {

    enum Symbol {
        EMPTY,
        X,
        O
    }
    private Symbol symbol;

    public GameSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameSymbol that = (GameSymbol) o;

        return symbol == that.symbol;

    }

    public boolean equals(Symbol o) {
        return o != null && symbol == o;
    }


    @Override
    public int hashCode() {
        return symbol != null ? symbol.hashCode() : 0;
    }
}
