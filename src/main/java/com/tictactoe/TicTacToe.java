package com.tictactoe;

// Archivo: TicTacToe.java
//Clase aplicada con chat gpt

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X'; // Primer jugador
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }

    public void placePiece(int x, int y) {
        if (x < 0 || x >= 3) {
            throw new IllegalArgumentException("Coordenada X fuera de rango.");
        }
        if (y < 0 || y >= 3) {
            throw new IllegalArgumentException("Coordenada Y fuera de rango.");
        }
        if (board[x][y] != '\0') {
            throw new IllegalArgumentException("La posición ya está ocupada.");
        }

        board[x][y] = currentPlayer;
        switchPlayer();
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? '+' : 'X';
    }

    public Character checkWinner() {
        // Revisar filas
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '\0' &&
                board[i][0] == board[i][1] &&
                board[i][1] == board[i][2]) {
                return board[i][0];
            }
        }

        // Revisar columnas
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != '\0' &&
                board[0][j] == board[1][j] &&
                board[1][j] == board[2][j]) {
                return board[0][j];
            }
        }

        // Revisar diagonales
        if (board[0][0] != '\0' &&
            board[0][0] == board[1][1] &&
            board[1][1] == board[2][2]) {
            return board[0][0];
        }

        if (board[0][2] != '\0' &&
            board[0][2] == board[1][1] &&
            board[1][1] == board[2][0]) {
            return board[0][2];
        }

        // No hay ganador
        return null;
    }

    // Método auxiliar para pruebas (colocar pieza manual sin cambiar turno)
    public void forcePlace(char player, int x, int y) {
        board[x][y] = player;
    }
}
