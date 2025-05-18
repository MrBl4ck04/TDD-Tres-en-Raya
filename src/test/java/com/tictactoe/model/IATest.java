package com.tictactoe.model;

// Archivo: TicTacToeTest.java

import org.junit.jupiter.api.Test;

import com.tictactoe.TicTacToe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IATest {

    // Requerimiento 1
    @Test
    public void testPiezaFueraDelEjeX() {
        TicTacToe game = new TicTacToe();
        assertThrows(IllegalArgumentException.class, () -> game.placePiece(3, 1));
    }

    @Test
    public void testPiezaFueraDelEjeY() {
        TicTacToe game = new TicTacToe();
        assertThrows(IllegalArgumentException.class, () -> game.placePiece(1, -1));
    }

    @Test
    public void testPiezaEnLugarOcupado() {
        TicTacToe game = new TicTacToe();
        game.placePiece(0, 0);
        assertThrows(IllegalArgumentException.class, () -> game.placePiece(0, 0));
    }

    // Requerimiento 2
    @Test
    public void testPrimerTurnoEsX() {
        TicTacToe game = new TicTacToe();
        assertEquals('X', game.getCurrentPlayer());
    }

    @Test
    public void testTurnoAlternaXMas() {
        TicTacToe game = new TicTacToe();
        game.placePiece(0, 0); // X
        assertEquals('+', game.getCurrentPlayer());
        game.placePiece(1, 0); // +
        assertEquals('X', game.getCurrentPlayer());
    }

    // Requerimiento 3
    @Test
    public void testNoHayGanador() {
        TicTacToe game = new TicTacToe();
        game.placePiece(0, 0); // X
        game.placePiece(1, 0); // +
        game.placePiece(0, 1); // X
        assertNull(game.checkWinner());
    }

    @Test
    public void testVictoriaHorizontal() {
        TicTacToe game = new TicTacToe();
        game.forcePlace('X', 0, 0);
        game.forcePlace('X', 0, 1);
        game.forcePlace('X', 0, 2);
        assertEquals('X', game.checkWinner());
    }

    @Test
    public void testVictoriaVertical() {
        TicTacToe game = new TicTacToe();
        game.forcePlace('+', 0, 0);
        game.forcePlace('+', 1, 0);
        game.forcePlace('+', 2, 0);
        assertEquals('+', game.checkWinner());
    }

    @Test
    public void testVictoriaDiagonal() {
        TicTacToe game = new TicTacToe();
        game.forcePlace('X', 0, 0);
        game.forcePlace('X', 1, 1);
        game.forcePlace('X', 2, 2);
        assertEquals('X', game.checkWinner());
    }

    @Test
    public void testVictoriaDiagonalInvertida() {
        TicTacToe game = new TicTacToe();
        game.forcePlace('+', 0, 2);
        game.forcePlace('+', 1, 1);
        game.forcePlace('+', 2, 0);
        assertEquals('+', game.checkWinner());
    }
}
