package com.tictactoe.model;

public class Move {
    public final int row, col;
    public final char mark;
    public Move(int row, int col, char mark) {
        this.row = row;
        this.col = col;
        this.mark = mark;
    }

}
