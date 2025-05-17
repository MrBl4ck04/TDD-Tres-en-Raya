// src/main/java/com/tictactoe/model/ConsolePlayer.java
package com.tictactoe.model;

import java.util.Scanner;

public class ConsolePlayer implements Player {
    private final char mark;
    private final Scanner sc;

    public ConsolePlayer(char mark, Scanner sc) {
        this.mark = mark;
        this.sc   = sc;
    }

    @Override
    public Move nextMove(Board board) {
        while (true) {
            System.out.printf("Jugador %c, ingresa fila y columna (0–2): ", mark);
            int row = sc.nextInt();
            int col = sc.nextInt();
            try {
                // validamos coordenadas y ocupación a través de Board
                if (board.obtenerCasilla(row, col) != null) {
                    System.out.println("Casilla ocupada, elige otra.");
                    continue;
                }
                return new Move(row, col, mark);
            } catch (IllegalArgumentException ex) {
                System.out.println("Coordenadas inválidas, intenta de nuevo.");
            }
        }
    }

    @Override
    public char getMark() {
        return mark;
    }
}
