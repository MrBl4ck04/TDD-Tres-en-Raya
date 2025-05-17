package com.tictactoe.model;

public interface Player {
    Move nextMove(Board board);
    char getMark();
}
